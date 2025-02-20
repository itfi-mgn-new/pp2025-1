package lesson2;

import java.util.Objects;

public class ObjectTEst {
	int	x;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object	x = new Object();//null;
		Object	y = x;
		
		x.toString();
		y = null;
		//x = null;
		
		boolean b = x == y;
		
		if (x instanceof String) {
			System.err.println("Yes");
		}
		else {
			System.err.println("No");
		}
		
		
		System.err.println("x="+x/*.toString()*/);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(x);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectTEst other = (ObjectTEst) obj;
		return x == other.x;
	}

	
}
