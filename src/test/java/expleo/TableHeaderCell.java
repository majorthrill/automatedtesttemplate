package expleo;

import org.openqa.selenium.WebElement;


public class TableHeaderCell {

    private WebElement tableHeaderElement;
    private int position;

    public TableHeaderCell(final WebElement webElement, int position) {
        this.tableHeaderElement = webElement;
        this.position = position;
    }

    /**
     * @return column position of cell (starting from 1)
     */
    public int columnPosition() {
        return position;
    }

    /**
     * 
     * @return header caption
     */
    public String caption() {
        return tableHeaderElement.getText();
    }
}
