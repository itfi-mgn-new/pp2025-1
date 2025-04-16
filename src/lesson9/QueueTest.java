package lesson9;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {
	public static final String	THE_END = "theEnd";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BlockingQueue<String>	queue = new ArrayBlockingQueue<>(10);
		Thread	t = new Thread(()->{
			while (!Thread.interrupted()) {
				try {
					final String	s = queue.take();
					
					if (THE_END.equals(s)) {
						break;
					}
					else {
						System.err.println("get: "+s);
					}
				} catch (InterruptedException e) {
					break;
				}
			}
		});
		t.setDaemon(true);
		t.start();
		
		queue.put("test string 1");
		queue.put("test string 2");
		queue.put(THE_END);

//		t.interrupt();
		t.join();
	}

}
