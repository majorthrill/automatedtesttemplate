package expleo.mappings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.Given;
import expleo.HTMLTable;
import expleo.HTMLTableCell;
import expleo.HTMLTableRow;
import expleo.NameValuePair;
import expleo.TableCell;
import expleo.TableHeaderCell;
import expleo.TableRow;
import expleo.config.AutomationContext;
import expleo.config.HarnessConfiguration;
import expleo.config.SpringContextConfig;
import io.cucumber.datatable.DataTable;

@ContextConfiguration(classes = { SpringContextConfig.class, HarnessConfiguration.class })
@DirtiesContext

public class TestMapping {

	private static Logger log = Logger.getLogger(TestMapping.class.getCanonicalName());

	@Autowired
	public AutomationContext context;
	private WebDriver driver = null;


	@Given(value = "launch a browser.")
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window();
		context.setWebdriver(driver);
	}

	@Given(value = "navigate to the address: '(.*)'")
	public void goToUrl(String url) {
		context.getDriver().get(url);

	}

	@Given(value = "click on the '(.*)'.")
	public void clickElement(String identifierText) {
		By identifier = PageObject.findObjectByName(identifierText).getObjectlocater();
		context.getDriver().findElement(identifier).click();
	}

	@Given(value = "verify that the '(.*)' is visible and is active.")
	public void verifyElement(String identifierText) {
		verifyElement(identifierText, null, null);
		
	}
	@Given(value = "verify that the '(.*)' is visible and is active with a width of '(.*)' and height of '(.*)'.")
	public void verifyElement(String identifierText, String width, String height) {
		String errors = context.getErrors();
		List<WebElement> elements = driver.findElements(PageObject.findObjectByName(identifierText).getObjectlocater());
		System.out.println("Found " + elements.size() + " elements matching "
				+ PageObject.findObjectByName(identifierText).getObjectlocater());
		WebElement element = null;

		if (elements.size() > 1) {
			for (WebElement we : elements) {
				if (we.getAttribute("class")
						.equalsIgnoreCase(PageObject.findObjectByName(identifierText).getClassName())) {
					log.info("Looking for " + identifierText + "    " + we.getAttribute("class") + " - found it");
					element = we;
					break;
				}
			}
			if (element == null) {
				errors = errors + "\nFound multiple instances of " + identifierText
						+ " but was unable to locate the correct one.";
				System.out.println(errors);
			}
		}

		if (elements.size() == 0) {
			errors = errors + ("\n" + identifierText + "not found.");
		}
		if (elements.size() == 1) {
			System.out.println("Only one element found with that identifier. Using this one.");
			element = elements.get(0);
		}

		if (!element.isDisplayed()) {
			errors = errors + "\nElement named " + identifierText + " was found but is not displayed.";
		}
		if (!element.isEnabled()) {
			errors = errors + "\nElement named " + identifierText + " was found but is not enabled.";
		}
		System.out.println(element.getSize().width);
		if(width!=null) {
			if(!Integer.valueOf(width).equals(element.getSize().width)) {
				errors = errors + "\n Expected " + identifierText + "to have a width of " + width + " but it was actually " + element.getSize().width;
			}
		}

		if(height!=null) {
			if(!Integer.valueOf(height).equals(element.getSize().height)) {
				errors = errors + "\n Expected " + identifierText + "to have a height of " + height + " but it was actually " + element.getSize().height;
			}
		}
		
		context.setErrorsText(errors);
	}

	@Given(value = "verify that the '(.*)' contains one of the expected values.")
	public void checkElementText(String identifierText) {
		String errors = context.getErrors();
		boolean passed = false;
		By identifier = PageObject.findObjectByName(identifierText).getObjectlocater();
		String elementText = context.getDriver().findElement(identifier).getText();
		List<String> expectedButtonTexts = Arrays.asList("foo", "bar", "baz", "qux");
		for (String expectedValue : expectedButtonTexts) {
			if (elementText.equals(expectedValue)) {
				log.info(identifierText + " contained a match for " + elementText + " in the list of expected values.");
				passed = true;
				break;
			}
		}
		if (!passed) {
			log.warning(
					identifierText + " element text : " + elementText + " did not match any of the expected values.");
			errors = errors + "\nExpected the button text of " + identifierText + " to be one of " + expectedButtonTexts
					+ " but no match was found.";
		}
		context.setErrorsText(errors);

	}

	@Given(value = "verify the table contents:")
	public void checkTableContents(DataTable dataTable) {
		String errors = context.getErrors();
		HTMLTable table = new HTMLTable(
				context.getDriver().findElement(PageObject.findObjectByName("Table").getObjectlocater()));
		List<HTMLTableRow> rows = table.getTableRows();
		List<TableHeaderCell> headers = table.getHeaders();


		for (TableHeaderCell header : headers) {
			List<String> htmlTableValues = new ArrayList<String>();
			List<String> dataTableValues = new ArrayList<String>();
			for (HTMLTableRow row : rows) {
				htmlTableValues.add(row.getCell(table, header.caption()).getValue());
			}
			for (Map<String, String> map : dataTable.asMaps()) {
				dataTableValues.add(map.get(header.caption()));
			}
			if(htmlTableValues.size()!=dataTableValues.size()) {
				errors = errors + "\n Mismatch in the number of values expected Vs contained in the table. Expected " + dataTableValues.size() + "but there were " + htmlTableValues.size() + " in the HTML table";
			}
			for(int i=1; i<dataTableValues.size(); i++) {
				if(!dataTableValues.get(i).equals(htmlTableValues.get(i))){
					errors=errors+"\n Mismatch in values at row " + i + "in the " + header.caption() + " column. Expected " + dataTableValues.get(i) + " but the html table contained " + htmlTableValues.get(i);
				}
			}
			
		}
		context.setErrorsText(errors);
	}
	
	
	@Given(value = "click the edit and delete buttons on the table.")
	public void clickEditDelete() {
		String errors = context.getErrors();
		HTMLTable table = new HTMLTable(context.getDriver().findElement(PageObject.findObjectByName("Table").getObjectlocater()));
		List<HTMLTableRow> rows = table.getTableRows();
		List<TableHeaderCell> headers = table.getHeaders();

		for(HTMLTableRow row : rows) {
			HTMLTableCell cell = row.getCell(table, "Action");
			cell.webElement().findElement(By.linkText("edit")).click();
			if(!driver.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/challenging_dom#edit")) {
				errors=errors+"\n Expected clicking edit to direct the driver to https://the-internet.herokuapp.com/challenging_dom#edit but the current url is " + driver.getCurrentUrl();
			}
			cell.webElement().findElement(By.linkText("delete")).click();
			if(!driver.getCurrentUrl().equalsIgnoreCase("https://the-internet.herokuapp.com/challenging_dom#delete")) {
				errors=errors+"\n Expected clicking delete to direct the driver to https://the-internet.herokuapp.com/challenging_dom#delete but the current url is " + driver.getCurrentUrl();
			}

		}

		context.setErrorsText(errors);
	}
	

	@Given(value = "verify that the '(.*)' contains leading whitespace.")
	public void checkElementTextWhitespace(String identifierText) throws InterruptedException {
		By identifier = PageObject.findObjectByName(identifierText).getObjectlocater();
		WebElement element = context.getDriver().findElement(identifier);
		String script = "return window.getComputedStyle(document.querySelector('.analyzer_search_inner.tooltipstered'),':before').getPropertyValue('content')";
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String content = (String) js.executeScript(script);
        System.out.println(content);

	}

	@Given(value = "close the browser.")
	public void closeBrowser() {
		context.getDriver().close();
	}

}
