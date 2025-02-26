package lesson2;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedTEst {
	public static final AtomicInteger	value = new AtomicInteger(0);
	public static final Object	sync = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		final Thread[]	t = new Thread[10];
		for(int index = 0; index < t.length; index++) {
			t[index] = new Thread(()->inc());
		}
		for(int index = 0; index < t.length; index++) {
			t[index].start();
		}
		for(int index = 0; index < t.length; index++) {
			t[index].join();
		}
		System.err.println("Count="+value);
	}

	private static void inc() {
		for (int count = 0; count < 10000; count++) {
//			// dskjfksdjfjsdklfj
//			synchronized(sync) {	// try { 
//									//			aload sync
//									//			monitorenter
//				value
//				++;
//			}						// } finally {
//									//			aload sync
//									//			montorexit
//									// }
//			// sdkjkdsfjlksdjflkjsdlkfj
			value.incrementAndGet();
		}
	}
}
