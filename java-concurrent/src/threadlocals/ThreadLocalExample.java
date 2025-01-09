package threadlocals;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {

    // ThreadLocal 변수를 생성합니다. 각 스레드는 이 변수를 통해 자신만의 SimpleDateFormat 인스턴스를 관리합니다.
    private static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() ->
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    );

    private static final ThreadLocal<SimpleDateFormat> dateFormatThreadLocalAsFunctional = new ThreadLocal<>() {
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        // 두 개의 스레드를 생성하고, 각각의 스레드에서는 ThreadLocal을 통해 독립적인 dateFormat 객체를 사용합니다.
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: " + formatDate(new Date()));
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: " + formatDate(new Date()));
        });

        thread1.start();
        thread2.start();


        Thread thread3 = new Thread(() -> {
            System.out.println("Thread 3: " +formatDateAsFunctional(new Date()));
        });

        Thread thread4 = new Thread(() -> {
            System.out.println("Thread 4: " +formatDateAsFunctional(new Date()));
        });

        thread3.start();
        thread4.start();

    }

    // 날짜를 형식화하는 메소드입니다. 여기에서 ThreadLocal을 사용하여 각 스레드마다 독립적인 SimpleDateFormat 객체를 반환받습니다.
    private static String formatDate(Date date) {
        return dateFormatThreadLocal.get().format(date);
    }

    private static String formatDateAsFunctional(Date date) {
        return dateFormatThreadLocalAsFunctional.get().format(date);
    }
}
