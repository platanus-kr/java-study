package spring;

public class MemberPrinter {

    public void print(Member member) {
        System.out.printf(
            "Member information: ID = %d, Email = %s, Name = %s, RegisterDate = %tF \n",
            member.getId(),
            member.getEmail(),
            member.getName(),
            member.getRegisterDateTime()
        );
    }

}
