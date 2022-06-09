package expleo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Represents a html table
 * 
 * @author Glen Moran
 */

public class HTMLTable {

    private WebElement tableElement;
    private List<TableHeaderCell> tableHeaders;

    public HTMLTable(final WebElement theTableElement) {
        tableElement = theTableElement;
        tableHeaders = new ArrayList<TableHeaderCell>();
    }

    public String getCellValue(int rowIndex, String columnHeader) {
        List<HTMLTableRow> rows = getTableRows();
        HTMLTableRow row = rows.get(rowIndex);
        TableHeaderCell headerCell = getHeader(columnHeader);
        int columnPosition = headerCell.columnPosition();
        return row.getTableCell(columnPosition).content();

    }

    /**
     * Returns the first row position which matches the given lookup parameters
     * 
     */
    public int getRowPosition(String lookupValue1, String lookupHeader1, String lookupValue2, String lookupHeader2) {
        List<HTMLTableRow> rows = getTableRows();
        for (int i = 0; i < rows.size(); i++) {
            HTMLTableRow row = rows.get(i);
            if (getCellValue(row, lookupHeader1).equals(lookupValue1) && getCellValue(row, lookupHeader2).equals(lookupValue2)) {
                return i;

            }
        }
        return -1;
    }

    /**
     * Gets a row using 2 sets of lookup values
     */

    public List<HTMLTableRow> getTableRowsContaining(final String lookupValue1, final String lookupHeader1, final String lookupValue2,
            final String lookupHeader2) {
        int columnPosition1 = getColumnPosition(lookupHeader1);
        int columnPosition2 = getColumnPosition(lookupHeader2);
        return getTableRowsContaining(lookupValue1, columnPosition1, lookupValue2, columnPosition2);
    }

    public List<HTMLTableRow> getTableRowsContaining(final String lookupValue1, final int lookupHeader1, final String lookupValue2,
            final int lookupHeader2) {
        final List<HTMLTableRow> rows = new ArrayList<HTMLTableRow>();
        for (final HTMLTableRow row : getTableRows()) {
            if (row.getTableCell(lookupHeader1).content().contains(lookupValue1) && row.getTableCell(lookupHeader2).content().contains(lookupValue2)) {
                rows.add(row);
            }
        }
        return rows;
    }

    public boolean isValuePresent(String lookupValue) {
        List<HTMLTableRow> affiliateRows = getTableRowContaining(lookupValue);
        return (affiliateRows.size() == 1);
    }

    public String getCellValue(String rowLookupValue, String columnHeader) {
        TableHeaderCell verifiedSalesHeader = getHeader(columnHeader);
        int columnPosition = verifiedSalesHeader.columnPosition();
        List<HTMLTableRow> rows = getTableRowContaining(rowLookupValue);
        String value = rows.get(0).getTableCell(columnPosition).content();
        return value;
    }

    public String getCellValue(HTMLTableRow row, String columnHeader) {
        TableHeaderCell verifiedSalesHeader = getHeader(columnHeader);
        int columnPosition = verifiedSalesHeader.columnPosition();
        String value = row.getTableCell(columnPosition).content();
        return value;
    }

    public String getCellValue(final String lookupCellValue, final String lookupColumnHeader, final String targetColumnHeader) {
        // Get target Row
        int lookupColumnPosition = getColumnPosition(lookupColumnHeader);
        HTMLTableRow targetRow = getTableRowContaining(lookupCellValue, lookupColumnPosition).get(0);
        // get target column
        TableHeaderCell targetHeaderCell = getHeader(targetColumnHeader);
        int targetColumnPosition = targetHeaderCell.columnPosition();
        // Get target value
        String value = targetRow.getTableCell(targetColumnPosition).content();
        return value;
    }

    public void clickCheckbox(String rowLookupValue, String columnHeader) {
        TableHeaderCell approvedHeader = getHeader(columnHeader);
        int approvedColumnPosition = approvedHeader.columnPosition();
        clickCheckbox(rowLookupValue, approvedColumnPosition);
    }

    public void clickCheckbox(String rowLookupValue, int approvedColumnPosition) {
        List<HTMLTableRow> rows = getTableRowContaining(rowLookupValue);
        HTMLTableRow tableRow = rows.get(0);
        HTMLTableCell tableCell = tableRow.getTableCell(approvedColumnPosition);
        WebElement elementInCell = tableCell.webElement().findElement(By.cssSelector("input[type=checkbox]"));
        if (!elementInCell.isSelected()) {
            elementInCell.click();
        }
    }

