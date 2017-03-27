package cs3;

public class BrickTest {
	private int breaksAt;
	
	public BrickTest(int breaksAt) {
		this.breaksAt = breaksAt;
	}
	
	public int test(int n, int k) {
		return test(1, n, k);
	}
	
	private int test(int beg, int end, int k) {
		System.out.println("Test llamado con beg = " + beg + " end = " + end);
		int breaks = -1;
		if(k == 1) {
			for(int i=beg; i <= end; i++) {
				if (i == breaksAt) {
					breaks = i;
				}
			}			
		} else if(k >= 2) {
			breaks = test(beg, (end-beg)/2, k-1);
			if (breaks == -1) {
				breaks = test((end-beg)/2, end, k-1);
			}
		}		
		return breaks;
	}
	
}
