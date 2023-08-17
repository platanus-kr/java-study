package assembler;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

public class Assembler {
 
    private MemberDao memberDao;
    private MemberRegisterService registerService;
    private ChangePasswordService passwordService;

    public Assembler() {
        memberDao = new MemberDao();
        registerService = new MemberRegisterService(memberDao);
        passwordService = new ChangePasswordService();
        passwordService.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getMemberRegisterService() {
        return registerService;
    }

    public ChangePasswordService getChangePasswordService() {
        return passwordService;
    }
}
