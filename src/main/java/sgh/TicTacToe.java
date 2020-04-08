package sgh;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public enum Result {NOT_FINISHED, NO_WINNER, X_WON, O_WON}
    public static int [][] GetBoard(String boardName) throws FileNotFoundException {
        int[][] board = new int[3][3];
        File boardFile = new File(boardName);
        System.out.println(boardFile.getAbsolutePath());
        Scanner fileReader = new Scanner(boardFile);
        int i = 0;
        while (fileReader.hasNextLine()) {
            String[] data = fileReader.nextLine().split(";");
            int j = 0;
            for (String sign : data) {
                if (sign.equals("x")) {
                    board[i][j] = 1;
                    j++;
                } else if (sign.equals("o")) {
                    board[i][j] = -1;
                    j++;
                } else {
                    board[i][j] = 0;
                    j++;
                }
            }
            i++;
        }
        return board;
    }
    public static int Column(int[][] board) {
        for (int sign=-1;sign<=1;sign=sign+2) {
            for (int i = 0; i < 3; i++) {
                if (board[0][i] == sign && board[1][i] == sign && board[2][i] == sign) {
                    return sign;
                }
            }
        }
        return 0;
    }
    public static int Row(int[][] board) {
        for (int[] row : board) {
            if (Arrays.equals(row, new int[]{1, 1, 1})) {
                return 1;
            } else if (Arrays.equals(row, new int[]{-1, -1, -1})) {
                return -1;
            }
        }
        return 0;
    }
    public static int Diagonal(int[][] board) {
        for (int sign : new int[]{-1, 1}) {

            if (board[0][0] == sign && board[1][1] == sign && board[2][2] == sign) {
                return sign;
            } else if (board[2][0] == sign && board[1][1] == sign && board[0][2] == sign) {
                return sign;
            }

        }
        return 0;
    }
    public static Result checkBoard(String boardName) throws FileNotFoundException {
        //Creating board from .csv file
        int[][] board = new int[3][3];
        board=GetBoard(boardName);
        //Checking rows, columns and diagonals of board with predefined functions
        if (Row(board) == 1 || Column(board) == 1 || Diagonal(board) == 1) {
            return Result.X_WON;
        } else if (Row(board) == -1 || Column(board) == -1 || Diagonal(board) == -1) {
            return Result.O_WON;
        }
        //Checking if board has unsigned field
        for (int[] row : board){
            for (int sign:row){
                if(sign == 0){
                    return Result.NOT_FINISHED;
                }
            }
        }

        return Result.NO_WINNER;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Result GameResult = checkBoard("boards/tick1.csv");
        System.out.println(GameResult);
    }
}
