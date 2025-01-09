package main;

import chap07.Calculator;
import config.AppContextWithCache;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspectWithCache {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppContextWithCache.class);

        Calculator calculator = context.getBean("calculator", Calculator.class);
        calculator.factorial(7);
        calculator.factorial(7);
        calculator.factorial(3);
        calculator.factorial(7);
        calculator.factorial(7);
        calculator.factorial(3);
        calculator.factorial(5);
        calculator.factorial(5);
        calculator.factorial(5);
        calculator.factorial(5);
        context.close();
    }

}
