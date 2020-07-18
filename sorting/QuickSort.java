//three way quick sort best suited also for list with duplicate keys
package sorting;
import suffling.FisherYatesShuffle;
import utility.RandNumber;
import utility.Utils;

public class QuickSort {
	
	static int CUT_OFF=6;
		
	public static void sort(int []arr) {
		//my array is randomly generated so i dont think i need this suffle

//		FisherYatesShuffle.suffle(arr);
//		console.log("suffled arrat");
//		console.log(arr);
		sort(arr,arr.length-1,0);
	}
	private static void sort(int [] arr,int high,int low) {
		if(high<=low)return;
		if(high-low<=CUT_OFF) {
			for(int i=low+1;i<=high;i++) {
				int j=i;
				while( j>low &&(arr[j]<arr[j-1])  ) {
					Utils.swap(arr,j,j-1);
					j--;
				}
			}
			return;
		}

		int i=low+1;
		int gt=high;
		int lt=low;
		int pivot=arr[low];
		while(i<=gt) {
			if(arr[i]==pivot) {
				i++;
			}
			
			else if(arr[i]<pivot) {
				Utils.swap(arr,i,lt);
				i++;lt++;
			}
			
			else {
	
				Utils.swap(arr, i, gt);
				gt--;

			}

		}
		sort(arr,lt-1,low);
		sort(arr,high,gt+1);
	
	}
	//test client
	public static void main(String []args) {
		int size=10000000;
		int arr[]=new int[size];
		RandNumber.generateRandomArray(arr, size, size);
		console.log("random array generated");

		sort(arr);	
		console.log("sorted");

	}

}
