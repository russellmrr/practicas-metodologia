package cs2;

public class FiboAlgorithms {

	public static long fiboRec(long n) {
		if(n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fiboRec(n-1) + fiboRec(n-2);
		}
	}
	
	public static long fiboIter(long n) {
		long a = 0;
		long b = 1;
		for(long i = 1; i < n; i++) {
			long aux = b;
			b = a + b;
			a = aux;
		}
		return b;
	}
}
	
