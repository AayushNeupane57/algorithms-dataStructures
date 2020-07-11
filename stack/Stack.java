package stack;

import utility.*;

//this is linked in implementation of fundamental stack datastructures

public class Stack<Type> {
	Node first;
	
	private class Node {
		Type data;
		Node next;
		
	}
	public Stack(){
		first=null;
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
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		
	}
}
