package BST;

import sorting.console;
import queue.Queue;

public class SymbolTable<Key extends Comparable<Key>,Value> {

	
	public Node root;
	static final int COUNT = 10;
	
	private class Node{
		Key key;
		Value value;
		Node left;
		Node right;
		int subTreeSize;
		
		Node(Key k,Value val){
			key=k;
			value=val;
			left=null;
			right=null;
			subTreeSize=1;
		}
	}
	public Iterable<Key> keys(){
		Queue<Key>q=new Queue<Key>();
		inOrderTraversal(root,q);
		return q;
	}
	public void inOrderTraversal(Node x,Queue<Key> q) {
		//when any nod has left node equal to null.it is minimum in that sub tree
		if(x==null)return; //return makes one stack up in recursion
		inOrderTraversal(x.left, q);
		q.enqueue(x.key);
		inOrderTraversal(x.right, q);
		//after this line one stack up in the recursion
	}
	
	public SymbolTable() {
		// TODO Auto-generated constructor stub
		root =null;
	}
	
	public void put(Key key,Value val) {
		root =put(root,key,val);
	}

	private Node put(Node x,Key key,Value val) {
		
		//only when given key is not present already new node is created
		if(x==null) {
			 Node newNode =new Node(key,val);
			return newNode;
		}
		
		//otherwise same node is returned 
		int cmp=key.compareTo(x.key);
		if(cmp==0) {
			x.value=val;
			
		}
		else if(cmp<0) {
			x.left=put(x.left,key,val);
		}
		else {
			x.right=put(x.right,key,val);
		}
		
		x.subTreeSize=1+size(x.left)+size(x.right);
		return x;
		
	}
	public Value get(Key key) {
		Node x=root;
		while(x!=null) {
		
			int cmp=key.compareTo(x.key);
			if(cmp==0) {
				return x.value;
			}
			else if(cmp<0) {
				x=x.left;
			}
			else {
				x=x.right;

			}
		}
		return null;
	}
	
	public Value min() {
		Node x=root;
		while(x.left!=null) {
			x=x.left;
		}
		return x.value;
	}
	private Node getMinNode(Node n) {
		Node x=n;
		while(x.left!=null) {
			x=x.left;
		}
		return x;
	}
	
	public Value max() {
		Node x=root;
		while(x.right!=null) {
			x=x.right;
		}
		return x.value;
	}
	
	public Value floor(Key key) {
		Node x= floor(root,key);
		return x.value;
		
		
	}
	private Node floor(Node x,Key key) {
		if(x==null)return null;
		int cmp=key.compareTo(x.key);
		
		if(cmp==0) {
			return x;
		}
		else if(cmp<0) {
			return floor(x.left,key);
		}
		else {
			Node t=floor(x.right,key);
			if(t!=null) {
				return t;
			}
			else {
				return x;
			}
		}
	}
	
	public Value ceiling(Key key) {
		Node x=ceiling(root,key);
		return x.value;
	}
	private Node ceiling(Node x,Key key) {
		if(x==null)return null;
		int cmp=key.compareTo(x.key);
		
		if(cmp==0) {
			return x;
		}
		else if(cmp>0) {
			return ceiling(x.right,key);
		}
		else {
			Node t=ceiling(x.left,key);
			if(t!=null) {
				return t;
			}
			else {
				return x;
			}
		}
	}
	

	
	public void print2DUtil(Node root, int space)  
	{  
	    // Base case  
	    if (root == null) {
	    	
	    	return; 
	    }
	         
	  
	    // Increase distance between levels  
	    space += COUNT;  
	  
	    // Process right child first  
	    print2DUtil(root.right, space);  
	  
	    // Print current node after space  
	    // count  
	    System.out.print("\n");  
	    for (int i = COUNT; i < space; i++)  
	        System.out.print(" ");  
	    System.out.print(root.key + "\n");  
	  
	    // Process left child  
	    print2DUtil(root.left, space);  
	}  
	  
	// Wrapper over print2DUtil()  
	public void print()  
	{  
		console.log("----------------------------------------------------------------------------------------");
	    // Pass initial space count as 0  
	    print2DUtil(root, 0);  
		console.log("-------------------------------------------------------------------------------------------");
	}
	private int size(Node x) {
		if(x==null) {
			return 0;
		}
		return x.subTreeSize;
	}
	//returns number of key less than given key
	public int rank(Key key) {
		return rank(root,key);
	}
	private int rank(Node x,Key key) {
		if(x==null)return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0) {
			return rank(x.left,key);
		}
		else if(cmp>0) {
			return 1+size(x.left)+rank(x.right,key);
		}
		else {
			return size(x.left);
		}
	}
	
	//now i have to do deletion in the binary search tree
	//first i should implement deleteMin and deleteMax;
	// i should be able to delete any
	
	public void deleteMin() {
		root=deleteMin(root);
	}
	public Node deleteMin(Node x) {
		//reference varaible to which refrence id detachhed is automatically removed by garbage collector


		if(x.left==null) {
			return x.right;
		}
		x.left=deleteMin(x.left);
		return x;
		
	}
	public void deleteMax() {
		root=deleteMax(root);
	}
	private Node deleteMax(Node x) {
		//reference varaible to which refrence id detachhed is automatically removed by garbage collector
		if(x.right==null) {
			return x.left;
		}
		x.right=deleteMax(x.right);
		return x;
		
	}
	
	public void delete(Key key) {
		root=delete(root,key);


		
	}
	private Node delete(Node x,Key key) {
		if (x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) {
			
			x.left=delete(x.left,key);
		}
		else if(cmp>0) {
			x.right=delete(x.right,key);
		}
		else {

			if(x.right==null) {
			
				return x.left;
			}
			if(x.left==null) {
				return x.right;
			}

		Node y=getMinNode(x.right);
		Key newKey=y.key;
		Value newVal=y.value;
		Node newNode=new Node(newKey,newVal);
		newNode.left=x.left;
		newNode.right=deleteMin(x.right);
		x=newNode;
		

			
		}
		x.subTreeSize=1+size(x.left)+size(x.right);
		return x;
	}

//test client
	public static void main(String []args) {
		SymbolTable<String,Integer> bst=new SymbolTable<>();
		bst.put("one",1);
		bst.put("two",2);
		bst.put("three",3);
		bst.put("four",4);
		bst.put("five",5);
		bst.put("six",6);
		bst.put("eight",8);
		bst.put("nine",9);
		bst.put("vim",200);
		bst.print();
		
		bst.delete("one");
		
		bst.print();

		


	}
}