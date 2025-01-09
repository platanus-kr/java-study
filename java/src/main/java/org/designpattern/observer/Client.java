package org.designpattern.observer;

public class Client {

    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);

        scoreRecord.setDataSheetView(dataSheetView);

        scoreRecord.addScore(10);
        scoreRecord.addScore(20);
        scoreRecord.addScore(30);
        scoreRecord.addScore(40);
        scoreRecord.addScore(50);

    }

}
