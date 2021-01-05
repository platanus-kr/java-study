package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppContext.class);

        // Bean으로 부터 객체를 생성받기
        Greeter g = context.getBean("greeter", Greeter.class);
        String messages = g.greet("스프링");
        System.out.println(messages);

        // 스프링이 생성하는 객체는 싱글톤 범위를 갖는다 (다른 프로토타입 가능)
        Greeter g1 = context.getBean("greeter", Greeter.class);
        Greeter g2 = context.getBean("greeter", Greeter.class);
        System.out.println("(g1 == g2)? : " + (g1 == g2));

        context.close();
    }
}
