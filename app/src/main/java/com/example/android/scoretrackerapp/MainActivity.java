package com.example.android.scoretrackerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final int TOP_INNING = 0;
    final int BOTTOM_INNING = 1;


    int Inning = 1;
    int Strike = 0;
    int Ball = 0;
    int Out = 0;
    int GuestTeamScore = 0;
    int HomeTeamScore = 0;
    int HalfInning = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetGame();

    }


    public void updateStrikeBtn(View v)
    {
        updateStrike();
    }


    public void updateStrike()
    {
        Strike++;
        if(Strike >= 3)
        {
            Strike = 0;
            Ball = 0;
            updateOut();
        }
        displayStrike(Strike);
    }

    public void updateBallBtn(View v)
    {
        Ball++;
        if(Ball >= 4)
        {
            Ball = 0;
        }
        displayBall(Ball);
    }


    public void updateOutBtn(View v)
    {
        updateOut();
    }

    public void updateOut()
    {
        Out++;
        if(Out >= 3)
        {
            Out = 0;
            HalfInning++;
            if(HalfInning >=2)
            {
                HalfInning = 0;
                Inning++;
                displayInning(Inning);
            }
            setHalfInning(HalfInning);

        }
        displayOut(Out);
    }



    public void guestScoreBtn(View v)
    {
        GuestTeamScore++;
        displayGuestScore(GuestTeamScore);
    }



    public void homeScoreBtn(View v)
    {
        HomeTeamScore++;
        displayHomeScore(HomeTeamScore);
    }




    public void resetBallStrikeBtn(View v)
    {
        Strike = 0;
        displayStrike(Strike);
        Ball = 0;
        displayBall(Ball);
    }


    public void resetInningBtn(View v)
    {

        Strike = 0;
        displayStrike(Strike);
        Ball = 0;
        displayBall(Ball);
        Out = 0;
        displayOut(Out);

        HalfInning = TOP_INNING;
        setHalfInning(HalfInning);
    }

    public void resetGameBtn(View v)
    {
        resetGame();
    }

    public void resetGame()
    {
        HalfInning = 0;
        Inning = 1;
        displayInning(Inning);
        Strike = 0;
        displayStrike(Strike);
        Ball = 0;
        displayBall(Ball);
        Out = 0;
        displayOut(Out);
        GuestTeamScore = 0;
        displayGuestScore(GuestTeamScore);
        HomeTeamScore = 0;
        displayHomeScore(HomeTeamScore);

        HalfInning = TOP_INNING;
        setHalfInning(HalfInning);
    }


    public void displayInning(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.Inning);
        scoreView.setText(String.valueOf(score) + " Inning");
    }

    public void displayGuestScore(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.GuestScore);
        scoreView.setText(String.valueOf(score));
    }

    public void displayHomeScore(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.HomeScore);
        scoreView.setText(String.valueOf(score));
    }

    public void displayStrike(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.Strike);
        scoreView.setText(String.valueOf(score));
    }

    public void displayBall(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.Ball);
        scoreView.setText(String.valueOf(score));
    }

    public void displayOut(int score)
    {
        TextView scoreView = (TextView) findViewById(R.id.Out);
        scoreView.setText(String.valueOf(score));
    }

    private void setHalfInning(int level)
    {
        if(level == TOP_INNING)
        {

            int BackgroundColor = getResources().getColor(R.color.colorGrey);
            Button btn = (Button) findViewById(R.id.HomeScoreBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);
            btn = (Button) findViewById(R.id.HomeBallBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);
            btn = (Button) findViewById(R.id.HomeStrikeBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);
            btn = (Button) findViewById(R.id.HomeOutBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);

            BackgroundColor = getResources().getColor(R.color.colorBlue);

            btn = (Button) findViewById(R.id.GuestScoreBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);
            btn = (Button) findViewById(R.id.GuestBallBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);
            btn = (Button) findViewById(R.id.GuestStrikeBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);
            btn = (Button) findViewById(R.id.GuestOutBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);
        }
        else
        {
            int BackgroundColor = getResources().getColor(R.color.colorBlue);

            Button btn = (Button) findViewById(R.id.HomeScoreBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);
            btn = (Button) findViewById(R.id.HomeBallBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);
            btn = (Button) findViewById(R.id.HomeStrikeBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);
            btn = (Button) findViewById(R.id.HomeOutBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(true);

            BackgroundColor = getResources().getColor(R.color.colorGrey);

            btn = (Button) findViewById(R.id.GuestScoreBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);
            btn = (Button) findViewById(R.id.GuestBallBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);
            btn = (Button) findViewById(R.id.GuestStrikeBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);
            btn = (Button) findViewById(R.id.GuestOutBtn);
            btn.setBackgroundColor(BackgroundColor);
            btn.setEnabled(false);
        }
    }

}
