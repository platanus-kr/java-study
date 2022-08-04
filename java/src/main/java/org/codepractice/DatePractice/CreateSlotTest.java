package org.codepractice.DatePractice;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

public class CreateSlotTest {


    public static void main(String[] args) throws Exception {
        CreateSlotTest cs = new CreateSlotTest();
        System.out.println("오늘은 " + DateHelper.getDate("yyyyMMdd"));
        cs.createTeamFreshTodaySlot(5);
    }

    /**
     * 오늘로부터 afterDays 만큼 미래의 슬롯을 만든다.
     * 마지막 슬롯이 존재하지 않는 경우 : 오늘로부터 afterDays 만큼 뒤의 슬롯을 만든다
     * 마지막 슬롯이 오늘인 경우 :
     * 마지막 슬롯이 존재하는 경우 - 마지막 슬롯이 과거인 경우 : 과거 슬롯은 무시하고 오늘로 부터 afterDays 만큼 슬롯을 만든다.
     * 마지막 슬롯이 존재하는 경우 - 마지막 슬롯이 미래인 경우 : 마지막 슬롯과 오늘의 차이만큼 계산하여 afterDays 만큼 슬롯을 만든다.
     *
     * @param afterDays
     */
    public void createTeamFreshTodaySlot(int afterDays) throws Exception {

        //LastSlotDate 마지막 슬롯을 조회한다. -> VO로 가지고 온다.
        // 여기는 select mapper 붙인다.
        TeamFreshSlotInfoVO slot = new TeamFreshSlotInfoVO();
        slot.setDlvDd("20220801");
        slot.setDlvtTpCd("22");
        slot.setTurnNo("11");
        slot.setDlvStaTm("1234");
        slot.setDlvEndTm("1234");
        slot.setOrdrCloseTm("1234");
        slot.setSlotCnt(300);
        slot.setDlvPossibleYn("Y");
        slot.setApDlvPossibleYn("Y");
        System.out.println("마지막 슬롯 날짜 " + slot.getDlvDd());

        // 슬롯이 없을때 테스트
//        TeamFreshSlotInfoVO slot = null;
        ///


        String today = DateHelper.getDate("yyyyMMdd");

        // 슬롯이 없을 때
        // 기존 슬롯이 없으면 오늘 날짜부터 생성한다.
        if (slot == null) {
            slot = new TeamFreshSlotInfoVO();
            slot.setDlvDd(DateHelper.getAddDay(today, -1)); // 오늘 날짜를 생성하기 위한 변경
            slot.setDlvtTpCd("22");
            slot.setTurnNo("11");
            slot.setDlvStaTm("1234");
            slot.setDlvEndTm("1234");
            slot.setOrdrCloseTm("1234");
            slot.setSlotCnt(300);
            slot.setDlvPossibleYn("Y");
            slot.setApDlvPossibleYn("Y");
            System.out.println("슬롯이 없어서 오늘부터 생성해야되요!");
            createTeamFreshTodaySlot_Last(slot, afterDays + 1); // 오늘 슬롯을 생성하고, 그 후 +afterDays 생성을 해야한다.
            return;
        }

        // 마지막 슬롯 날짜가 과거 일 때
        // 과거의 슬롯은 신경 쓸 필요가 없다. 오늘이 기준일이 되면 된다.
        if (Integer.parseInt(slot.getDlvDd()) < Integer.parseInt(today)) {
            slot.setDlvDd(DateHelper.getAddDay(today, -1)); // 오늘 날짜를 생성하기 위한 변경
            System.out.println("마지막 슬롯이 과거에요.");
            createTeamFreshTodaySlot_Last(slot, afterDays + 1); // 오늘 슬롯을 생성하고, 그 후 +afterDays 생성을 해야한다.
            return;
        }

        // 마지막 슬롯 날짜가 오늘 일 때
        // 내일 부터 만든다.
        if (Integer.parseInt(slot.getDlvDd()) == Integer.parseInt(today)) {
            System.out.println("마지막 슬롯이 오늘이에요.");
            createTeamFreshTodaySlot_Last(slot, afterDays);
            return;
        }

        // 마지막 슬롯 날짜가 오늘보다 미래 일 때 => 이 경우가 가장 일반적인 경우다.
        // 오늘 날짜와 마지막 슬롯 날짜의 차이만큼만 생성한다.
        if (Integer.parseInt(slot.getDlvDd()) > Integer.parseInt(today)) {
            long differDay = DateHelper.getDifferDay(today, slot.getDlvDd());
            afterDays = afterDays - (int) differDay;
            if (afterDays > 0) { // 생성할 슬롯이 있을 때만 생성한다.
                createTeamFreshTodaySlot_Last(slot, afterDays);
            } else {
                System.out.println("이미 원하느 날짜 까지 슬롯이 생성되어 있습니다.");
            }
            return;
        }
    }

