package cs4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		int[] a = {2, 10, 20, 40, 80};
		ArrayList<Integer> solution = TileFLoorAlgo.tileFloor(a, 100);
		
		for(int i = 0; i < solution.size(); i++) {
			System.out.println(solution.get(i));
		}
	}

}
