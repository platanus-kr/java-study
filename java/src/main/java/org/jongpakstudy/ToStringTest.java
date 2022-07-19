package org.jongpakstudy;

public class ToStringTest {

    public static void main(String[] args) {
        ToStringObject toStringObject = new ToStringObject();

        // 로그로 찍어하는 상황
        // tomcat.log
        System.out.println(toStringObject);

        // org.jongpak.ToStringTest$ToStringObject@77459877
        // ToStringObject{a='a', b='b', c='c', d='d', e='e'}
    }

    // 모든 객체는 Object를 상속한다 (최상위 객채)
    public static class ToStringObject /*extends Object*/ {

        private String a = "a";
        private String b = "b";
        private String c = "c";
        private String d = "d";
        private String e = "e";

        @Override
        public String toString() {
            return "ToStringObject{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                ", e='" + e + '\'' +
                '}';
        }
    }

}
