package expleo;

import org.openqa.selenium.WebElement;

public class TableCell {

    private final WebElement cellElement;

    public TableCell(final WebElement cellElement) {
        this.cellElement = cellElement;
    }

    public WebElement webElement() {
        return cellElement;
    }

    public String data() {
        return cellElement.getText();
    }

}
