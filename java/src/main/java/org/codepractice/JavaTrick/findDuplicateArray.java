package org.codepractice.JavaTrick;

import java.util.HashSet;
import java.util.Set;

public class findDuplicateArray {

    // https://javaconceptoftheday.com/find-duplicates-in-array-in-java/
    private static void findDuplicatesUsingHashSet(String[] inputArray) {
        HashSet<String> set = new HashSet<String>();
        for (String element : inputArray) {
            if (!set.add(element)) {
                System.out.println("Duplicate Element : " + element);
            }
        }
    }

    // https://www.java67.com/2015/10/2-ways-to-find-duplicate-elements-in-java-array.html
    public static <T extends Comparable<T>> boolean isDuplication(T[] array) {
        Set<T> dupes = new HashSet<T>();
        for (T i : array) {
            if (!dupes.add(i)) {
                System.out.println("Duplicate element in array is : " + i);
                return true;
            }
        }
        return false;
    }

}
