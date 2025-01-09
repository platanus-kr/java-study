package org.jongpak;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {

    public static void main(String[] args) {
//        final int var1 = 30;
//        var1 = 25;

        // (1) 리스트
        List<String> stringList = new ArrayList<>();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
        stringList.add("fourth");
        stringList.add("fifth");
        System.out.println(stringList);
        System.out.println(stringList.get(3));
        System.out.println(stringList.contains("third"));
        System.out.println(stringList.lastIndexOf("second"));

        List<Integer> numberListList = new ArrayList<>();

        // const char* str = "fdfsdf";

        // (1) original
        for (int i = 0; i < stringList.size(); i++) {
            System.out.println("Hello Old-style: " + stringList.get(i));
        }

        // (2) enhanced for
        for (String item : stringList) {
            System.out.println("Hello: " + item);
        }

        // (3) iterator (반복자)
        Iterator<String> iter = stringList.iterator();
        while (iter.hasNext()) {
            System.out.println("Iterator: " + iter.next());
        }

        System.out.println("-----------------------------------");

        // --------------------------------------------
        // (2) Set
        Set<String> set = new TreeSet<>();
        set.add("jongpak");
        set.add("platanus");
        set.add("dongkyu");
        set.add("kong");
        set.add("jongpak");
        System.out.println(set.size());
        System.out.println(set.contains("test"));

        for (String item : set) {
            System.out.println(item);
        }

        System.out.println("-----------------------------------");

        // ------------------------------------------
        // (3) Map (mapping / key-value)
        Map<String, String> map = new HashMap<>();
        map.put("jongpak", "jongpak.com");
        map.put("platanus", "platanus.org");
        map.put("platanus", "canxan.com");
        map.put("naver", "naver.com");
        System.out.println(map.get("platanus"));

        // 프로그래밍 패러타임
        // 숫자, 문자 ---> 의미를 부여.. ===> 메직넘버보다는 enum을 쓰자
//        DownloadStatus status;
//        // 크롤링코드..
//        status = DownloadStatus.ERROR;
//        /// .....
//        status = DownloadStatus.SUCCESS;
    }

    enum DownloadStatus {
        ERROR,
        SUCCESS,
        READY,
        NOT_YES
    }

}
