package org.fundamental.collection;

import java.util.ArrayList;
import java.util.ListIterator;

public class IteratorTest {
	public static void main(String args[]) {
		// Create a new ArrayList
		ArrayList l = new ArrayList();

		// Add some items to the ArrayList
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);

		ListIterator i = l.listIterator();

		// Loop through ArrayList contents
		while(i.hasNext()) {
			Object item = i.next();
			System.out.print(item + ", ");
		}

		System.out.println();

		// Loop back through ArrayList contents
		while(i.hasPrevious()) {
			Object item = i.previous();
			System.out.print(item + ", ");
		}
	}
}
