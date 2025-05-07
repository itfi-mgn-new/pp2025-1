package lesson12;

public class Cash {
	public static final int	TOTAL_SUM = 1000;

	public interface Sum extends AutoCloseable {
		int getSum();
		@Override
		void close() throws RuntimeException;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread	t1 = new Thread(()->life());
		. . .
		Thread	t20 = new Thread(()->life());
		
		
	}

	static void life() {
		for (;;) {
			final int	sum = (int) (100 * Math.random());
	
			try(final Sum	used = getSum(sum)) {
				use();
			}
			free();
		}
	}
	
	static Sum getSum(final int sum) {
		// TODO: 
	}
	
	static void use() {
		try {
			Thread.sleep((long) (5000 * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	static void free() {
		try {
			Thread.sleep((long) (10000 * Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
