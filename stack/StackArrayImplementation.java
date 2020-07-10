package stack;

import utility.console;

public class StackArrayImplementation {

	public String []items;
	int currentIndex;
	public StackArrayImplementation() {
		items=new String [1];
		currentIndex=0;
	}
	
	public void push(String str) {
		int currentSize=items.length;
		
		if(currentIndex>=currentSize); {
			String []copy=new String [2*currentSize];
			for(int i=0;i<currentIndex;i++) {
				copy[i]=items[i];
			}
			items=copy;
		}
		items[currentIndex]=str;
		currentIndex++;
		
		
	}
	
	public String pop() {
		if(!isEmpty()) {
			String temp=items[currentIndex-1];
			int currentSize=items.length;
			if(currentIndex<=currentSize/4) {
				String []copy=new String [currentSize/2];
				for(int i=0;i<currentIndex;i++) {
					copy[i]=items[i];
				}
				items=copy;
			}
			
			items[currentIndex]=null;
			currentIndex--;
			return temp;
		}
		else
			return "stack is empty already";
	}
	
	public boolean isEmpty(){
		return currentIndex-1<0;
	}
	
	//test client for stack resizing array implementation
	public static void main(String[]args) {
		console.log("array implementation started");
		StackArrayImplementation test=new StackArrayImplementation();
		test.push("choice");
		test.push("still a");
		test.push("is");
		test.push("to choose");
		test.push("not");
		test.push("choosing");
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.pop());
		console.log(test.isEmpty());

//		console.log(test.pop());
		
	}
}
