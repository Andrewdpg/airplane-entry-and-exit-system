package entity;

public class Location {

    private int row;
    private String column;

    public Location(int row, String column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public int getColumnValue() {
        return column.charAt(0)-64;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return row+column;
    }
}
