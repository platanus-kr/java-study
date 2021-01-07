package spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao;

    public MemberRegisterService(MemberDao memberDao){
        this.memberDao = memberDao;
    }

    public Long register(RegisterRequest request){
        Member member = memberDao.selectByEmail(request.getEmail());
        if(member !=null){
            throw new DuplicateMemberException("duplicated email " +request.getEmail());
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
