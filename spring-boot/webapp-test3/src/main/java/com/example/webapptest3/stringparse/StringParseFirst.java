package com.example.webapptest3.stringparse;

import java.util.ArrayList;
import java.util.List;

public class StringParseFirst {
    public static void main(String[] args) {
        List<String> slots = new ArrayList<>();
        slots.add("2070011019006"); // GSF 당일
        slots.add("2131005016999"); // GSF 새벽
        slots.add("2200000000011"); // 팀프 당일

        List<String> retArr = new ArrayList<>();
        for (String slot : slots) {
//            String slotId = slot;
//            String dlvtTpCd = slotId.substring(0, 2);
//            String mallId = slotId.substring(2, 7);
//            String dlvGrpCd = "";
//            String turnNo = "";
//
//            if (slotId.length() == 13) {
//                dlvGrpCd = slotId.substring(7, 10);
//                turnNo = slotId.substring(10);
//            } else { // 이전
//                String tempTurnNo = slotId.substring(slotId.length() - 3, slotId.length());
//
//                if ("999".equals(tempTurnNo) || "800".equals(tempTurnNo)) { // 새벽배송/전담배송
//                    dlvGrpCd = slotId.substring(7, slotId.length() - 3);
//                    turnNo = tempTurnNo;
//                } else { // 당일배송
//                    dlvGrpCd = slotId.substring(7, slotId.length() - 1);
//                    turnNo = slotId.substring(slotId.length() - 1);
//                }
//            }


            String slotId = slot;
            String dlvtTpCd = slotId.substring(0, 2);
            String mallId = slotId.substring(2, 7);
            String dlvGrpCd = "";
            String turnNo = "";
            if (slotId.length() >= 13) {
                dlvGrpCd = slotId.substring(7, 10);
                turnNo = slotId.substring(10);
            } else { // 이전
                String tempTurnNo = slotId.substring(slotId.length() - 3, slotId.length());

                if ("999".equals(tempTurnNo)) { // 새벽배송
                    dlvtTpCd = "21";
                    dlvGrpCd = slotId.substring(7, slotId.length() - 3);
                    turnNo = tempTurnNo;
                } else if ("800".equals(tempTurnNo)) { // 전담배송
                    dlvtTpCd = "12";
                    dlvGrpCd = slotId.substring(7, slotId.length() - 3);
                    turnNo = tempTurnNo;
                } else { // 당일배송
                    dlvGrpCd = slotId.substring(7, slotId.length() - 1);
                    turnNo = slotId.substring(slotId.length() - 1);
                }
            }
            retArr.add(slotId + ", " + dlvtTpCd  + ", " + mallId  + ", " + dlvGrpCd  + ", " + turnNo);
            System.out.println(slotId + ", " + dlvtTpCd  + ", " + mallId  + ", " + dlvGrpCd  + ", " + turnNo);

        }
        System.out.println(retArr);

    }
}
