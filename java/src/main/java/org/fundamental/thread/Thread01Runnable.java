package org.fundamental.thread;

import java.util.concurrent.ExecutorService;

/**
 * <pre>
 *
 * </pre>
 *
 * @author mckang
 * @since 2023-01-03
 */
public class Thread01Runnable implements Runnable {

	private String msg;

	public Thread01Runnable(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println(msg);
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Thread01Runnable(
				"SimpleRunnable executed using Thread"));
		thread.start();
		thread.join();


	}
}
