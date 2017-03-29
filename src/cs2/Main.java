package cs2;

import cs1.SortingAlgorithms;

public class Main {

	public static void main(String[] args) {
		float time_start; float time_end; float valor;
		for(int n = 1; n <= 40; n++) {
			System.out.print("n = " + n);
			time_start = System.nanoTime();
			valor = FiboAlgorithms.fiboRec(n);
			time_end = System.nanoTime() - time_start;
			System.out.print(", time fiboRec = " + time_end + ", valor fiboRec = " + valor);
			
			time_start = System.nanoTime();
			valor = FiboAlgorithms.fiboIter(n);
			time_end = System.nanoTime() - time_start;
			System.out.print(", time fiboIter = " + time_end +  ", valor fiboIter = " + valor + "\n");		
		}
	}
}
