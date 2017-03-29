package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	private String filename;
	
	public FileReader() {};
	
	public FileReader(String filename) {
		this.filename = filename;
	}
	
	public int[] readIntArray() throws FileNotFoundException {
		Scanner read = new Scanner(new File(filename));
		int l = read.nextInt();
		int[] a = new int[l];
		for(int i = 0; i < l; i++) {
			a[i] = read.nextInt();
		}
		read.close();
		return a;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
