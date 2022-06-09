package expleo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableRow {

    private WebElement webElement;
    private List<TableCell> columnCells;

    public TableRow(final WebElement webElement) {
        this.webElement = webElement;
        columnCells = new ArrayList<TableCell>();

        for (final WebElement tableCellWebElement : webElement.findElements(By.xpath("//td"))) {
            columnCells.add(new TableCell(tableCellWebElement));
        }
    }

    public WebElement getElement() {
        return webElement;
    }

    public List<TableCell> getCells() {
        return columnCells;
    }
}
