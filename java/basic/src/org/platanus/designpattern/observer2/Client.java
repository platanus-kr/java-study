package org.platanus.designpattern.observer2;

public class Client {

    public static void main(String[] args) {

        ScoreRecord scoreRecord = new ScoreRecord();
        DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
        DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.attace(dataSheetView3);
        scoreRecord.attace(dataSheetView5);
        scoreRecord.attace(minMaxView);

        scoreRecord.addScore(10);
        scoreRecord.addScore(20);
        scoreRecord.addScore(30);
        scoreRecord.addScore(40);
        scoreRecord.addScore(50);
    }

}
