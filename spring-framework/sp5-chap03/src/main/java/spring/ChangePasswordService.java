package spring;

public class ChangePasswordService {

    private MemberDao memberDao;

    public void changePassword(String email, String oldPasswod, String newPassword) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            throw new MemberNotFoundException();
        }
        member.changePassword(oldPasswod, newPassword);

        memberDao.update(member);
    }

    public void setMemberDao(MemberDao memberDao) {
        // 의존 객체를 주입받는 setter.
        this.memberDao = memberDao;
    }

}
