package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {

    private MemberDao memberDao;

    // 생성자를 통해 의존 객체를 주입 받음.
    public MemberRegisterService(MemberDao memberDao) {
        //주입 받은 객체를 필드에 할당.
        this.memberDao = memberDao;
    }

    public Long register(RegisterRequest request) {
        //이하 생성자에서 주입받은 객체 사용.
        Member member = memberDao.selectByEmail(request.getEmail());
        if (member != null) {
            throw new DuplicateMemberException("duplicated email " + request.getEmail());
        }
        Member newMember = new Member(
            request.getEmail(),
            request.getPassword(),
            request.getName(),
            LocalDateTime.now()
        );
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
