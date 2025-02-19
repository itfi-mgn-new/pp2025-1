package lesson1;

public class ThreadTest {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.err.println("ss: "+Thread.currentThread().getName());

		for(int index = 0; index < 10; index++) {
			final int index1 = index;
			
			final Thread	t = new Thread(()->{
								System.err.println("Thread "+index1+" "
									+Thread.currentThread().getName()+" "
									+Thread.currentThread().getState());
							});
			t.setName("My thread "+index1);
//			System.err.println("State="+t.getState());
//			t.setDaemon(true);
			t.setPriority(Thread.MIN_PRIORITY);
			t.start();
// djfdsfhsdfjhsdjfhjkhf
			t.join();
		}
	}
}
