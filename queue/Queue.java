package queue;
//this class contains Queue implementation using linkedList

import utility.console;

public class Queue <Type>{
	
	Node first;
	Node last;
	
	private class Node{
		Type data;
		Node next;
	}
	
	Queue(){
		first=null;
		last=null;
		
	}
	
	public void enqueue(Type str) {
		//this should add an item to the last of queue
		Node newNode=new Node();
		newNode.data=str;
		newNode.next=null;
		
		if(isEmpty()) {
			last=newNode;
			first=newNode;
			return;
		}
		else if((first==last)&&first!=null) {
			last=newNode;
			first.next=last;
			return;
		}
		last.next=newNode;
		last=newNode;
	}
	
	public Type dequeue() {
		//this should remove an item from the first of the queue
			Type temp=first.data;
			first=first.next;
			return temp;
		



		
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	
	public static void main(String []args) {
		

		
		Queue<Integer> test=new Queue<>();
		test.enqueue(1);
		test.enqueue(2);
		test.enqueue(3);
		test.enqueue(4);
		console.log(test.dequeue());
		console.log(test.dequeue());
		console.log(test.dequeue());
		console.log(test.dequeue());


	}

}
