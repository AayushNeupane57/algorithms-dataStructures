package sorting;
import sorting.console;
import utility.*;

public class ShellShort {
	
	public static void sort(int []arr){
		int N=arr.length;
		
		//first we find the largest number in our sequence for your particular number of input;
		int h=1;
		while(h<N/3) {
			h=3*h+1;
		}
		while(h>=1) {
			//we perform h-sort in descreasing order
			// for example if we have 25 element we forst perform 1-sort,4-sort,1-sort respectively.
			//this outer for loop run one value of h  and inner for liip will only move element foreward by swappinh
			//these two for loops below perform -h sort in which h value is controlled by outer while loop
			for(int i=h;i<N;i++) {
				for(int j=i;j>=h && arr[j]<arr[j-h];j-=h) {
					swap(arr,j,j-h);
				}
			}
			//integer division by 3 will help us get knuth sequence from higher term to lower term
			//for example if firsr is 40 then 40/3=13 is next and 13/3=4 is next and so on
			h=h/3;
		}
	
			
		
		
	}
	
	public static void swap(int []arr,int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}
	
	public static void main(String []args) {
		int size=100000000;
		int []arr=new int[size];
		RandNumber.generateRandomArray(arr, size);
		sort(arr);
		console.log(" shellsorted array");
//		console.log(arr);
		
	}

}
