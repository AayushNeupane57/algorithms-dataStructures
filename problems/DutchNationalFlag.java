package problems;


import utility.*;

public class DutchNationalFlag {
	
	
	public static void sort(int []arr) {
		int high=arr.length-1;
		int low=0;
		int movingPointer=0;
		
		while(movingPointer<=high) {
			if(arr[movingPointer]==0) {
				swap(arr,movingPointer,low);
				low++;
				movingPointer++;
			}
			else if(arr[movingPointer]==2) {
				swap(arr,movingPointer,high);
				high--;
			}
			else {
				movingPointer++;
			}
		}
	}
	private static void swap(int [] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	//test client
	public static void main(String [] args) {
		int size=10;
		int lessthan=3;
		int []arr=new int[size];
		console.log("before sorthing")
		;
		RandNumber.generateRandomArray(arr, size,lessthan);
		console.log(arr);
		sort(arr);
		console.log("after sorting");
		console.log(arr);
		console.log("dutch national flag implementing");
	}

}
