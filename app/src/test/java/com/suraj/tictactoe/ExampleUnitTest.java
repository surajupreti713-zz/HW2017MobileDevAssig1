package com.suraj.tictactoe;

import org.junit.Test;

import static com.suraj.tictactoe.TicTacToeLogic.TTTElement.X;
import static com.suraj.tictactoe.TicTacToeLogic.TTTElement.EMPTY;
import static com.suraj.tictactoe.TicTacToeLogic.TTTElement.O;
import static com.suraj.tictactoe.TicTacToeLogic.getBestMove;
import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    public void test1() {
        TicTacToeLogic.TTTElement[] gameState = new TicTacToeLogic.TTTElement[]{X, EMPTY, EMPTY, X, O, EMPTY, EMPTY, EMPTY, EMPTY};     //First test
        assertEquals(6, getBestMove(gameState));

        TicTacToeLogic.TTTElement[] gameState1 = new TicTacToeLogic.TTTElement[]{O, O, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};    //Second test
        assertEquals(2, getBestMove(gameState1));

        TicTacToeLogic.TTTElement[] gameState2 = new TicTacToeLogic.TTTElement[]{O, O, X, X, O, X, O, X, X};        //Third test
        assertEquals(-1, getBestMove(gameState2));
    }
}