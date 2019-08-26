package com.example.goravsharma.courtcounternew;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    public MutableLiveData<Integer> scoreTeamA = new MutableLiveData();
    public MutableLiveData<Integer> scoreTeamB = new MutableLiveData();

    public MutableLiveData<Integer> getScoreTeamB() {
        if (scoreTeamB.getValue() != null) {
            scoreTeamB.getValue().intValue();
        } else {
            scoreTeamB.setValue(0);
        }
        return scoreTeamB;
    }
}
