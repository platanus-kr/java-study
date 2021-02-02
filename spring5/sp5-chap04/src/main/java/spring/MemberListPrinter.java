package spring;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberListPrinter {

    private MemberDao memberDao;
    private MemberPrinter printer;


    public MemberListPrinter() {
        // @Autowired로 대체.
        //        this.memberDao = memberDao;
        //        this.printer = printer;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        for (Member member : members) {
            printer.print(member);
        }
    }

    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    @Autowired
    public void setPrinter(MemberPrinter printer) {
        this.printer = printer;
    }



}
