package binaryHeap;

import utility.console;

public class MinPriorityQueue<Type extends Comparable<Type>> {
	
	int currentIndex;
	public  Type []items;
	
	public MinPriorityQueue(){
		
		items=(Type[]) new Comparable[4];
		//we implement 1 based index because it makes it easy for calculation
		currentIndex=1;
	}

	//enqueue
	public void enqueue(Type x) {
		if(currentIndex==items.length) {
			
			//resize the array
			Type [] newCopy=(Type [])new Comparable [2*items.length];
			for (int i=1;i<currentIndex;i++) {
				newCopy[i]=items[i];
				
			}
			items=newCopy;
		}
		items[currentIndex]=x;
		swim(currentIndex);
		currentIndex++;
		
	}
	public Type min() {
		if(currentIndex==1) {
			throw new IndexOutOfBoundsException("no element in heap");
		}
		return items[1];
	}
	
	public Type removeMin() {
		if(currentIndex==1) {
			throw new IndexOutOfBoundsException("no element in heap");
		}
		if(currentIndex<=items.length/4) {
			//resize the array
			Type []newCopy=(Type [])new Comparable[items.length/2];
			for(int i=1;i<currentIndex;i++) {
				newCopy[i]=items[i];
			}
			items=newCopy;
		}
		Type min=items[1];
		swap(items,1,currentIndex-1);
		items[--currentIndex]=null;
		sink(1);
		return min;	
	}
	
	private void swim(int index) {

		
		while(index>1&&(items[index].compareTo(items[index/2])<0)) {
			
			swap(items, index, index/2);
			index=index/2;
		}
	}
	private void sink(int index) {
		//this if condition needs better solution
		if(index<=currentIndex/2&&2*index+1==currentIndex&&items[index].compareTo(items[2*index])>0) {
			swap(items,index,2*index);
			index=2*index;
		}
		while(index<currentIndex/2 && (items[index].compareTo(items[2*index])>0||items[index].compareTo(items[2*index+1])>0)) {
			int min =minIndexOf(items,2*index,2*index+1);
			swap(items,index,min);
			index=min;
		}
	}
	private int minIndexOf(Type [] items,int i,int j) {
		if(items[i].compareTo(items[j])<0) {
			return i;
		}
		else {
			return j;
		}
	}
	private void swap(Type[]arr,int i,int j) {
		Type temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public int size() {
		return currentIndex-1;
	}
	public void print() {
		for(int i=0;i<currentIndex;i++)System.out.println(items[i]);
	}
	
	//test client
	public static void main(String[] args) {
		MinPriorityQueue <String>bh=new MinPriorityQueue<>();
		bh.enqueue("kool");		
		bh.enqueue("dool");
		bh.enqueue("eool");
		bh.enqueue("cool");
		console.log(bh.removeMin());
		console.log(bh.removeMin());
		console.log(bh.removeMin());
		console.log(bh.removeMin());
		
		MinPriorityQueue <Integer>b=new MinPriorityQueue<>();
		b.enqueue(6);		
		b.enqueue(7);
		b.enqueue(8);
		console.log(b.removeMin());
		console.log(b.min());
	}

}

