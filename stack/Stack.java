package stack;

import java.util.Iterator;

import utility.*;

//this is linked in implementation of fundamental stack datastructures

public class Stack<Type> implements Iterable<Type> {
	Node first;
	
	private class Node {
		Type data;
		Node next;
		
	}
	public Stack(){
		first=null;
	}
	@Override
	public Iterator<Type> iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator();
	}
	public class CustomIterator implements Iterator<Type>{
	  	private Node iterator;
    	CustomIterator(){
    		iterator=first;
    	}
		
		@Override
		public boolean hasNext() {
			return iterator!=null;
		}

		@Override
		public Type next() {
			Node temp=iterator;
			iterator=iterator.next;
			return temp.data;
		}
		
	}
	
	
	public void push(Type str) {
		Node newNode=new Node();
		newNode.data=str;
		newNode.next=first;
		first =newNode;
		
	}
	
	public Type pop() {
			Node oldFirst=first;
			first=first.next;
			return oldFirst.data;

	}
	
	public boolean isEmpty() {
		return first==null;
	}
	//test client from Stack implementation
	public static void main(String[]args){
		
		Stack<String> test=new Stack<>();
		test.push("aayush is");
		test.push("aayush are");
		test.push("aayush am");
		test.push("aayush this");
		for (String str:test) {
			console.log(str);
		}
		
	}
}
