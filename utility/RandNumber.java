package utility;

import java.util.Random;
import java.util.Set;

public class RandNumber {
	public static int  generateRandomNumber(int lessthan) {
		Random rand=new Random();
		return rand.nextInt(lessthan);
		
	}
	
	public  static void generateRandomArray (int [] arr,int size ,int lessthan) {
		Random rand=new Random();
		for (int i=0;i<size;i++) {
			arr[i]=rand.nextInt(lessthan);
		}
	}
	
	//generates 2d pointes not sorted random and with duplicates
	public  static void generate2dPointsArray (Point [] arr,int size ,int lessthan) {
		Random rand=new Random();
		for (int i=0;i<size;i++) {
			Point p=new Point();
			p.x=rand.nextInt(lessthan);
			p.y=rand.nextInt(lessthan);
			arr[i]=p;
		}
	}
	
	//generates sorted random array without duplicates
	//uses insertion sort
	public  static void generate2dPointsArraySorted (Point [] arr,int size ,int lessthan) {
		Random rand=new Random();
		Point p=new Point();
		p.x=rand.nextInt(lessthan);
		p.y=rand.nextInt(lessthan);
		arr[0]=p;
		int n=size;
		int currentIndex=1;
		while(currentIndex<n){
			Point p1=new Point();
			p1.x=rand.nextInt(lessthan);
			p1.y=rand.nextInt(lessthan);			
			if(Point.search(arr, p1,currentIndex)==-1) {
				int j=currentIndex;
				arr[j]=p1;
				while(j>0 &&(arr[j].x<arr[j-1].x)  ) {
						swap(arr,j,j-1);				
						j--;
						
					}
				while(j>0 &&(arr[j].x==arr[j-1].x) && arr[j].y<=arr[j-1].y) {
						swap(arr,j,j-1);
						j--;
					}
				currentIndex++;
			}
			
		}			 
	}
	private static void swap(Point  [] arr,int i,int j) {
		Point temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
