package sorting;
import utility.RandNumber;
public class InsertionSort {
	
	public static void sort(int arr []){
		int n=arr.length-1;
		for(int i=1;i<=n;i++) {
			int j=i;
			while( j>0 &&(arr[j]<arr[j-1])  ) {
				swap(arr,j,j-1);

				j--;
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
		int size=10000000;
		int []arr=new int[size];
		RandNumber.generateRandomArray(arr, size,size);
		sort(arr);
		console.log("insertion sorted array");
		console.log(arr);
	}

}
