package concurrentcollections;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencyExample {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> hashtable = new Hashtable<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();

        // HashMap은 멀티스레드 환경에서 안전하지 않습니다. 아래의 코드는 예상치 못한 결과를 출력할 수 있습니다.
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put("key" + i, "value" + i);
            }
            System.out.println("----------------------");
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(hashMap.get("key" + i));
            }
            System.out.println("----------------------");
        }).start();

        // ConcurrentHashMap은 멀티스레드 환경에서 안전하게 사용할 수 있습니다.
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.put("key" + i, "value" + i);
            }
            System.out.println("----------------------");
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(concurrentHashMap.get("key" + i));
            }
            System.out.println("----------------------");
        }).start();
    }
}
