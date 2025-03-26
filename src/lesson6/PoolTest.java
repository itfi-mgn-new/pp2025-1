package lesson6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PoolTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread	t = new Thread(()->{
							System.err.println("Hello world 1");
						});
		t.start();
		// TODO:  sdkfjklsdfkljdsklfjlksdf
		t.join();
		// TODO: sdklfklsdjfl

		
		ExecutorService	ex = Executors.newFixedThreadPool(2);
		
		Future		f = ex.submit(()->{
						System.err.println("Hello world 2");
					});	// new Thread(...).start();
		// TODO: mksdjfkljdskfj
		try {
			f.get();	// t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO: sdklfklsdjfl
		
		ex.shutdown();
		
	}
}
