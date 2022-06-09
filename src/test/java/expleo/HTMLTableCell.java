package expleo;

import org.openqa.selenium.WebElement;

public class HTMLTableCell {

    private final WebElement cellElement;

    public HTMLTableCell(final WebElement cellElement) {
        this.cellElement = cellElement;
    }

    public WebElement webElement() {
        return cellElement;
    }

    public String content() {
        return cellElement.getText();
    }

    @Override
    public String toString() {
        return "[htmlTableCell {data:" + this.content() + "}]";
    }

    public String getValue() {
        return cellElement.getText();
    }
   
}
