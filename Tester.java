import java.util.Random;
import java.util.ArrayList;
public class Tester {
	
	public static void main(String []args) {
		int sizeOfArray=10;
		ArrayList<Integer> arr=new ArrayList<Integer>(sizeOfArray);
		generateRandomArray(arr,sizeOfArray);
		
		UnionFind uf=new UnionFind(sizeOfArray);
		
		for(int i=0;i<arr.size() ;i=i+2) {
			int a=arr.get(i);
			int b=arr.get(i+1);
			uf.join(a, b);
		}
		uf.showElements();
		checkConnected(uf, sizeOfArray);
		
	
	}
	
	private  static void generateRandomArray (ArrayList <Integer>arr,int size) {
		console.log(size);
		Random rand=new Random();
		console.log("random number generated");
		for (int i=0;i<size;i++) {
			arr.add(i,rand.nextInt(size-1));
		}
		console.log("random array");
		
		console.log(arr);
		 
	}
	
	private static void checkConnected(UnionFind uf,int size) {
		ArrayList<Integer> list=new ArrayList<Integer>(size);
		generateRandomArray(list, size);
		for(int i=0;i<list.size() ;i=i+2) {
			int a=list.get(i);
			int b=list.get(i+1);
			if(uf.connected(a, b)) {
				console.log("connected("+a+","+b+")=true");
				
			}
			else {
				console.log("connected("+a+","+b+")=false");
			}
		}
		
		
	}
	
}
