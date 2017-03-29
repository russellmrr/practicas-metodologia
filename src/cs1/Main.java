package cs1;

import java.io.FileNotFoundException;

import utils.FileReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {

	public static final int RANDOM_OPT_SIZE = 100;
	public static final int RANDOM_MAXVALUE = 1000;
	public static final int[] AP2_SIZES = {100, 500, 1000, 5000, 8000, 9000,
		10000, 11000, 20000, 50000};

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("¿Apartado 1 o 2?");
		int ap = s.nextInt();
		if(ap==1) {
			ap1();
		} else if(ap==2) {
			ap2();
		}
	}
	
	public static int[] randomArray(int size) {
		int[] a = new int[size];
		int max = 1000000;
		Random r = new Random();
		r.setSeed(System.nanoTime());
		for(int i=0; i < size; i++) {
			a[i] = r.nextInt(RANDOM_MAXVALUE);
		}
		return a;
	}

	public static void sortAndPrintArray(int[] a) {
		System.out.println("Original array: ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		SortingAlgorithms sa = new SortingAlgorithms(a);
		SortingAlgorithms sb = new SortingAlgorithms(a);
		int[] s1 = sa.bubbleSort();
		int[] s2 = sa.selectionSort();
		System.out.println("\nSorted array (bubbleSort): ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(s1[i] + ", ");
		}
		System.out.println("\nSorted array (selectionSort): ");
		for(int i = 0; i < a.length; i++) {
			System.out.print(s2[i] + ", ");
		}
	}
	
	public static void ap1() {
		int[] a; // Array to sort		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("--- Case Study 1 --- \n" +
				" 1 - Read data from keyboard \n" +
				" 2 - Generate random values \n" +
				" 3 - Read data from file \n\n" +
				"  Select option: ");
		int opt = sc.nextInt();
		switch(opt) {
		case 1:
			System.out.println("Enter size: ");
			int size = sc.nextInt();
			a = new int[size];
			System.out.println("Enter values: ");
			for(int i = 0; i < size; i++) {
				a[i] = sc.nextInt();
			}
			sortAndPrintArray(a);
			break;
		case 2:
			System.out.println("Generating a random array of size " + 
					RANDOM_OPT_SIZE);
			a = randomArray(RANDOM_OPT_SIZE);
			sortAndPrintArray(a);
			break;
		case 3:
			boolean goOn = true;
			FileReader fr = new FileReader();
			System.out.println("Enter file name: ");
			do {
				fr.setFilename(sc.next());
				try {
					a = fr.readIntArray();
					sortAndPrintArray(a);
				} catch(FileNotFoundException e) {
					System.out.println("File name incorrect. Try again: ");
				}
			} while (goOn == true);
			break;
		default:
			break;
		}
	}
	
	public static void ap2() {
		float time_start;
		float time_end;
		int[] to_sort;
		
		for(int i=0; i < AP2_SIZES.length; i++) {
			System.out.print("\nSize = " + AP2_SIZES[i]);
			to_sort = randomArray(AP2_SIZES[i]);
			
			time_start = System.nanoTime();
			SortingAlgorithms.bubbleSort(to_sort);
			time_end = System.nanoTime() - time_start;
			System.out.print(", time bubbleSort = " + time_end);
			
			time_start = System.nanoTime();
			SortingAlgorithms.selectionSort(to_sort);
			time_end = System.nanoTime() - time_start;
			System.out.print(", time selectionSort = " + time_end);
		}

	}
}
