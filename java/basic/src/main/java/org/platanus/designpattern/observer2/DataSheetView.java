package org.platanus.designpattern.observer2;

import java.util.List;

public class DataSheetView implements Observer {

    private ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    public void update() {
        List<Integer> record = scoreRecord.getScoreRecord();
        displayScores(record, viewCount);
    }

    public void displayScores(List<Integer> record, int viewCount) {
        System.out.print("List of " + viewCount + " entries:");
        int i = 0;
        while (!record.isEmpty()) {
            if (viewCount == i || i >= record.size()) {
                break;
            }
            System.out.print(record.get(i) + " ");
            i += 1;
        }
        System.out.println(" ");
    }

}
