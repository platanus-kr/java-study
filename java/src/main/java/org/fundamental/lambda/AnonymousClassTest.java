package org.fundamental.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class AnonymousClassTest {
    private static final List<String> phoneNumbers = new ArrayList<>();
    /**
     * 1. 익명 클래스
     */
    static Comparator<String> phoneNumberComparator = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    };

    /**
     * 2. 같은 내용을 람다로 바꾸면 이렇게 됨.
     */
    static Comparator<String> phoneNumberComparator2 = (o1, o2) -> o1.compareTo(o2);

    /**
     * 3. 람다를 메소드 참조로도 바꿀 수 있다. 아래의 경우 정적 메소드 참조.
     */
    static Comparator<String> phoneNumberComparator3 = String::compareTo;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            StringBuilder phoneNumber = new StringBuilder();
            Random random = new Random();

            int firstNumber = random.nextInt(9999);
            int secondNumber = random.nextInt(9999);

            phoneNumber.append("010-");
            phoneNumber.append(String.format("%04d", firstNumber));
            phoneNumber.append("-");
            phoneNumber.append(String.format("%04d", secondNumber));

            phoneNumbers.add(phoneNumber.toString());
        }
        System.out.println("before sorting..");
        System.out.println(phoneNumbers);

        phoneNumbers.sort(phoneNumberComparator);
        System.out.println("after sorting..");
        System.out.println(phoneNumbers);
//        phoneNumbers.sort(phoneNumberComparator2);
//        System.out.println("after sorting..");
//        System.out.println(phoneNumbers);
//        phoneNumbers.sort(phoneNumberComparator3);
//        System.out.println("after sorting..");
//        System.out.println(phoneNumbers);



    }
}
