package lesson11;

public class EXercise {
	public static interface Steward extends AutoCloseable {
		int getStick1();
		int getStick2();
		void close() throws RuntimeException;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	
	static Steward getSticks(int stickNo1, int stickNo2) {
		// TODO:
	}

}
