package cs1;

public class Main {

	public static void main(String[] args) {
		int[] to_sort = {23, 12, 90, 124, 1, 1908, 12, 1, 2, 3, 90, 234};
		int[] sorted = SortingAlgorithms.selectionSort(to_sort);
		for(int i = 0; i < to_sort.length; i++) {
			System.out.println(sorted[i]);
		}

	}

}
