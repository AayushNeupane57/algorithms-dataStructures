package searching;
import utility.*;
import sorting.Mergesort;

public class BinarySearch {
	
	//this function search integer array in logN time and return the index of first occurence
	public static int search(int[] arr,int key) {
		
		int high=arr.length-1;
		int low=0;
		return search(arr,key,high,low);
		
	}
	private static int search(int []arr ,int key,int high,int low) {
		int mid=(high+low)/2;
		if(arr[mid]==key) {
			return mid;
		}
		if(high<=low) {
			return -1;
		}
		if(key<arr[mid]) {
			return search(arr,key,mid,low);
			
		}
		
		return search(arr,key,high,mid+1);
	}
	
	public static void main(String[] args) {
		int []arr= {1,3,4,9,2,6,8,-5,-3,55,-43,5};
		
		int high=arr.length-1;
		int low=0;
		int [] aux=new int [arr.length];
		Mergesort.sort(arr, high, low, aux);
		console.log("sortedArray");
		console.log(arr);
		
		int index =search(arr, 55);
		console.log("found at index"+index);
	}

}
