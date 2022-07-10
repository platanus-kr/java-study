package org.platanus.collection.dao;

public class MemberComparable implements Comparable<MemberComparable> {
    private int memberId;
    private String memberName;

    @Override
    public int hashCode() {
        return memberId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MemberComparable) {
            MemberComparable member = (MemberComparable) obj;
            return this.memberId == member.memberId;
        }
        return true;
    }

    public MemberComparable(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        String s = memberName + "Member ID is " + memberId + ".";
        return s;
    }

    @Override
    public int compareTo(MemberComparable member) {
        return (this.memberId - member.memberId);
    }
}
