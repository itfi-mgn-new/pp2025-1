package lesson2;

import java.io.IOException;

public class InterruptTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread	t = new Thread(InterruptTest::run);
		t.start();
		Thread.sleep(2000);
		t.interrupt();
		t.join();
		System.err.println("Joined");
	}

	private static void run() {
		while (!Thread.interrupted()) {
	//		try {
				System.err.println("T="+System.currentTimeMillis());
				try {
					m1();
				} catch (RuntimeException exc) {
					if (exc.getCause() instanceof InterruptedException) {
						System.err.println("Interrupted");
						break;
					}
					else {
						throw exc;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			} catch (InterruptedException e) {
//				System.err.println("Interrupteds");
//				break;
//			}
		}
	}

	private static void m1() throws IOException {
		try{
			Thread.sleep(100);
		} catch (InterruptedException exc) {
			Thread.currentThread().interrupt();
			throw new RuntimeException(exc);
		}
		
	}
}
