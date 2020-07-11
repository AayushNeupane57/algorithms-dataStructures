package problems;
import utility.*;


public class IntersectionOfSets {
	
	private static int count;
	
	IntersectionOfSets() {
		//two count number of items common
		count =0;
	}
	
	public static void intersection(Point arr1[],Point arr2[]) {
		int i=0;
		int j=0;
		//complexity O(m+n)
		//if two array have same size then the big O notation is O(2N)
		while(i!=arr1.length &&j!=arr2.length) {
			Point p1=arr1[i];
			Point p2=arr2[j];
			if(Point.compare(p1, p2)==0) {
				count++;
				console.log("found intersection");
				console.log(p1);
				i++;
				j++;
			}
			else if(Point.compare(p1, p2)==-1) {
				i++;
			}
			else if(Point.compare(p1, p2)==1) {
				j++;
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
		
		//generates sorted points using insertion sort using insertion sort without duplicate
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
