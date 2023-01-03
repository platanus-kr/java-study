package org.fundamental.collection;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DequeCheatsheet {
	public static void main(String[] args) {
		Deque<Integer> dq = new ArrayDeque<>();
		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.add(4);
		dq.push(5);
		dq.push(6);
		dq.push(7);
		dq.push(8);
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());
		System.out.println(dq.pop());

		System.out.println("------------------");

		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.add(4);
		dq.push(5);
		dq.push(6);
		dq.push(7);
		dq.push(8);

		Integer integer = dq.peekFirst();
		System.out.println(integer);
		System.out.println("--");
		while(dq.peek() != null) {
			System.out.println(dq.poll());
		}

		System.out.println("------------------");

		dq.add(1);
		dq.add(2);
		dq.add(3);
		dq.add(4);
		dq.push(5);
		dq.push(6);
		dq.push(7);
		dq.push(8);

		Iterator<Integer> integerIterator = dq.descendingIterator();
		while(integerIterator.hasNext()) {
			System.out.println(integerIterator.next());
		}
	}
}
