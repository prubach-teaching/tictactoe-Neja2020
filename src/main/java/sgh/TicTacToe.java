package sgh;

import java.io.File;

public class TicTacToe {

    public enum Result { NOT_FINISHED, NO_WINNER, X_WON, O_WON }

    public static Result checkBoard(String boardFileName) {
        File boardFile = new File(boardFileName);
        System.out.println(boardFile.getAbsolutePath());

        // Your code here

        return Result.NO_WINNER;
    }


    public static void main(String[] args) {
        Result res = checkBoard("boards/tick0.csv");
        System.out.println(res);
    }
}
