package sorting;
import utility.*;

public class SelectionSort {
	
	public static void sort(int []arr) {
		int N=arr.length-1;
		
		for(int i=0;i<=N;i++) {
			int minimum=Integer.MAX_VALUE;
			int minIndex=i;
			for(int j=i;j<=N;j++) {
				if(arr[j]<minimum) {
					minimum=arr[j];
					minIndex=j;
					
				}
			}
			swap(arr,i,minIndex);
		}
	}
	
	public static void swap(int [] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void main(String[] args) {
		int size=100000;
		int []arr=new int[size];
		RandNumber.generateRandomArray(arr, size);
		sort(arr);
		console.log("selection sorted array");

	}

}
