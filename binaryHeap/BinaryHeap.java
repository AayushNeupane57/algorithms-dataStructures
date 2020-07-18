package binaryHeap;

import utility.console;

public class BinaryHeap<Type extends Comparable<Type>> {
	
	int currentIndex;
	public  Type []items;
	
	BinaryHeap(){
		
		items=(Type[]) new Comparable[4];
		//we implement 1 based index because it makes it easy for calculation
		currentIndex=1;
	}

	//insert
	public void insert(Type x) {
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
	public Type max() {
		if(currentIndex==1) {
			throw new IndexOutOfBoundsException("no element in heap");
		}
		return items[1];
	}
	
	public Type removeMax() {
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
		Type max=items[1];
		swap(items,1,currentIndex-1);
		items[--currentIndex]=null;
		sink(1);
		return max;	
	}
	
	private void swim(int index) {

		
		while(index>1&&(items[index].compareTo(items[index/2])>0)) {
			
			swap(items, index, index/2);
			index=index/2;
		}
	}
	private void sink(int index) {
		while(index<currentIndex/2 && (items[index].compareTo(items[2*index])<0||items[index].compareTo(items[2*index+1])<0)) {
			int max =maxIndexOf(items,2*index,2*index+1);
			swap(items,index,max);
			index=max;
		}
	}
	private int maxIndexOf(Type [] items,int i,int j) {
		if(items[i].compareTo(items[j])==1) {
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
	
	//test client
	public static void main(String[] args) {
		console.log(" i started binary heap");
		BinaryHeap <String>bh=new BinaryHeap<>();
		bh.insert("cool");
		console.log(bh.items);
		bh.insert("dool");
		console.log(bh.items);
		bh.insert("kool");
		console.log(bh.items);
		bh.insert("eool");
		console.log(bh.items);
		console.log(bh.removeMax());
		console.log(bh.removeMax());
		console.log(bh.removeMax());
		console.log(bh.removeMax());
		console.log(bh.items);
	}

}
