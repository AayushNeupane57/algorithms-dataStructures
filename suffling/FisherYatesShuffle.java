package suffling;

import utility.Utils;
import sorting.console;
import utility.RandNumber;

public class FisherYatesShuffle {
	
	public static void suffle(int []arr) {
		
		for(int i=0;i<arr.length;i++) {
			int index=RandNumber.generateRandomNumber(i+1);
			Utils.swap(arr,index,i);	
		}
		
	}
	
	//test client
	public static void main(String []args) {
		
		int [] arr= {1,2,3,4,5,6};
		suffle(arr);
		console.log(arr);
		
	}

}
