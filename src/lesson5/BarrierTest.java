package lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final CyclicBarrier	cb = new CyclicBarrier(3);
		final CyclicBarrier	cb2 = new CyclicBarrier(3);
		
		final Thread	t1 = new Thread(()->{
			while (!Thread.interrupted()) {
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					break;
				}
				doSomething();
				try {
					cb2.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					break;
				}
			}
		});
		final Thread	t2 = new Thread(()->{
			while (!Thread.interrupted()) {
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					break;
				}
				doSomething();
				try {
					cb2.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					break;
				}
			}
		});
		t1.start();
		t2.start();

		for(int loop = 0; loop < 10; loop++) {
			// doPrepare();
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			} finally {
				cb.reset();
			}
			doSomething();
			try {
				cb2.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			} finally {
				cb2.reset();
			}
			System.err.println("Loop: "+loop+", THE END");
		}
		t1.interrupt();
		t2.interrupt();
	}

	private static void doSomething() {
		System.err.println("Do: "+Thread.currentThread().getName());
	}

}
