package expleo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HTMLTableRow {

    private WebElement webElement;
    private List<HTMLTableCell> columnCells;

    public HTMLTableRow(final WebElement webElement) {
        this.webElement = webElement;
        columnCells = new ArrayList<HTMLTableCell>();

        for (final WebElement tableCellWebElement : webElement.findElements(By.xpath(".//td"))) {
            columnCells.add(new HTMLTableCell(tableCellWebElement));
        }
    }

    public WebElement getElement() {
        return webElement;
    }

    /**
     * Gets cell within row
     * 
     * @param position
     *            cell position, starts at 1
     * @return
     */
    public HTMLTableCell getTableCell(int position) {
        return columnCells.get(position - 1);
    }

    /**
     * Get the value in a cell
     * 
     * @param htmlTable
     * @param columnHeader
     * @return
     */

    public HTMLTableCell getCell(HTMLTable htmlTable, String columnHeader) {
        TableHeaderCell headerCell = htmlTable.getHeader(columnHeader);
        int columnPosition = headerCell.columnPosition();
        return getTableCell(columnPosition);
    }

    public String getCellValue(HTMLTable htmlTable, String columnHeader) {
        TableHeaderCell headerCell = htmlTable.getHeader(columnHeader);
        int columnPosition = headerCell.columnPosition();
        return getTableCell(columnPosition).content();
    }

}
