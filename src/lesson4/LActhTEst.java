package lesson4;

import java.util.concurrent.CountDownLatch;

public class LActhTEst {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		final CountDownLatch	latch = new CountDownLatch(1);
		final Thread	t1 = new Thread(()->{
									System.err.println("Before");
									try {
										Thread.sleep(100);
										latch.await();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.err.println("After");
								});
		final Thread	t2 = new Thread(()->{
									System.err.println("Before 2");
									try {
										Thread.sleep(100);
										latch.await();
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									System.err.println("After 2");
								});
		t1.start();
		t2.start();
		
//		Thread.sleep(100);
		
		System.err.println("Before down");
		latch.countDown();
		System.err.println("After down");
		
	
	}

}
