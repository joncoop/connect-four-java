public class Tests {

    public static void print2DArray(int[][] arr) {
        for (int[] row: arr) {
            for (int column: row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Board board = new Board();

        System.out.println(board);
        
        System.out.println("Row is valid");
        System.out.println(board.rowIsValid(0));
        System.out.println(board.rowIsValid(3));
        System.out.println(board.rowIsValid(5));
        System.out.println(board.rowIsValid(-1));
        System.out.println(board.rowIsValid(6));
        System.out.println();

        System.out.println("Column is valid");
        System.out.println(board.columnIsValid(0));
        System.out.println(board.columnIsValid(3));
        System.out.println(board.columnIsValid(6));
        System.out.println(board.columnIsValid(-1));
        System.out.println(board.columnIsValid(7));
        System.out.println();

        System.out.println("Place disc");
        System.out.println(board.placeDisc(5, 2, 1));
        System.out.println(board.placeDisc(12, 2, 1));
        System.out.println(board.placeDisc(5, -4, 1));
        System.out.println(board);
        System.out.println();

        board.placeDisc(5, 1, 1);
        board.placeDisc(5, 3, 1);
        board.placeDisc(5, 4, 1);
        board.placeDisc(5, 6, 2);
        board.placeDisc(4, 6, 2);
        board.placeDisc(3, 6, 2);
        board.placeDisc(2, 6, 2);
        board.placeDisc(5, 0, 2);
        board.placeDisc(4, 1, 2);
        board.placeDisc(4, 2, 1);
        board.placeDisc(3, 2, 2);
        board.placeDisc(4, 3, 1);
        board.placeDisc(3, 3, 1);
        board.placeDisc(2, 3, 2);
        board.placeDisc(4, 4, 1);
        board.placeDisc(2, 2, 1);
        board.placeDisc(3, 1, 1);
        board.placeDisc(2, 1, 2);
        board.placeDisc(1, 1, 1);
        board.placeDisc(0, 1, 2);
        System.out.println(board);
        System.out.println();

        System.out.println("Column is available");
        System.out.println(board.columnIsAvailable(0));
        System.out.println(board.columnIsAvailable(1));
        System.out.println(board.columnIsAvailable(2));
        System.out.println(board.columnIsAvailable(9));
        System.out.println();   

        System.out.println("Drop disc");
        System.out.println(board.dropDisc(0, 2));
        System.out.println(board.dropDisc(5, 2));
        System.out.println(board.dropDisc(1, 1));
        System.out.println(board.dropDisc(8, 1));
        System.out.println(board);
        System.out.println();  

        System.out.println("Has streak");
        System.out.println(board.hasStreak(new int[] {1, 1, 1, 1, 0, 0, 0}, 1, 4));
        System.out.println(board.hasStreak(new int[] {0, 1, 1, 1, 1, 0, 0}, 1, 4));
        System.out.println(board.hasStreak(new int[] {0, 0, 1, 1, 1, 1, 0}, 1, 4));
        System.out.println(board.hasStreak(new int[] {0, 0, 0, 1, 1, 1, 1}, 1, 4));
        System.out.println(board.hasStreak(new int[] {0, 0, 0, 0, 0, 0, 0}, 1, 4));
        System.out.println(board.hasStreak(new int[] {0, 1, 0, 2, 1, 1, 1}, 1, 4));
        System.out.println();  
    }
}