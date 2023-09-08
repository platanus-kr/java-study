package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInformationPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("not found data\n");
            return;
        }
        printer.print(member);
        System.out.println();
    }
    // 메소드에 자동주입 어노테이션
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    @Autowired
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }
}
