package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDao {

    private static long nextId = 0;

    private Map<String, Member> members = new HashMap<>();

    public Collection<Member> selectAll() {
        return members.values();
    }

    public Member selectByEmail(String email) {
        return members.get(email);
    }

    public void insert(Member member) {
        member.setId(++nextId);
        members.put(member.getEmail(), member);
    }

    public void update(Member member) {
        members.put(member.getEmail(), member);
    }

}
