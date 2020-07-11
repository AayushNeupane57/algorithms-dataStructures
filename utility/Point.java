package utility;

public class Point{
	public int x;
	public int y;
	
	public static int compare(Point p1,Point p2) {
		if(p1.x<p2.x) {
			return -1;
		}
		if(p1.x>p2.x) {
			return 1;
		}
		
		if(p1.y==p2.y) {
			return 0;
		}
		
		if(p1.y<p2.y) {
			return -1;
		}
		else if(p1.y>p2.y) {
			return 1;
		}
		else {
			console.log("no condition matche din point compare");
			System.exit(0);
			return -5;
		}
	}
	public static int search(Point []arr,Point key) {
		int low=0;
		int high=arr.length-1;
		return search(arr,key,high,low);
		
	}
	public static int search(Point []arr,Point key,int hi) {
		int low=0;
		int high=hi-1;
		return search(arr,key,high,low);
		
	}
	private static int search(Point []arr ,Point key,int high,int low) {
		int mid=(high+low)/2;
		if(Point.compare(arr[mid], key)==0) {
			return mid;
		}
		if(high<=low) {
			return -1;
		}
		if(Point.compare(key, arr[mid])==-1) {
			return search(arr,key,mid,low);
			
		}
		
		return search(arr,key,high,mid+1);
	}
	
	public static void main(String []args) {
		//testing if compare is working corretly
		Point p1=new Point();
		Point p2=new Point();
		p1.x=2;
		p1.y=1;
		p2.x=2;
		p2.y=0;
		console.log(compare(p1,p2));
	}
	
}
