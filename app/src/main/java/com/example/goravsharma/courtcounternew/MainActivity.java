package com.example.goravsharma.courtcounternew;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
        //mViewModel.scoreTeamA.observe(this, (x) -> displayForTeamA(x));
        mViewModel.scoreTeamA.observe(this, (x) -> {
            displayForTeamA(x);
            return;
        });

        final Observer<Integer> scoreObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                displayForTeamB(mViewModel.scoreTeamB.getValue());
            }
        };
        mViewModel.scoreTeamB.observe(this, scoreObserver);
        //displayForTeamA(mViewModel.scoreTeamA);
        //displayForTeamB(mViewModel.scoreTeamB);
    }

    public void addOneForTeamA(View v) {
        int x = mViewModel.scoreTeamA.getValue() != null ? mViewModel.scoreTeamA.getValue().intValue() : 0;
        mViewModel.scoreTeamA.setValue(x + 1);
        displayForTeamA(mViewModel.scoreTeamA.getValue());
    }

    public void addTwoForTeamA(View v) {
        int x = mViewModel.scoreTeamA.getValue() != null ? mViewModel.scoreTeamA.getValue().intValue() : 0;
        mViewModel.scoreTeamA.setValue(x + 2);
        displayForTeamA(mViewModel.scoreTeamA.getValue());
    }

    public void addThreeForTeamA(View v) {
        int x = mViewModel.scoreTeamA.getValue() != null ? mViewModel.scoreTeamA.getValue().intValue() : 0;
        mViewModel.scoreTeamA.setValue(x + 3);
        displayForTeamA(mViewModel.scoreTeamA.getValue());
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneForTeamB(View v) {
        int x = mViewModel.getScoreTeamB().getValue().intValue();
        mViewModel.scoreTeamB.setValue(x + 1);
        displayForTeamB(mViewModel.scoreTeamB.getValue());
    }

    public void addTwoForTeamB(View v) {
        int x = mViewModel.scoreTeamB.getValue() != null ? mViewModel.scoreTeamB.getValue().intValue() : 0;
        mViewModel.scoreTeamB.setValue(x + 2);
        displayForTeamB(mViewModel.scoreTeamB.getValue());
    }

    public void addThreeForTeamB(View v) {
        int x = mViewModel.scoreTeamB.getValue() != null ? mViewModel.scoreTeamB.getValue().intValue() : 0;
        mViewModel.scoreTeamB.setValue(x + 3);
        displayForTeamB(mViewModel.scoreTeamB.getValue());
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetScore(View v) {
        mViewModel.scoreTeamA.setValue(0);
        mViewModel.scoreTeamB.setValue(0);
        displayForTeamA(mViewModel.scoreTeamA.getValue());
        displayForTeamB(mViewModel.scoreTeamB.getValue());
    }
}
