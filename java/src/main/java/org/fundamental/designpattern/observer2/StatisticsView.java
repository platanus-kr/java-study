package org.fundamental.designpattern.observer2;

import java.util.List;

public class StatisticsView implements Observer {

    private ScoreRecord scoreRecord;

    public StatisticsView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord();
        displayStatistics(record);
    }

    private void displayStatistics(List<Integer> record) {
        int sum = 0;
        float average = 0;
        for (int score : record) {
            sum += score;
            average = (float) sum / record.size();
        }
        System.out.println("Sum: " + sum + " / Average: " + average);
    }
}
