package sgh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class TestTicTacToe {

    Map<String, TicTacToe.Result> mapResults = new HashMap<>();

    @Test
    public void testTicTacToe() throws IOException
    {
        mapResults.put("boards/tick0.csv", TicTacToe.Result.O_WON);
        mapResults.put("boards/tick1.csv", TicTacToe.Result.X_WON);
        mapResults.put("boards/tick2.csv", TicTacToe.Result.NO_WINNER);
        mapResults.put("boards/tick3.csv", TicTacToe.Result.NOT_FINISHED);

        for (String fileName : mapResults.keySet()) {
            TicTacToe.Result res = TicTacToe.checkBoard(fileName);
            System.out.println("Testing file: " + fileName);
            assertEquals(mapResults.get(fileName), res);
        }
    }
}