package sorting;

public class Mergesort {
	
	
	public static void sort(int []arr){
		int high=arr.length-1;
		int low=0;
		int [] aux=new int[arr.length];
		sort(arr,high,low,aux);
	}
	private static void sort(int []arr,int high, int low,int []aux) {	
		int mid=(high+low)/2;

		//base case
		if(high<=low) {
			return;
		}
		//sort the left half
		sort(arr, mid, low,  aux);
		//sort the right half

		sort(arr, high ,mid+1 ,aux);
		//merge them
		merge(arr,aux,high,low,mid);

		
		
	}
	public static void merge(int []arr, int[]aux,int high,int low,int mid) {
		//copied array to aux array
		for(int i=low;i<=high;i++) {
			aux[i]=arr[i];
		}
		
		int i=low,j=mid+1;
		for(int k=low;k<=high;k++) {
			if(i>mid) {
					
				arr[k]=aux[j++];

				}
			else if(j>high) {
				arr[k]=aux[i++];
				
				}
			else if(aux[i]<aux[j]) {
				arr[k]=aux[i++];
			
			}
				
			else {
				arr[k]=aux[j++];

			}
			
		}

	}
	
}
