package utility;

public class Utils {
	
	public static void swap(int [] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static int compare(int a,int b) {
		if(a==b)return 0;
		if(a<b)return -1;
		else return 1;
	}
	

}
