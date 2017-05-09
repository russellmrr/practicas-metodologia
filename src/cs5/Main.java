package cs5;

import java.util.ArrayList;

import cs5.TileFloorBacktracking;

public class Main {

	public static void main(String[] args) {
		int[] a = {1, 2, 40, 80};
		TileFloorBacktracking tfb = new TileFloorBacktracking(8, a);
		tfb.backtrackSol(0, 0);
		int[][] solution = tfb.getBestSolution();
		for(int i = 0; i < solution.length; i++) {
			for(int j = 0; j < solution.length; j++) {
				System.out.print(solution[i][j]);
			}
			System.out.print("\n");
		}
	}

}
