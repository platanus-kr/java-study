package org.fundamental.collection.Arraylist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListCheatsheet {

	public static void main(String[] args) {
		List<String> L1 = new ArrayList<>();


		L1.add("A1");
		L1.add(1, "A2");
		L1.add(2, "A3");


		for (String s : L1) {
			System.out.println(s);
		}

		System.out.println("------------");

		List<String> L2 = new ArrayList<>();
		L2.add("B1");
		L2.add("B2");
		L2.add("B3");

		L1.addAll(L2);
		for (String s : L1) {
			System.out.println(s);
		}

		System.out.println("------------");

		System.out.println(L1.contains("B1"));

		System.out.println("------------");

		Iterator<String> iterator = L1.iterator();
		while (iterator.hasNext()) {
			String next = iterator.next();
			System.out.println(next);
		}

		System.out.println("------------");

		ListIterator<String> stringListIterator = L1.listIterator();
		while (stringListIterator.hasNext()) {
			String next = stringListIterator.next();
			System.out.println(next);
		}

		System.out.println("------------");

		//List<String> retainTarget = Arrays.asList("A1", "A2", "A4");
		List<String> retainTarget = Arrays.asList(new String[]{"A1", "A2", "A4"});
		L1.retainAll(retainTarget);
		for (String s : L1) {
			System.out.println(s);
		}

		System.out.println("------------");

		String[] strings = {"A1", "A2", "A4"};

		String[] strings1 = Arrays.copyOf(strings, strings.length);
		for (String s : strings1) {
			System.out.println(s);

		}
	}
}
