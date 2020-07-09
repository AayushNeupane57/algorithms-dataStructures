package utility;

import java.util.Random;

public class RandNumber {
	private  static void generateRandomArray (int [] arr,int size) {
		Random rand=new Random();
		for (int i=0;i<size;i++) {
			arr[i]=rand.nextInt(size-1);
		}
		console.log("random array");
		console.log(arr);
		 
	}

}
