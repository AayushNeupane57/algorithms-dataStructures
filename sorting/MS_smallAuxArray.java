package sorting;

import utility.RandNumber;

public class MS_smallAuxArray {
	
	public static void merge(int []arr,int low,int mid,int high,int[] aux) {
		
		if(arr[mid]<arr[mid+1])return;
		int auxIndex=low;
		int midIndex=mid+1;
		int currentIndex=low;
		for(int m=low;m<=mid;m++) {
			aux[m]=arr[m];
		}
		while(currentIndex<=high) {
			if(auxIndex>mid)return;
			if(midIndex>high) {
				arr[currentIndex]=aux[auxIndex];
				currentIndex++;
				auxIndex++;
			}
			else if(aux[auxIndex]<=arr[midIndex]) {
				arr[currentIndex++]=aux[auxIndex++];
			}
			else if(aux[auxIndex]>arr[midIndex]) {
				arr[currentIndex++]=arr[midIndex++];
			}
		}
	}
	
	//test client
	public static void main(String []args) {
		int size=10000;
		int []arr1= new int[size];
		int []arr2= new int[size];
		RandNumber.generateRandomArray(arr1, size,5*size);
		RandNumber.generateRandomArray(arr2, size,5*size);
		QuickSort.sort(arr1);
		QuickSort.sort(arr2);

		int[] arr3=new int[2*size];
		for(int i=0;i<2*size;i++) {
			if(i<size)arr3[i]=arr1[i];
			else {
				arr3[i]=arr2[i-size];
			}
		}
		int []aux =new int[size];
		console.log("started");
		merge(arr3,0,size-1,2*size-1,aux);
		console.log("sorted");

		
	}

}
