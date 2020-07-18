package binaryHeap;

import sorting.console;
import utility.RandNumber;

public class HeapSort {
	static BinaryHeap<Integer>bh;
	
	public static void sort(int arr[]) {
		bh=new BinaryHeap<Integer>();
		for(int i=0;i<arr.length;i++) {
			bh.insert(arr[i]);
		}
		for(int i=0;i<arr.length;i++) {
			arr[i]=bh.removeMax();
		}
	}

	//testClient
	public static void main(String []args) {
		int size=100;
		int [] arr=new int[size];
		RandNumber.generateRandomArray(arr, size, 5*size);
		console.log("started");
		sort(arr);
		
		console.log("sorted");
		console.log(arr);
	}
}
