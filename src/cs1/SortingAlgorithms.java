package cs1;

public class SortingAlgorithms {
	
	private int[] to_sort;
	
	public SortingAlgorithms(int[] to_sort) {
		this.to_sort = to_sort;
	}
	
	public int[] bubbleSort() {
		return bubbleSort(to_sort);
	}
	
	public int[] selectionSort() {
		return selectionSort(to_sort);
	}
	
	public static int[] bubbleSort(int[] to_sort) {
		boolean ordered;
		do {
			ordered = true;
			for(int i = 1; i < to_sort.length; i++) {
				if(to_sort[i-1] > to_sort[i]) {
					ordered = false;
				
					to_sort = swap(to_sort, i-1, i);
				}			
			}
		} while (ordered == false);
		return to_sort;
	}
	
	public static int[] selectionSort(int[] to_sort) {
		int left = 0;
		while(left < to_sort.length - 1) {
			int ind_min = left;
			for(int i = left + 1; i < to_sort.length; i++) {
				if(to_sort[i] < to_sort[ind_min]) {
					ind_min = i;
				}
			}
			to_sort = swap(to_sort, left, ind_min);
			left++;
		}
		return to_sort;
	}
	
	public static int[] swap(int[] a, int i1, int i2) {
		int aux = a[i1];
		a[i1] = a[i2];
		a[i2] = aux;
		
		return a;
	}
}
