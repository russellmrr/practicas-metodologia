package cs3;

public class Main {


	public static void main(String[] args) {
		BrickTest bt = new BrickTest(9);
		int[] k_val = {1, 2, 10, 100, 1000};
		for(int n = 10; n <= 1000000; n *= 10) {
			for(int k = 0; k < k_val.length; k++) {
				long t_start = System.nanoTime();
				bt.test(n,  k_val[k]);
				long t_elapsed = System.nanoTime() - t_start;
				System.out.format("n=%d, k=%d, tiradas=%d, " +
						"tiempo=%d%n", n, k_val[k], bt.getTiradas(), t_elapsed);
			}
		}
	}
}
