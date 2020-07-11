package problems;
import utility.*;


public class IntersectionOfSets {
	
	private static int count;
	
	IntersectionOfSets() {
		//two count number of items common
		count =0;
	}
	
	public static void intersection(Point arr1[],Point arr2[]) {
		for(Point elm:arr1) {
			if(Point.search(arr2,elm)!=-1) {
				count++;
				console.log("found common element");
				console.log(elm);
			}
			
		}
	}
	
	//test client
	public static void main(String[]args) {
		int size=10;
		int lessthan=5;
		Point [] arr1=new Point[size];
		Point [] arr2=new Point[size];
		console.log("unsorted array");
		//this function also generates duplicate points that needs to be fixed
		RandNumber.generate2dPointsArraySorted(arr1, size, lessthan);
		RandNumber.generate2dPointsArraySorted(arr2, size, lessthan);
		console.log("sorted array");
		
		console.log(arr1);
		console.log(arr2);
		intersection(arr1, arr2);
		console.log("element common in both array are");
		console.log(count);
	}

}