    /**
     * VO의 값을 기반으로 한 슬롯을 만든다.
     * VO의 dlvDd 날짜 부터 만든다.
     *
     * @param slot
     * @param afterDays
     * @throws Exception
     */
    public void createTeamFreshTodaySlot_Last(TeamFreshSlotInfoVO slot, int afterDays) throws Exception {
        if (StringUtils.isBlank(slot.getDlvDd())) {
            throw new Exception("기준 날짜가 비어있습니다.");
        }
        if (!DateHelper.isDate(slot.getDlvDd())) {
            throw new Exception("기준 날짜가 유효하지 않습니다. 형식 : YYYYMMDD");
        }
        if (afterDays < 1) {
            throw new Exception("추가 일수가 유효하지 않습니다.");
        }
        teamFreshLogger.info(">> TEAM FRESH TODAY SLOT CREATE" + startDate);
        System.out.println(">> TEAM FRESH TODAY SLOT CREATE " + slot.getDlvDd());
        for (int i = 1; i <= afterDays; i++) { // dlvDd 에는  존재하는 슬롯으로 간주한다. 예외 처리는 슬롯이 존재하지 않을때만!
            slot.setDlvDd(DateHelper.getAddDay(slot.getDlvDd(), 1)); // 날짜는 하루씩 더해야 한다.
            // 여기에 insertMapper
            teamFreshMapper.insertTeamFreshTodaySlotByLastSlot(tfsVO);
            System.out.println("Create dlvDd : " + slot.getDlvDd());
        }
        teamFreshLogger.info("<< TEAM FRESH TODAY SLOT CREATE" + DateHelper.getAddDay(startDate, afterDays));
        System.out.println("<< TEAM FRESH TODAY SLOT CREATE " + slot.getDlvDd());
    }

    @Data
    public class TeamFreshSlotInfoVO {
        /**
         * 배송유형
         */
        private String dlvtTpCd = "";

        /**
         * 배송유형명칭
         */
        private String dlvtTpCdNm = "";


        /**
         * 배송센터코드
         */
        private String mallId = "";

        /**
         * 배송센터이름
         */
        private String mallNm = "";

        /**
         * 배송그룹
         */
        private String dlvGrpCd = "";

        /**
         * 배송그룹명칭
         */
        private String dlvGrpCdNm = "";

        /**
         * 슬롯 갯수
         */
        private int slotCnt = 0;

        /**
         * 등록일
         */
        private String createDate = "";

        /**
         * 수정일
         */
        private String updateDate = "";

        /**
         * 검색 시작일
         */
        private String srcStaDd = "";

        /**
         * 검색 종료일
         */
        private String srcEndDd = "";

        /**
         * 사용 갯수
         */
        private int usedCnt = 0;

        /**
         * 배송일
         */
        private String dlvDd = "";

        /**
         * 회차
         */
        private String turnNo = "";

        /**
         * aboutPet 슬롯사용 갯수
         */
        private int usedCntAp = 0;

        /**
         * 네이버장보기몰 슬롯사용 갯수
         */
        private int usedCntNv = 0;

        /**
         * 새벽배송 슬롯 사용 갯수
         */
        private int usedCntDw = 0;

        /**
         * 새벽배송 어바웃펫 슬롯 사용 갯수
         */
        private int usedCntDwAp = 0;

        /**
         * 새벽배송 네이버 슬롯 사용 갯수
         */
        private int usedCntDwNv = 0;

        /**
         * 사용여부
         */
        private String useYn = "";

        /**
         * 배송 가능 여부
         */
        private String dlvPossibleYn = "";

        /**
         * 배송 가능 여부(어바웃펫)
         */
        private String apDlvPossibleYn = "";

        /**
         * 전송대상
         */
        private String apDlvTmSyncTgYn = "";

        /**
         * 전송여부
         */
        private String apDlvTmSyncYn = "";

        /**
         * 전송대상
         */
        private String dlvTmSyncTgYn = "";

        /**
         * 전송여부
         */
        private String dlvTmSyncYn = "";

        /**
         * 배송 시간 전송 날짜
         */
        private String dlvTmSyncDate = "";

        /**
         * 주문 마감 시간
         **/
        private String ordrCloseTm = "";

        /**
         * 배송 종료 시간
         **/
        private String dlvEndTm = "";

        /**
         * 배송 시작 시간
         **/
        private String dlvStaTm = "";

        /**
         * 배송센터 배송 그룹 코드
         **/
        private String mallDlvGrpCd = "";

        /**
         * 배송일  + 1
         */
        private String dlvDdAfter = "";

        /**
         * 고객배송요청일 ( 고객이 요청한 배송일자 )
         */
        private String custDlvReqDd = "";

        /**
         * 출고지시일
         */
        private String dlvReqDd = "";
    }
}
