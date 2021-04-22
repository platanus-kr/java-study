package org.platanus.collection.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import org.platanus.collection.dao.Member;

public class MemberHashMap {

    private HashMap<Integer, Member> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<Integer, Member>();
    }

    public void addMember(Member member) {
        hashMap.put(member.getMemberId(), member);
    }

    public boolean removeMember(int memberId) {
        if (hashMap.containsKey(memberId)) {
            hashMap.remove(memberId);
            return true;
        }
        System.out.println(memberId + "is not found");
        return false;
    }

    public void showAllMember() {
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            Member member = hashMap.get(key);
            System.out.println(member);
        }
        System.out.println(" ");
    }

}
