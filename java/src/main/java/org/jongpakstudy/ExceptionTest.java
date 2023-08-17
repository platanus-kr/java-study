package org.jongpakstudy;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class ExceptionTest {

    // 예외
    // -> 오류상황에 대한 처리

    public static void main(String[] args) throws MalformedURLException {
        int[] a = {1, 2, 3};

        // AS-IS: [I@38af3868
        // TO-BE: [1, 2, 3]
        System.out.println(Arrays.toString(a));

        // PHP, javascript: null?, warning?
        // java - exception
        try {
            System.out.println(a[3]);
        } catch (Exception e) {
            System.err.println("Sorry, " + e);
        }

        // 예외라는 상태를 왜 만들었을까?
        // 오류라면 null, -1, 0 이런 상태값을 사용할수도 있는데..
        // 굳이, 예외는 리턴되는 것도 아닌데.. 왜 예외를 던지게 해놨을까?
        // --> 구분해줄려고..
        //      => 리턴값: 함수의 처리값에 대한 결과
        //      => 예외: 성공/실패의 명확한 구분을 위해서 언어에서 제공하는 메커니즘
        // --> C언어에는 예외가 없어서 -1, null 로 구분을 해주는데..
        System.out.println("Result = " + savePlusOneAge(30));

        try {
            // 만약에 음수 나이도 인정한다면..?
            System.out.println("Result = " + savePlusOneAge(-5));
        } catch (Exception e) {
            System.err.println(e);
            // ignore
        }

        // 무조건 예외를 처리하도록 강제하는 경우: checked exception (Exception)
        // 강제하지 않는 경우: un-checked exception (RuntimeException)
//        new URL("https://m.naver.com");
//        System.out.println(a[100]);

//        throw new Exception("Sorry");
//        throw new RuntimeException("Oops");
        try {
            InputStream is = new URL("https://m.naver.com").openConnection().getInputStream();
            System.out.println(
                new String(is.readAllBytes())
                    .substring(0, 32)
                    .trim()
                    .toUpperCase()
                    .replace("<", "[")
            );
            // -1: malformd
            // -2: io/exception
            // 언어에 대한 메커니즘
        } catch (MalformedURLException e) {
            System.err.println("올바르지 않은 주소" + e.getMessage());
        } catch (IOException e) {
            System.err.println("접속 에러");
        }

        System.out.println("End");
    }

    // java > test.log

    public static int savePlusOneAge(int age) {
        if (age < 0) {
            throw new RuntimeException("Oh, Age must > 0");
        }

        System.out.println("Saved Age = " + age);
        return age + 1;
    }


}
