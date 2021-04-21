package org.platanus.designpattern.observer2;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord extends Subject {

    private List<Integer> scores = new ArrayList<Integer>();


    public void addScore(int score) {
        scores.add(score);
        notifyObservers();
    }

    public List<Integer> getScoreRecord() {
        return scores;
    }


}
