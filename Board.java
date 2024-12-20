public class Board {

    private static final int EMPTY = 0;
    private static final int DEFAULT_ROWS = 6;
    private static final int DEFAULT_COLUMNS = 7;
    
    private int[][] grid;

    public Board() {
        this.grid = new int[DEFAULT_ROWS][DEFAULT_COLUMNS];
    }

    public Board(int rows, int columns) {
        this.grid = new int[rows][columns];
    }

    public int getNumRows() {
        return grid.length;
    }

    public int getNumColumns() {
        return grid[0].length;
    }

    public boolean rowIsValid(int row) {
        return row >= 0 && row < grid.length;
    }

    public boolean columnIsValid(int column) {
        return column >= 0 && column < grid[0].length;
    }

    public boolean locationIsValid(int row, int column) {
        return rowIsValid(row) && columnIsValid(column);
    }

    public boolean placeMarker(int row, int column, int marker) {
        if (!locationIsValid(row, column)) {
            return false;
        }

        grid[row][column] = marker;
        return true;
    }

    public int getMarker(int row, int col) {
        return grid[row][col];
    }

    public boolean locationIsEmpty(int row, int column) {
        return grid[row][column] == EMPTY;
    }

    public int[] getRow(int row) {
        int[] slice = new int[grid[row].length];

        for (int i = 0; i < grid[row].length; i++) {
            slice[i] = grid[row][i];
        }

        return slice;

        //return Arrays.copyOf(grid[row], grid[row].length);  // Maybe better, but not in AP Java language subset
    }

    public int[] getColumn(int column) {
        int[] slice = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            slice[i] = grid[i][column];
        }

        return slice;
    }

    public int[] getLeftDiagonal(int row, int column) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int offsetToStart = Math.min(row, column);

        int startRow = row - offsetToStart;
        int startCol = column - offsetToStart;
        int numItems = Math.min(numRows - startRow, numCols - startCol);

        int[] slice = new int[numItems];

        for (int i = 0; i < slice.length; i++) {
            slice[i] = grid[startRow + i][startCol + i];
        }

        return slice;
    }

    public int[] getRightDiagonal(int row, int column) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int offsetToStart = Math.min(row, numCols - column - 1);

        int startRow = row - offsetToStart;
        int startCol = column + offsetToStart;
        int numItems = Math.min(numRows - startRow, startCol + 1);

        int[] slice = new int[numItems];

        for (int i = 0; i < slice.length; i++) {
            slice[i] = grid[startRow + i][startCol - i];
        }

        return slice;
    } 

    public void reset() {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                grid[row][column] = EMPTY;
            }
        }
    }

    public String toString() {
        // StringBuilder more efficient, but not in AP Java Language Subset
        
        String str = "";

        for (int[] row: grid) {
            for (int col: row) {
                str += col + " ";
            }
            str += "\n";
        }

        return str.trim();
    }
}