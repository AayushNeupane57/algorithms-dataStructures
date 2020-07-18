package problems;

import sorting.console;
import utility.RandNumber;
import utility.Utils;

public class DecimalDominant {
	public static int partition(int []arr,int high,int low,int k) {
		
		if(high<=low) {
			return low;
		}
		int pivot =arr[low];
		int i=low+1;
		int j=high;
		
		while(true){
			
			while(i<=high&&arr[i]>=pivot) {
				i++;
			}
			while(arr[j]<pivot) {
				j--;
			}
			if(j<=i)break;
			if(i<j) {
				Utils.swap(arr,i,j);
			}
		}
		Utils.swap(arr,j,low);
		if(j==k) {
			return j;
		}
		else if(j<k) {
			return partition(arr,high,j+1,k);
		}
		else {
			return partition(arr,j-1,low,k);
		}
	}
	
	public static int quickSelect(int []arr,int k) {
		int high=arr.length-1;
		int low=0;
		int index=partition(arr,high,low,k);
		return arr[index];
		}

	public static void find(int[] arr,int k) {
		//given an array use quick select to find kth largest element
		//
		int forLoopCount=0;
		int n=arr.length;
		int count=0;
		for(int i=n/k-1;i<=arr.length-1;i+=n/k) {
			//i assume that quick select search based on descending order
			forLoopCount++;
			int elm=quickSelect(arr,i);
			for(int j=0;j<arr.length;j++) {
				if(arr[j]==elm){
					count++;
				}
			}
			if(count>=k) {
				console.log(arr[i]+" occured more than  or ewual to"+k+" times");
			}
			count=0;
		}
		console.log("forloopcount= "+forLoopCount);;
	}
	//test client
	public static void main(String []args) {
		console.log("decimal dominant started");
		int size=1000000;
		int []arr=new int[size];
		RandNumber.generateRandomArray(arr, size, size/8);
		find(arr,10);
	}
}
