package LinkedList;
import java.util.Iterator;

import sorting.console;

public class LinkedList<Type> implements Iterable<Type>{
	
	Node first;
	
	public class CustomIterator implements Iterator<Type>{
		
		private Node currentIterator;
		//customIterator constructor
		CustomIterator(){
			currentIterator=first;
		}
		@Override
		public boolean hasNext() {
			if(currentIterator==null)return false;
			// TODO Auto-generated method stub
			return currentIterator!=null;
		}

		@Override
		public Type next() {
			// TODO Auto-generated method stub
			Type temp=currentIterator.data;
			currentIterator=currentIterator.next;
			return temp;
		}
		
	}
	
	public Iterator iterator() {
		return new CustomIterator();
	}
	
	LinkedList(){
		first=null;
	}
	
	public void add(Type dt) {
		Node newNode=new Node();
		newNode.data=dt;
		newNode.next=first;
		first=newNode;
	}

	public class Node{
		Type data;
		Node next;
	}

	//unit test client
	public static void main(String [] args) {
		console.log("test");
		LinkedList<String>l=new LinkedList<String>();
		l.add("str");
		l.add("str");
		l.add("str");
		l.add("str");
		l.add("str");
		for(String str:l) {
			console.log(str);
		}
	}
}
