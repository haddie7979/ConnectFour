import java.util.Scanner;
// This is a comment for the 6th lab

public class ConnectFour {
    // This will print the board
    public static void printBoard(char[][] array) {


        for (int i = array.length - 1; i >= 0; i--) {

            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 'x') {
                    System.out.print("x");
                }
                else if (array[i][j] == 'o') {
                    System.out.print("o");
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println();

        }
    }

    // This will set each spot in the array to “-”
    public static void initializeBoard(char[][] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                array[i][j] = '-';
            }
        }
    }

    // Places the token in the column that the user has chosen
    public static int insertChip(char[][] array, int col, char chipType) {
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i][col] == '-') {
                array[i][col] = chipType;
                break;
            }
        }

        // return the row that the token is placed in
        return i;
    }

    // Checks whether player has gotten 4 in a row
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        // check if row has 4 of the same
        // the rows is the amount of arrays
        // array[row][columm]
        int rowCheck = 0;
        for (int i = 0; i < array[row].length; i++) {
            if (array[row][i] == chipType) {
                rowCheck++;
            }
            else {
                rowCheck = 0;
            }
            if (rowCheck == 4) {
                return true;
            }
        }
        // check if column has 4 of the same
        // the columns are the individual data points
        int colCheck = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][col] == chipType) {
                colCheck++;
            }
            else  {
                colCheck = 0;
            }
            if (colCheck == 4) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int column;
        int row;
        int boardFill = 0;
        char chipType = '-';
        boolean winner = false;

        System.out.println("What would you like the height of the board to be? ");
        int boardHeight = scanner.nextInt();

        System.out.println("What would you like the length of the board to be? ");
        int boardLength = scanner.nextInt();

        char[][] board = new char[boardHeight][boardLength];
        initializeBoard(board);
        printBoard(board);

        System.out.println("Player 1: x");
        System.out.println("Player 2: o");

        // Need to turn this into a while loop
        while (winner == false) {
            System.out.println("Player 1: Which column would you like to choose? ");
            column = scanner.nextInt();
            chipType = 'x';
            row = insertChip(board, column, chipType);
            printBoard(board);
            boardFill++;
            winner = checkIfWinner(board, column, row, chipType);
            if (winner == true) {
                System.out.println("Player 1 won the game!");
                break;
            }

            System.out.println("Player 2: Which column would you like to choose? ");
            column = scanner.nextInt();
            chipType = 'o';
            row = insertChip(board, column, chipType);
            printBoard(board);
            boardFill++;
            winner = checkIfWinner(board, column, row, chipType);
            if (winner == true) {
                System.out.println("Player 2 won the game!");
                break;
            }

            if (boardFill == boardHeight * boardLength) {
                System.out.println("Draw. Nobody wins.");
                break;
            }
        }
    }
}
