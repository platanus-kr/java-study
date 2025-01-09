package org.platanus.collection.TreeMap;

import java.util.Iterator;
import java.util.TreeMap;
import org.platanus.collection.dao.Member;

public class MemberTreeMap {

    private TreeMap<Integer, Member> treeMap;

    public MemberTreeMap() {
        treeMap = new TreeMap<Integer, Member>();
    }

    public void addMember(Member member) {
        treeMap.put(member.getMemberId(), member);
    }

    public boolean removeMember(int memberId) {
        if (treeMap.containsKey(memberId)) {
            treeMap.remove(memberId);
            return true;
        }
        System.out.println(memberId + "is not found");
        return false;
    }

    public void showAllMember() {
        Iterator<Integer> iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            Member member = treeMap.get(key);
            System.out.println(member);
        }
        System.out.println(" ");
    }

}
