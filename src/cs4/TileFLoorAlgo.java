package cs4;

import java.util.ArrayList;
import utils.QuickSort;

public class TileFLoorAlgo {
	public static ArrayList<Integer> tileFloor(int[] tiles,int n) {
		int[][] floor = new int[n][n];
		int current;
		ArrayList<Integer> solution = new ArrayList<Integer>();
		QuickSort.quicksort(tiles);
		int size;
			for (int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if (floor[i][j] == 0) {
						current = tiles.length - 1;
						size = tiles[current];
						while(current > 0 && 
								!(i+size<=n && j+size<=n)) {
							current--;
							size = tiles[current];
						}
						solution.add(size);
						for(int x = i; x <= i + size - 1; x++) {
							for(int y = j; y <= j + size - 1; y++) {
								floor[x][y] = size;
							}
						}
					}
				}
			}
		return solution;
	}
}
