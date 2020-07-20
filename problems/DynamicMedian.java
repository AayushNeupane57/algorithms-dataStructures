package problems;
import utility.console;
import binaryHeap.MaxPriorityQueue;
import binaryHeap.MinPriorityQueue;
public class DynamicMedian {
	MaxPriorityQueue<Integer> maxPq;
	MinPriorityQueue<Integer> minPq;

	public DynamicMedian() {
			minPq=new MinPriorityQueue<Integer>();
			maxPq=new MaxPriorityQueue<Integer>();
	}
	//insert
	public void insert(Integer n) {
		if(minPq.size()>0&&maxPq.size()>0) {
			console.log("minpq.min"+minPq.min());
			console.log("maxpq.max"+maxPq.max());
		}
		console.log("n= "+n);
		if(median()==null) {
			console.log("in max heap initial effect");
			maxPq.enqueue(n);
			return;
		}


		if(n<median()) {
			console.log("in maax");
			maxPq.enqueue(n);
			
		}
		else if(n>=median()) {
			console.log("in min");
			minPq.enqueue(n);
		}
		if(minPq.size()-maxPq.size()>1) {
			console.log("in max due to size");
			minPq.print();
			maxPq.enqueue(minPq.removeMin());
			minPq.print();
			return;
		}
		if(maxPq.size()-minPq.size()>1) {
			console.log("in min due to size");
			minPq.enqueue(maxPq.removeMax());
			return;
		}
	}
	public Integer median() {
		int minPqSize=minPq.size();
		int maxPqSize=maxPq.size();
		
		if(minPqSize==0 && maxPqSize==0) {
			console.log("both size zoeo");
			return null;
			
		}
		
		if(minPqSize==0) {
			return maxPq.max();
		}
		if(maxPqSize==0) {
			return minPq.min();
		}
		
		if(minPq.size()>maxPq.size()) {
			return minPq.min();
		}
		else{

			return maxPq.max();
		}
	}
	
	//test client
	public static void main(String [] args) {
		console.log("Dynamic median started");
		DynamicMedian d=new DynamicMedian();
		
		
		d.insert(12);
		d.insert(5);
		d.insert(6);
		d.insert(7);
		d.insert(8);
		d.insert(9);
		d.insert(14);
		d.insert(15);
		d.insert(3);
		
		console.log(d.median());
	}
}




