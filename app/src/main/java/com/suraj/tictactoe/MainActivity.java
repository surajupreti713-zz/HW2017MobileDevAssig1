package com.suraj.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import static com.suraj.tictactoe.TicTacToeLogic.TTTElement.EMPTY;
import static com.suraj.tictactoe.TicTacToeLogic.TTTElement.O;
import static com.suraj.tictactoe.TicTacToeLogic.TTTElement.X;
import static com.suraj.tictactoe.TicTacToeLogic.gameState;

public class MainActivity extends AppCompatActivity {

    private List<Button> mButtons = new ArrayList<Button>();

    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;

    private Button mNewGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton0 = (Button) findViewById(R.id.button_0);
        mButtons.add(mButton0);
        mButton1 = (Button) findViewById(R.id.button_1);
        mButtons.add(mButton1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButtons.add(mButton2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButtons.add(mButton3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mButtons.add(mButton4);
        mButton5 = (Button) findViewById(R.id.button_5);
        mButtons.add(mButton5);
        mButton6 = (Button) findViewById(R.id.button_6);
        mButtons.add(mButton6);
        mButton7 = (Button) findViewById(R.id.button_7);
        mButtons.add(mButton7);
        mButton8 = (Button) findViewById(R.id.button_8);
        mButtons.add(mButton8);

        mNewGameButton = (Button) findViewById(R.id.new_game);

        // get the best computer move and update the board
        //int bestMove = TicTacToeLogic.getBestMove(gameState);
         // but what happens if bestMove == -1?   Ans: bestMove == -1 means that the game is over so reset all the buttons.


        for (int i=0;i<mButtons.size();i++) {
            Button button = mButtons.get(i);
            final int final_i = i;
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    didPressGameButton(final_i);
                }
            });
        }

        mNewGameButton.setOnClickListener(new View.OnClickListener() {      //this button, when clicked, will reset the state of the game as well as clear the text state of the buttons
            @Override
            public void onClick(View view) {
                for(int i = 0; i < 9; i++) {
                    gameState[i] = EMPTY;
                    mButtons.get(i).setText("");
                }
                mNewGameButton.setVisibility(View.GONE);
            }
        });

    }

    public void didPressGameButton(int index) {
        if (!(gameState[index].equals(X) || gameState[index].equals(O))) {
            gameState[index] = X;
            mButtons.get(index).setText("X");
            int bestMove = TicTacToeLogic.getBestMove(gameState);

            if (bestMove == -1) {
                mNewGameButton.setVisibility(View.VISIBLE);
            }
            else {
                gameState[bestMove] = O;
                mButtons.get(bestMove).setText("O");
            }
        }
        /*int bestMove = TicTacToeLogic.getBestMove(gameState);

        //Log.d("da", String.valueOf(bestMove));
        if (bestMove == -1) {
            mNewGameButton.setVisibility(View.VISIBLE);
        }
        else {
            gameState[bestMove] = O;
            mButtons.get(bestMove).setText("O");
        }*/

    }
}
