package lesson7;

import java.lang.reflect.Array;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {
	public static final int[]	ARRAY = {1,2,3,4,5,6,7,8,9,10};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.err.println("Sum="+sum(ARRAY, 0, ARRAY.length-1));

		final Calc	c = new Calc(ARRAY, 0, ARRAY.length-1);
		
		ForkJoinPool.commonPool().execute(c);
		System.err.println("Sum="+c.join());
	}

	public static int sum(final int[] array, final int from, final int to) {
		if (from == to) {
			return array[from];
		}
		else {
			final int median = (from + to) >> 1;
			
			return sum(array, from, median) + sum(array, median + 1, to); 
		}
	}

	public static class Calc extends RecursiveTask<Integer> {
		private final int[] array;
		private final int from; 
		private final int to; 
		
		public Calc(final int[] array, final int from, final int to) {
			this.array = array;
			this.from = from;
			this.to = to;
		}

		@Override
		protected Integer compute() {
			if (from == to) {
				return array[from];
			}
			else {
				final int median = (from + to) >> 1;
				final Calc left = new Calc(array, from, median);
				final Calc right = new Calc(array, median + 1, to);
				
				return left.fork().join() + right.fork().join();
//				return sum(array, from, median) + sum(array, median + 1, to); 
			}
		}
	}

}
