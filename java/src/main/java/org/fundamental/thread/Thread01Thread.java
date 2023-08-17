package org.fundamental.thread;

/**
 * <pre>
 *
 * </pre>
 *
 * @author mckang
 * @since 2023-01-03
 */
public class Thread01Thread extends Thread {
	private String msg;

	public Thread01Thread(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println(msg);
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread01Thread("Nice");
		thread.start();
		thread.join();

	}
}
