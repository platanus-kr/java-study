package threads;

public class SimpleRunnableApplication {
    public static void main(String[] args) {
        Thread t1 = new Thread(new SimpleRunnableTask());

        t1.start();
    }
}
