import java.util.ArrayList;
import java.util.Collections;
public class UnionFind {
	
	private ArrayList<Integer> elements;
	private ArrayList<Integer> size=new ArrayList<Integer>();
	
	//constructor
	UnionFind(int numberOfElements){
		this.elements=new ArrayList<Integer>(numberOfElements);
		for(int i=0;i<numberOfElements;i++) {
			elements.add(i,i);
		}

		//create size array and initialize each element to 0
		this.size=new ArrayList<Integer>(Collections.nCopies(numberOfElements, 0));
	}
	
	public void join(int a,int b) {
		//if not connected join
		if(!connected(a,b)) {
			console.log("join("+a+","+b +")");
			int rootOfA=root(a);
			int rootOfB=root(b);
			int sizeOfA=size.get(rootOfA);
			int sizeOfB=size.get(rootOfB);
			if(sizeOfA<sizeOfB) {
				elements.set(rootOfA,rootOfB);
				size.set(rootOfB,size.get(rootOfB)+1);
				return;
			}
			elements.set(rootOfB,rootOfA);
			size.set(rootOfA,size.get(rootOfA)+1);
				
		}
		
	}
	public boolean connected(int a,int b) {
		int rootOfA=root(a);
		int rootOfB=root(b);
		if(rootOfA==rootOfB) {
			return true;
		}
		return false;
	}
	
	public void showElements() {
		console.log("elements of array in union find");
		console.log(elements);
		
	}
	
	public int root(int a) {
		int i=a;
		while(elements.get(i)!=i) {
			i=elements.get(i);
		}
		return i;
	}
	
}
