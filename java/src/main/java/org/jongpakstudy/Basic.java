package org.jongpakstudy;

public class Basic {

    public Basic(String test) {
        System.out.println(test);
    }

    // 시그니쳐 = 함수원형 = 프로토타입 = 함수의 생긴 모양새
    public static void main(String[] args) {
        System.out.println("Hello Canxan");

        // 자바는 객체지향이기는 한데..
        // static - 함수호출 (유틸리티성)
        System.out.println(System.getenv());

        int a = 10;
        float b = 10;

        // auto-boxing
        Integer aa = a;
        String d = "fgjhfgjh";

        // 인스턴스화 = 설계된 클래스대로 실제로 객체를 만드는 과정
        MyClass myClass = new MyClass("Jongpak");
        myClass.test();

        myClass.pp = "tt";

        MyClass.gg();

    }

    // java -cp
    //      --classpath

    // java -jar

    // tomcat
    //

    // int main(char* args) { }

}
