package org.platanus.collection.TreeSet;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Compare implements Comparator<String> {
    @Override
    public int compare(String arg1, String arg2) {
        return arg1.compareTo(arg2);
    }

}

public class ComparatorTest {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>(new Compare());
        set.add("esens");
        set.add("ximya");
        set.add("mastawu");


        System.out.println(set);

    }
}
