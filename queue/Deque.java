package queue;

import java.util.Iterator;

import sorting.console;

public class Deque<Type> implements Iterable<Type> {
	int size;
	Node first;
	Node last;


    // construct an empty deque
    public Deque() {
    	size=0;
    	first=null;
    	last=null;
    	
    }

    // is the deque empty?
    public boolean isEmpty() {
    	return size==0;
    	
    }

    // return the number of items on the deque
    public int size() {
    	return size;
    	
    }

    // add the item to the front
    public void addFirst(Type item) {
    	
    	Node n=new Node();
    	n.data=item;
    	n.next=first;
    	n.previous=null;
    	
    	if(size==0) {
        	last=n;
        	first=n;
        	size++;
        	return;
        	
    	}
    	first.previous=n;
    	first=n;
    	size++;
    	
    }

    // add the item to the back
    public void addLast(Type item) {
    	
    	Node n=new Node();
    	n.data=item;
    	n.next=null;
    	n.previous=last;

    	if(size==0) {
    		first=n;  		
    		last=n;
    		size++;
    		return;
    		
    	}
    	last.next=n;
    	last=n;
    	size++;
    	
    }

    // remove and return the item from the front
    public Type removeFirst() {
    	
    	if(size<=1) {
    		console.log("size ==1");
    		Type temp=first.data;
    		last=null;
    		first=null;
    		size--;
    		return temp;
    		
    	}
    	
    	Node oldFirst=first;
    	first.next.previous=null;
    	first=first.next;
    	size--;
    	return oldFirst.data;
    	
    	
    }

    // remove and return the item from the back
    public Type removeLast() {
    	if(size<=1) {
    		Type temp=first.data;
    		last=null;
    		first=null;
    		size--;
    		return temp;
    		
    	}
    	Node oldLast=last;
    	last.previous.next=null;
    	last=last.previous;
    	size--;
    	return oldLast.data;
    	
    	
    }

    // return an iterator over items in order from front to back
    public Iterator <Type> iterator(){
    	return new DequeueIterator();
    }

    private class DequeueIterator implements Iterator<Type> {
    	private Node iterator;
    	DequeueIterator(){
    		iterator=first;
    	}
    	
    	
    	@Override
    	public boolean hasNext() {
    		return iterator!=null;
    	}

		@Override
		public Type next() {
//			console.log("next called as result iterator=iterator.next");
			Node it=iterator;
			iterator=iterator.next;
			return it.data;
		}
    	
    }
    
    private class Node{
    	Type data;
    	Node next;
    	Node previous;
    }
    
//test client
    public static void main(String [] args) {
    	
    	Deque<String> d=new Deque<String>();
    	String item1="cool";
    	String item2="cool1";
    	String item3="cool2";
    	d.addLast(item1);
    	d.addLast(item2);
    	d.addLast(item3);
    	d.addLast("ullu");
    	
    	console.log(d.removeFirst());
    	console.log(d.removeFirst());
    	console.log(d.removeLast());
    	console.log(d.removeLast());
    	d.addLast(item3);
    	d.addLast("ullu");
    	
    	for(String elm:d) {
    		console.log(elm);
    	}
    }

}