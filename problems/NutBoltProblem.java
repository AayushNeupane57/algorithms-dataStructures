package problems;

import sorting.console;
import suffling.FisherYatesShuffle;
import utility.RandNumber;
import utility.Utils;

public class NutBoltProblem {

	public static void partition(int []nut,int [] bolt,int high,int low){
		
		if(high<=low)return;
		
		int i=low;
		int j=high;
		int pivot=nut[low];
		int pivotIndex=low;
		while(true){
			
			while(i<=high&&bolt[i]<=pivot) {
				if(bolt[i]==pivot) {
					pivotIndex=i;	
				}
				i++;
				
			}
			while(bolt[j]>pivot) {
				j--;
			}
			if(j<=i)break;
			if(i<j) {
				Utils.swap(bolt,i,j);
			}

		}
		Utils.swap(bolt,j,pivotIndex);
		pivotIndex=j;
		
		pivot=bolt[pivotIndex];
		i=low;
		j=high;
		pivotIndex=0;
		while(true){
			
			while(i<=high&&nut[i]<=pivot) {
				if(nut[i]==pivot) {
					pivotIndex=i;	
				}
				i++;
			}
			while(nut[j]>pivot) {
				j--;
			}
			if(j<=i)break;
			if(i<j) {
				Utils.swap(nut,i,j);
			}
		}
		Utils.swap(nut,j,pivotIndex);
		pivotIndex=j;
		
		partition(nut,bolt,pivotIndex,low);
		
		partition(nut,bolt,high,pivotIndex+1);
	}
	//test client
	public static void main(String [] args) {
		int size=100000000;
		
		int []nut= new int[size];
		int []bolt= new int[size];
		for(int i=0;i<size;i++) {
			nut[i]=i;
			bolt[i]=i;
		}
		FisherYatesShuffle.suffle(bolt);
		FisherYatesShuffle.suffle(nut);
		console.log("nut bolt problem started");
		partition(nut, bolt, size-1,0);
		console.log("done");
		

		
		//choose random nut and sort bolt using that nut and get the index of required bolt
	}
	
	
}
