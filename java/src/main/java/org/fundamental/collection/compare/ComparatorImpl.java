package org.fundamental.collection.compare;

import org.fundamental.collection.dao.Member;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Member> {

    @Override
    public int compare(Member o1, Member o2) {
        if (o1.getMemberId() == o2.getMemberId()) {
            return 0;
        }
        if (o1.getMemberId() > o2.getMemberId()) {
            return 1;
        }
        if (o1.getMemberId() < o2.getMemberId()) {
            return -1;
        }
        return 0;
    }
}
