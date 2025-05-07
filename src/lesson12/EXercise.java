package lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class EXercise {
	public static final BlockingQueue<Request> queue = new ArrayBlockingQueue<>(10);
	public static final boolean	sticks[] = {true,true,true,true,true};
	public static final List<Request> rejected = new ArrayList<>();
	
	public static interface Steward extends AutoCloseable {
		int getStick1();
		int getStick2();
		void close() throws RuntimeException;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Thread	t = new Thread(()->{wait4Requset();});

		final Thread	t1 = new Thread(()->{loop(0,1);});
		final Thread	t2 = new Thread(()->{loop(1,2);});
		final Thread	t3 = new Thread(()->{loop(2,3);});
		final Thread	t4 = new Thread(()->{loop(3,4);});
		final Thread	t5 = new Thread(()->{loop(0,4);});
		
		t.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		/*
		 * synchronized(stick1) {
		 * 	synchronized(stick1) {
		 *		EAT(); 
		 * 	}
		 * }
		 * THINK();
		 * 
		 */
		
		/*
		 *  try(final Steward	s = getSticks(1,2)) {
		 *     EAT();
		 * 	}
		 *  THINK();
		 */
		
	}
	
	private static void loop(final int stick1, final int stick2) {
		for (;;) {
		 	try(final Steward	s = getSticks(1,2)) {
		 		EAT();
		 	}
		 	THINK();
		}
	}

	private static void wait4Requset() {
		// TODO Auto-generated method stub
		for (;;) {
			try {
				final Request	rq = queue.take();
			
				if (rq.take) {
					if (sticks[rq.stick1] && sticks[rq.stick2]) {
						sticks[rq.stick1] = false;
						sticks[rq.stick2] = false;
						rq.latch.countDown();
					}
					else {
						rejected.add(rq);
					}
				}
				else {
					sticks[rq.stick1] = true;
					sticks[rq.stick2] = true;
					for (int index = 0; index < rejected.size(); index++) {
						final Request	rqEarlier = rejected.get(index);
								
						if (sticks[rqEarlier.stick1] && sticks[rqEarlier.stick2]) {
							sticks[rqEarlier.stick1] = false;
							sticks[rqEarlier.stick2] = false;
							rqEarlier.latch.countDown();
							rejected.remove(index);
							index--;
						}
					}
				}
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	static Steward getSticks(final int stickNo1, final int stickNo2) {
		final Request	rq = new Request(true, stickNo1, stickNo2);
		
		try {
			queue.put(rq);
			rq.latch.await();

			return new Steward() {
				@Override
				public int getStick2() {
					return stickNo2;
				}
				
				@Override
				public int getStick1() {
					return stickNo1;
				}
				
				@Override
				public void close() throws RuntimeException {
					final Request	rq = new Request(false, stickNo1, stickNo2);
				
					try {
						queue.put(rq);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			};
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	static void EAT() {
		System.err.println("Thread: "+Thread.currentThread().getName()+" eating...");
	}
	
	static void THINK() {
		System.err.println("Thread: "+Thread.currentThread().getName()+" thinking...");
	}
	
	static class Request {
		final boolean	take;
		final int		stick1;
		final int		stick2;
		final CountDownLatch	latch = new CountDownLatch(1);
		
		public Request(final boolean take, final int stick1, final int stick2) {
			this.take = take;
			this.stick1 = stick1;
			this.stick2 = stick2;
		}

		@Override
		public String toString() {
			return "Request [take=" + take + ", stick1=" + stick1 + ", stick2=" + stick2 + "]";
		}
	}
}
