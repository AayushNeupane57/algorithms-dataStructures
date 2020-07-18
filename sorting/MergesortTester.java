package sorting;

import java.util.ArrayList;
import java.util.Random;

public class MergesortTester {
	
	private  static void generateRandomArray (int [] arr,int size) {
		Random rand=new Random();
		for (int i=0;i<size;i++) {
			arr[i]=rand.nextInt(size-1);
		}
		console.log("random array");
//		console.log(arr);
		 
	}
	
	public static void main(String [] args) {
		
		int numberOfItems=10000000;
		int []arr=new int[numberOfItems];
		generateRandomArray (arr, numberOfItems);
		Mergesort.sort(arr);
		console.log("sorted ");
//		console.log(arr);
		
		
	}

}
