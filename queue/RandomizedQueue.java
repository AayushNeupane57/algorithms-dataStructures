package queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import sorting.console;

public class RandomizedQueue<Type> implements Iterable<Type>{
	
	private Type [] items;
	private int size;
	
	RandomizedQueue(){
		//generally we have always array larger then the number of items in our queue
		//so size denotes an any instant how many objects are on the queue
		items =(Type[])new Object[2];
		size=0;
	}

	@Override
	public Iterator<Type> iterator() {
		return new RandomizedQueueIterator();
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(Type item) {
		//when queue is full make the queue double
		if(items.length==size) {
			//
			
			Type []tempItems=(Type[]) new Object[2*size];
			for(int i=0;i<size;i++) {
				tempItems[i]=items[i];
			}
			items=tempItems;
		}
		
		items[size++]=item;
		
	}
	
	public Type dequeue() {
		if(size==0) {
			console.log("queue is already empty");
			System.exit(0);
			
		}
		
		if(size<=items.length/4) {
			console.log(items.length);
			Type [] newItems=(Type[]) new Object[items.length/2];
			for(int i=0;i<size;i++) {
				newItems[i]=items[i];
			}
			items=newItems;
		}
		
		Random rand=new Random();
		int index=rand.nextInt(size);
		Type temp=items[index];
		
		items[index]=items[size-1];
		items[size-1]=null;
		size--;
		return temp;
		
		
		}
	
	public class RandomizedQueueIterator implements Iterator<Type>{
		
		int tempSize;
		Type [] tempItems;

		RandomizedQueueIterator(){
			tempSize=size;
			tempItems=(Type[]) new Object[tempSize];
			for(int i=0;i<size;i++) {
				tempItems[i]=items[i];
			}
			
			
		}
		
		@Override
		public boolean hasNext() {
			return tempSize!=0;
		}

		@Override
		public Type next() {
			//generate random number
			//return items at that index
			//fill that place by last item in the queue
			//make the last item null
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
				Random rand=new Random();
				int index=rand.nextInt(tempSize);
				Type temp=tempItems[index];
				tempItems[index]=tempItems[tempSize-1];
				tempItems[tempSize-1]=null;
				tempSize--;
				return temp;
		}
		
	}
	//test client
	public static void main(String []args) {
		RandomizedQueue<Integer> r= new RandomizedQueue<Integer>();
		r.enqueue(5);
		r.enqueue(2);
		r.enqueue(23);
		r.enqueue(6);
		r.enqueue(57);
		r.enqueue(54);
		console.log(r.dequeue());
		console.log(r.dequeue());
		console.log(r.dequeue());
		console.log(r.dequeue());
		console.log(r.dequeue());
		console.log(r.dequeue());
		console.log(r.dequeue());

		

	}
	
}