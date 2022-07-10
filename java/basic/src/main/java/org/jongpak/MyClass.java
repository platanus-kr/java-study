package org.jongpak;

public class MyClass {

    // 내부에서만 보임
    private String message = "Korea";

    // 외부에서도 보임
    public String pp = "test";

    // 같은 패키지 내부에서만 보임 (다른 상황에서: 상속받은 녀석에서만 보임)
    protected String p2 = "gg";

    // 생성자
    public MyClass(String message) {
        this.message = message;
    }

    public void test() {
        System.out.println("Hello " + this.message);
    }

    // 인스턴스화 하지 않아도 보임
    public static void gg() {
        System.out.println("Wow. ");
    }

}
