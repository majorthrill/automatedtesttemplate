package expleo.config;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationContext {
    private WebDriver driver = null;
	private String testErrors = "";
	
	@Before
    public void setUp() {
    	System.out.println("Setting up tests.");
    }

	public void setWebdriver(WebDriver driver) {
		this.driver=driver;
	}
	
    public WebDriver getDriver(){
        return driver;
    }    

    public String getErrors() {
    	return testErrors;
    }
    
    public void setErrorsText(String text) {
    	testErrors = text;
    }

    @After
    public void checkErrors() {
    	Assert.assertTrue("The following errors were found: \n" + testErrors, testErrors.length()==0);
    	driver.close();
    }
    
    
}
