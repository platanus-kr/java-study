package com.example.async01;

import java.util.concurrent.TimeUnit;

public class Utils {
	public static void sleepThisThread(long sleepMs) {
		if (sleepMs < 1) {
			return;
		}
		long sleepTimeNanos = TimeUnit.MILLISECONDS.toNanos(sleepMs);
		long startTimeNanos = System.nanoTime();
		long loopTimeNanos = System.nanoTime() - startTimeNanos;

		while (loopTimeNanos >= 0 && loopTimeNanos <= sleepTimeNanos) {
			loopTimeNanos = System.nanoTime() - startTimeNanos;
		}
	}
}
