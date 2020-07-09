package threesumproblem;

import java.util.Random;
import sorting.Mergesort;
import sorting.console;

public class ThreeSumProblem {
	
	private  static void generateRandomArray (int [] arr,int size) {
		Random rand=new Random();
		for (int i=0;i<size;i++) {
			arr[i]=2*rand.nextInt(size)-size;
		}
		console.log("random array");
		console.log(arr);
		 
	}
	public static int compare(int a,int b) {
		if(a<b)
			return -1;
		if(a==b) {
			return 0;
		
		}
		else {

			return 1;
		}
	}
	public static int find(int [] arr) {
		int [] aux =new int[arr.length];
		int num=0;
		Mergesort.sort(arr,arr.length-1,0,aux);
		console.log("sorted arary");
		console.log(arr);
		
		for(int i=0;i<arr.length-2;i++) {
			int j=i+1;
			int k=arr.length-1;
			while(j<k) {
				int res=compare(arr[i]+arr[j]+arr[k],0);
				if(res==0) {
					console.log("{"+arr[i]+","+arr[j]+","+arr[k]+"}");
					num++;
					k--;
				}
				else if(res==-1) {
					j++;
				}
				else{
					k--;
				}
			}
		}
		return num;
		
	}
	
	public static void main(String [] args) {
		int size=20;
		int []arr=new int [size];
		generateRandomArray(arr, size);
		int num=find(arr);
		console.log("the answer is "+num);
	}

}
