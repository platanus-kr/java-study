package org.platanus;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getId() + ":: test");
//            //try {  Thread.sleep(100);  } catch (InterruptedException e) {  }
//            System.out.println(Thread.currentThread().getId() + ":: test");
//            for (int i = 0; i < 1000; i++) {
//                for (int j = 0; j < 1000; j++) {
//                    System.out.println(Thread.currentThread().getId() + ":: i * j = " + i * j);
//                }
//            }
            while (true) {
                System.out.println("Cronjob-1");
                try {  Thread.sleep(1000);  } catch (InterruptedException e) {  }
            }
        });
        Thread thread2 = new Thread(() -> {
//            System.out.println(Thread.currentThread().getId() + ":: test2");
//            //try {  Thread.sleep(100);  } catch (InterruptedException e) {  }
//            System.out.println(Thread.currentThread().getId() + ":: test2");
//            for (int i = 0; i < 1000; i++) {
//                for (int j = 0; j < 1000; j++) {
//                    System.out.println(Thread.currentThread().getId() + ":: i * j = " + i * j);
//                }
//            }
            while (true) {
                System.out.println("Cronjob-2");
                try {  Thread.sleep(1000);  } catch (InterruptedException e) {  }
            }
        });
        thread1.start();
        thread2.start();
    }

}
