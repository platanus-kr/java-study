package org.platanus.stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> {

    @Override
    public String apply(String s, String s2) {
        if (s.getBytes().length >= s2.getBytes().length) {
            return s;
        } else {
            return s2;
        }
    }
}

public class ReduceTest {

    public static void main(String[] args) {
        String[] greetings = {"안녕하세요", "헬로", "곤방와", "봉쥬르"};
        System.out.println(
            Arrays.stream(greetings)
                .reduce("", (s1, s2) -> {
                    if (s1.getBytes().length >= s2.getBytes().length) {
                        return s1;
                    } else {
                        return s2;
                    }
                })
        );

        String str = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(str);
    }
}