    public void tickCheckbox(String lookupValue1, String lookupColumn1, String lookupValue2, String lookupColumn2, String tickboxColumnText) {
        TableHeaderCell tickboxHeader = getHeader(tickboxColumnText);
        int tickboxColumnPosition = tickboxHeader.columnPosition();
        List<HTMLTableRow> rows = getTableRowsContaining(lookupValue1, lookupColumn1, lookupValue2, lookupColumn2);
        HTMLTableRow tableRow = rows.get(0);
        HTMLTableCell tableCell = tableRow.getTableCell(tickboxColumnPosition);
        WebElement elementInCell = tableCell.webElement().findElement(By.cssSelector("input[type=checkbox]"));
        if (!elementInCell.isSelected()) {
            elementInCell.click();
        }

    }

    public void clickCheckbox(String rowLookupValue, int lookupColumnPosition, int approvedColumnPosition) {
        List<HTMLTableRow> rows = getTableRowContaining(rowLookupValue, lookupColumnPosition);
        HTMLTableRow tableRow = rows.get(0);
        HTMLTableCell tableCell = tableRow.getTableCell(approvedColumnPosition);
        WebElement elementInCell = tableCell.webElement().findElement(By.cssSelector("input[type=checkbox]"));
        elementInCell.click();
    }

    public TableHeaderCell getHeader(final String headerCaption) {

        if (tableHeaders.isEmpty()) {
            generateTableHeaders();
        }

        for (final TableHeaderCell tableHeader : tableHeaders) {
            if (tableHeader.caption().equalsIgnoreCase(headerCaption)) {
                return tableHeader;
            }
        }
        throw new IllegalStateException("Table header with caption " + headerCaption + " not found");
    }

    private void generateTableHeaders() {
        List<WebElement> tableHeaderWebElements = tableElement.findElements(By.xpath(".//thead/tr/th"));

        int position = 1;
        for (final WebElement tableHeader : tableHeaderWebElements) {
            tableHeaders.add(new TableHeaderCell(tableHeader, position++));
        }
    }

    public HTMLTableCell getCell(int rowIndex, int colIndex) {
        return new HTMLTableCell(tableElement.findElement(By.xpath(String.format(".//tr[%d]/td[%d]", rowIndex, colIndex))));
    }

    public List<HTMLTableRow> getTableRows() {
        List<WebElement> rowsAsWebElements = tableElement.findElements(By.xpath(String.format(".//tbody/tr")));
        List<HTMLTableRow> rows = new ArrayList<HTMLTableRow>();

        // Add all rows
        for (final WebElement tableRow : rowsAsWebElements) {
            rows.add(new HTMLTableRow(tableRow));
        }
        // Return rows
        return rows;
    }

    public HTMLTableRow getTableRow(int i) {
        List<WebElement> rowsAsWebElements = tableElement.findElements(By.xpath(String.format(".//tbody/tr")));
        List<HTMLTableRow> rows = new ArrayList<HTMLTableRow>();

        // Add all rows
        for (final WebElement tableRow : rowsAsWebElements) {
            rows.add(new HTMLTableRow(tableRow));
        }
        // Return target row
        return rows.get(i);
    }

    public List<HTMLTableRow> getTableRowContaining(final String searchText) {
        final List<HTMLTableRow> rows = new ArrayList<HTMLTableRow>();
        for (final HTMLTableRow row : getTableRows()) {
            /*
             * if(searchText == null){ row.getElement().getText().contains(" ");
             * rows.add(row); } else{ if
             * (row.getElement().getText().contains(searchText)) {
             * rows.add(row); }
             */
            if (row.getElement().getText().contains(searchText)) {
                rows.add(row);
            }
        }

        return rows;
    }

    public List<HTMLTableRow> getTableRowContaining(final String searchText, String searchColumnCaption) {
        int columnPosition = getColumnPosition(searchColumnCaption);
        return getTableRowContaining(searchText, columnPosition);
    }

    public List<HTMLTableRow> getTableRowContaining(final String searchText, int searchColumnIndex) {
        final List<HTMLTableRow> rows = new ArrayList<HTMLTableRow>();
        for (final HTMLTableRow row : getTableRows()) {
            if (row.getTableCell(searchColumnIndex).content().contains(searchText)) {
                rows.add(row);
            }
        }
        return rows;
    }

    public List<TableHeaderCell> getHeaders() {

        // check that the tableHeaders list has been created- if not then create
        // it
        if (tableHeaders.isEmpty()) {
            generateTableHeaders();
        }

        return this.tableHeaders;

    }

    public int getColumnPosition(String headerName) {
        for (int i = 0; i < getHeaders().size(); i++) {
            if (tableHeaders.get(i).caption().equals(headerName))
                return tableHeaders.get(i).columnPosition();
        }
        return -1;
    }

    public void doCellClick(final String lookupName) {
        List<HTMLTableRow> tableRow = getTableRowContaining(lookupName);
        assert !tableRow.isEmpty() : "Unable to find cell by lookup: " + lookupName;
        HTMLTableCell cell = tableRow.get(0).getTableCell(1);
        cell.webElement().click();
    }

}
