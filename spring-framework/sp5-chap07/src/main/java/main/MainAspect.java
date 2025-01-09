package main;

import chap07.RecurrenceCalculator;
import config.AppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAspect {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
            AppContext.class);

        RecurrenceCalculator calculator = context.getBean("calculator", RecurrenceCalculator.class);
        long fiveFactorial = calculator.factorial(5);
        System.out.println("calculator.factorial(5) = " + fiveFactorial);
        System.out.println(calculator.getClass().getName());
        context.close();
    }

}
