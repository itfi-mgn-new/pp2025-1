package lesson2;

import java.util.Arrays;

import javax.imageio.stream.MemoryCacheImageInputStream;

public class ArraysTEst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object	x = new int[10];
		int[]	y = (int[])x;
		int		z, t[] = null, tt[] = new int[]{2,3,12,71};

		for(int index = 0; index < y.length; index++) {
			System.err.println("Y["+index+"]="+y[index]);
		}
		
		int sum = 0;
		for(int index = 0; index < tt.length; index++) {
			sum += tt[index];
		}
		System.err.println("Sum="+sum);
		
		sum = 0;
		for(int item : tt) {
			sum += item;
		}
		System.err.println("Sum2="+sum);
		
		System.err.println("l="+y.length);
		
		int[][]	zz = new int[][]{new int[] {2,3,4}, null, new int[] {7}};
	
		for (int[] item : zz) {
			System.err.println("Item="+java.util.Arrays.toString(item/*.toString()*/));
		}
		
	}

}
