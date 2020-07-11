package problems;
import sorting.Mergesort;
import utility.*;
//given two sets this program checks whether one of the set is permutation of other or not


public class Permutaion {
	
	public static boolean check(int []arr1,int []arr2) {
		Mergesort.sort(arr1);
		Mergesort.sort(arr2);
		int index=0;
		for(int elm:arr1) {
			if(arr2[index++]!=elm) {
				return false;
			}
		}
		return true;
	}
	//test client
	public static void main(String [] args) {
		console.log("permutation problem started");
		int []arr1= {1,3,3,4};
		int []arr2= {1,2,3,4};
		
		if(check(arr1, arr2)) {
			console.log("same");
		}
		else {
			console.log("not same");
		}
	}

}
