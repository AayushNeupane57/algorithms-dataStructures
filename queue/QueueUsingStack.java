package queue;
import utility.console;
import stack.*;

public class QueueUsingStack <Type>{
	
	private Stack<Type> s1;
	private Stack<Type> s2;
	
	QueueUsingStack(){
		s1=new Stack<Type>();
		s2=new Stack<Type>();
		
	}
	
	//test client
	public  void enqueue( Type t) {
		s1.push(t);
		
	}
	public  Type dequeue() {
		if(isEmpty()) {
			console.log("queue is already empty");
			System.exit(0);
		}
		
		if(s2.isEmpty()) {
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
				
			}
			
		}
		return s2.pop();
		
		
	}
	public boolean isEmpty() {
		return s1.isEmpty()&&s2.isEmpty();
	}
	
	public static void main(String [] args) {
		QueueUsingStack<String> q=new QueueUsingStack<String>();
		q.enqueue("hello");
		q.enqueue("hello000");
		q.enqueue("hell111o");
		console.log(q.dequeue());
		console.log(q.dequeue());
		console.log(q.dequeue());
		console.log(q.dequeue());
	}

}
