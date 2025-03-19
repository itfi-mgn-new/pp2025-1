package lesson4;

import java.util.concurrent.CountDownLatch;

public class EXercise {
	static final int[][]	content = new int[][] {new int[]{2,3}, new int[]{4,5}};
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final CountDownLatch	latch = new CountDownLatch(content.length);
		final Thread[]		threads = new Thread[content.length];
		final int[]			partials = new int[content.length];
		
		for(int index = 0; index < content.length; index++) {
			final int	current = index;
			final Thread	t = new Thread(()->{
								try {
									partials[current] = calc(content[current]);
								} finally {
									latch.countDown();
								}
							});
			threads[index] = t;
		}
		
		for(Thread t : threads) {
			t.start();
		}
		latch.await();
		System.err.println("Sum="+calc(partials));
	}

	private static int calc(final int[] content) {
		int	sum = 0;
		
		for(int val : content) {
			sum += val;
		}
		return sum;
	}

}
