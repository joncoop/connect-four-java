public class Game {

    private final int PLAYER_1 = 1;
    private final int PLAYER_2 = 2;
    
    private Board board;
    private int winStreakLength;
    private int currentPlayer;

    public Game() {
        board = new Board();
        winStreakLength = 4;
        currentPlayer = 1;
    }

    public boolean columnIsAvailable(int column) {
        return board.columnIsValid(column) && board.locationIsEmpty(0, column);
    }

    public int dropMarker(int column, int marker) {
        if (!columnIsAvailable(column)) {
            return -1;
        }

        int row = board.getNumRows() - 1;

        while (!board.locationIsEmpty(row, column)) {
            row -= 1;
        }

        board.placeMarker(row, column, marker);

        return row;
    }

    public boolean hasStreak(int[] arr, int marker, int length) {
        int currentStreak = 0;

        for (int value: arr) {
            if (value == marker) {
                currentStreak++;
            }
            else {
                currentStreak = 0;
            }

            if (currentStreak == length) {
                return true;
            }
        }

        return false;
    }
    
    public boolean hasWinAtLocation(int row, int column) {
        int marker = board.getMarker(row, column);

        int[] horizontal = board.getRow(row);
        int[] vertical = board.getColumn(column);
        int[] leftDiagonal = board.getLeftDiagonal(row, column);
        int[] rightDiagonal = board.getRightDiagonal(row, column);

        return (hasStreak(horizontal, marker, winStreakLength ) ||
                hasStreak(vertical, marker, winStreakLength ) ||
                hasStreak(leftDiagonal, marker, winStreakLength ) ||
                hasStreak(rightDiagonal, marker, winStreakLength ));
    }

    public void play() {
        
    }
}