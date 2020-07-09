package percolation;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

class Percolation{
	int SIZE;
	WeightedQuickUnionUF gridRepresentation;
	//to prevent something called backwash error in which a for bottom row isFull() can be true even if
	//that bottom row element is not connected to top site. so to prevent this we have to create this array
	
	WeightedQuickUnionUF gridForErrorFixing;
	boolean [] openSites;
	int source;
	int sink;
	int numberOfSitesOpen;
	
	
    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int N) {
    	//initialize both grid array to increasing sequence of number
    	//2 is added to accomodate virtual top and virtual bottom
    	int requiredSize=N*N+2;
    	gridRepresentation=new WeightedQuickUnionUF(requiredSize);
    	gridForErrorFixing=new WeightedQuickUnionUF(requiredSize);
    	SIZE=N;
    	source=twoDimensionToOne(N,N)+1;
    	sink=twoDimensionToOne(N,N)+2;
    	
    	//for N=10 boolean array indexing from 0-99 is created
    	openSites=new boolean [N*N];
    	for(int i=0;i<N*N;i++) {
    		openSites[i]=false;
    	}
    	numberOfSitesOpen=0;
    }
    
    
    private boolean isValid(int row,int col) {
    	
    	return row>0 &&col>0 &&row <=SIZE && col<=SIZE;
    }
   
    private void checkIfValid(int row,int col) {
    	if(!isValid(row,col)) {
    		throw new IndexOutOfBoundsException("invalid argument or bound crossed for "+row+" and "+col);
    	}
    }
 
    private int twoDimensionToOne (int row, int column) {
    	checkIfValid(row, column);
    	return ((row-1)*SIZE+column-1);
	}



	// opens the site (row, col) if it is not open already
    public void open(int row, int col) {

    	checkIfValid(row, col);
    	
    	if(isOpen(row,col)) {
    		return;
    	}
    	
    	int index=twoDimensionToOne(row, col);
    	openSites[index]=true;
    	numberOfSitesOpen++;
    	
    	
    	//for first  row
    	if (row==1) {
    		gridForErrorFixing.union(source,index);
    		gridRepresentation.union(source,index);
    	}
    	
    	//for the last row
    	//only gridRepresentation is connected to sink to prevent backwash error
    	if(row==SIZE) {
    		gridRepresentation.union(sink,index);
    	}
    	
    	if(isValid(row-1,col) && isOpen(row-1,col)) {
    		int idx=twoDimensionToOne(row-1,col);
    		gridForErrorFixing.union(idx,index);
    		gridRepresentation.union(idx,index);
    	}
    	if(isValid(row+1,col) && isOpen(row+1,col)) {
    		int idx=twoDimensionToOne(row+1,col);
    		gridForErrorFixing.union(idx,index);
    		gridRepresentation.union(idx,index);
    	}
    	if(isValid(row,col-1) && isOpen(row,col-1) ) {
    		int idx=twoDimensionToOne(row,col-1);
    		gridForErrorFixing.union(idx,index);
    		gridRepresentation.union(idx,index);
    	}
    	if(isValid(row,col+1)&& isOpen(row,col+1)) {
    		int idx=twoDimensionToOne(row,col+1);
    		gridForErrorFixing.union(idx,index);
    		gridRepresentation.union(idx,index);
    	}
    		
    }
    	

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
    	checkIfValid(row, col);
    	return openSites[twoDimensionToOne(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
    	checkIfValid(row, col);
    	int index=twoDimensionToOne(row, col);
    	
    	//here i cant use gridRepresentation because tesma bottom are connected to sink
    	//i have to maintain gridErrorFixing error array without connecting bottomRow site 
    	//to virtua; bottom
    	int bottomRoot =gridForErrorFixing.find(sink);
    	int topRoot=gridForErrorFixing.find(source);
    	if(bottomRoot==topRoot) {
    		return true;
    	}
    	return false;
    	
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
    	return numberOfSitesOpen;
    }

    // does the system percolate?
    public boolean percolates() {
    	int top=gridRepresentation.find(source);
    	int bottom=gridRepresentation.find(sink);
    	if(top==bottom) {
    		return true;
    	}
    	return false;
    }

//    // test client (optional)
//    public static void main(String[] args) {
//    	
//    }
//	
}