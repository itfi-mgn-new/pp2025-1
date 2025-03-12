package lesson3;

import java.util.concurrent.Exchanger;

public class EXchangerTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Exchanger<String>	ex = new Exchanger<>();
	
		final Thread	t1 = new Thread(()->{
							System.err.println("Before");
							try {
								System.err.println("Received:"+ex.exchange("value1"));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.err.println("After");
						});
		final Thread	t2 = new Thread(()->{
							System.out.println("Before");
							try {
								System.out.println("Received:"+ex.exchange("another"));
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("After");
						});
		t1.start();
		t2.start();
	}

}
