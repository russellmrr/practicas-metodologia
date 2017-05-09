package cs5;

import java.util.ArrayList;
import utils.QuickSort;

public class TileFloorBacktracking {
	
	private int n;
	private int[] tile;
	private int[][] floor;
	private int bestNumber;
	private int[][] bestSolution;
	
	public TileFloorBacktracking(int n, int[] tile) {
		this.n = n;
		QuickSort.quicksort(tile);
		int[] rTile = new int[tile.length];
		int j = 0;
		for(int i = tile.length - 1; i >= 0; i--) {
			rTile[j] = tile[i];
			j++;
		}
		this.tile = rTile;
		this.floor = new int[n][n];
		this.bestNumber = 9999999;
		this.bestSolution = new int[n][n];
	}
	
	public int[][] getFloor() {
		return floor;
	}
	
	public int[][] getBestSolution() {
		return bestSolution;
	}
	
	public void backtrackSol (int row, int current) {
		int column = findEmptyColumn(row);
		while ((column == n) && (row < n)) {
			row += 1;
			if(row < n) {
				column = findEmptyColumn(row);
			}
		}
		
		if(row == n) {
			if(current < bestNumber) {
				for(int i = 0; i < bestSolution.length; i++) {
					bestSolution[i] = floor[i].clone();
				}
				bestNumber = current;
			}
		} else {
			for(int t = 0; t < tile.length; t++) {
				if (roomAvailable(tile[t], row, column)) {
					for(int i = row; i < row + tile[t]; i++) {
						for(int j = column; j < column + tile[t]; j++) {
							floor[i][j] = tile[t];
						}
					}
					backtrackSol(row, current + 1);
					for(int i = row; i < row + tile[t]; i++) {
						for(int j = column; j < column + tile[t]; j++) {
							floor[i][j] = 0;
						}
					}
				}
			}
		}
	}
	
	private boolean roomAvailable(int tileSize, int row, int column) {
		if(((row + tileSize) > n) || ((column + tileSize) > n)) {
			return false;
		}
		for(int i = row; i < row + tileSize; i++) {
			for(int j = column; j < column + tileSize; j++) {
				if (floor[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	private int findEmptyColumn(int row) {
		for(int j = 0; j < floor.length; j++) {
			if (floor[row][j] == 0) {
				return j;
			}
		}
		return floor.length;
	}
}
