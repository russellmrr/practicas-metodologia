package cs3;

public class BrickTest {
	private int breaksAt;
	private int tiradas;

	public BrickTest(int breaksAt) {
		this.breaksAt = breaksAt;
		this.tiradas = 0;
	}
	
	
	public int getTiradas() {
		return tiradas;
	}

	public void setTiradas(int tiradas) {
		this.tiradas = tiradas;
	}
	
	public int test(int n, int k) {
		tiradas = 0;
		return test(1, n, k);
	}
	
	
	public int getBreaksAt() {
		return breaksAt;
	}


	public void setBreaksAt(int breaksAt) {
		this.breaksAt = breaksAt;
	}


	private int test(int beg, int end, int k) {
		int breaks = -1;
		if (beg == end) {
			breaks = beg;
		} else if(k == 1) {
			for(int i=beg; i <= end; i++) {
				tiradas++;
				if (i == breaksAt) {
					breaks = i;
					break;
				}
			}	
		} else if(k >= 2) {
			int mitad = (end-beg)/2+beg;
			tiradas++;
			if(breaksAt <= mitad) { // se rompe
				breaks = test(beg, mitad, k-1);
			} else { // no se rompe
				breaks = test(mitad+1, end, k-1);
			}
		}	
		return breaks;
	}
	
}
