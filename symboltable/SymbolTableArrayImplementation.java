package symboltable;

import java.util.Deque;

import edu.princeton.cs.algs4.Queue;
import sorting.console;

public class SymbolTableArrayImplementation<Key extends Comparable<Key>,Value> {
	Key[] keys;
	Value[] values;
	int currentIndex;
	
	public SymbolTableArrayImplementation() {
		// TODO Auto-generated constructor stub
		keys= (Key[])new Comparable[4];
		values= (Value[])new Comparable[4];
		currentIndex=0;
	}
	
	public void put(Key key,Value val) {
		if(currentIndex==keys.length) {
			Key[] newKeys= (Key[])new Comparable[2*currentIndex];
			Value[] newValues= (Value[])new Comparable[2*currentIndex];
			for(int i=0;i<currentIndex;i++) {
				newKeys[i]=keys[i];
				newValues[i]=values[i];
			}
			keys=newKeys;
			values=newValues;
		}
		keys[currentIndex]=key;
		values[currentIndex]=val;
		currentIndex++;
	}
	public Value get(Key key) {
		int index=-1;
		for(int i=0;i<currentIndex;i++) {
			if(keys[i]==key) {
				index=i;
				break;
			}
			
		}
		if(index==-1) {
			throw new IllegalArgumentException("no such key exists bro");
		}
		return values[index];
	}
	public boolean isEmpty() {
		return currentIndex==0;
	}
	public boolean contains(Key key)
	{
		for(int i=0;i<currentIndex;i++) {
			if(keys[i]==key) {
				return true;
			}
			
		}
		return false;
		
	}
	public void delete(Key key) {
		Key []newKeys=(Key[])new Comparable[currentIndex];
		Value []newValues=(Value[])new Comparable[currentIndex];
		int i=0;
		int keyIndex=getKeyIndex(key);
		while(i<currentIndex && i!=keyIndex ) {
			newKeys[i]=keys[i];
			newValues[i]=values[i];
			i++;	
		}
		keys=newKeys;
		values=newValues;
	}
	public Iterable<Key> keys(){
		Queue<Key>q =new Queue<Key>();
		for(int i=0;i<currentIndex;i++) {
			q.enqueue(keys[i]);
		}
		return q;
		
	}

	public int size() {
		return currentIndex;
	}
	private int getKeyIndex(Key key) {
		for(int i=0;i<currentIndex;i++) {
			if(keys[i]==key) {
				return i;
				
			}
			
		}
		return -1;
	}
	
	
	//test client
	public static void main(String [] args) {
		console.log("this si test client for sumbol table");
		SymbolTableArrayImplementation<String,Integer> st=new SymbolTableArrayImplementation<>();
		st.put("one", 1);
		st.put("two", 2);
		st.put("three", 3);
		for(String str:st.keys()) {
			console.log(st.get(str));
		}

	}
}
