package eightpuzzle;

import java.util.LinkedList;

import utility.console;

public class Board {
	int size;
	int [][]tiles;
    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
   
	public Board(int[][] _tiles) {
    	size=_tiles.length;
    	tiles=new int[size][size];
    	for(int i=0;i<size;i++) {
    		for (int j=0;j<size;j++) {
    			tiles[i][j]=_tiles[i][j];
    		}
    	}
    }
                                           
    // string representation of this board
    public String toString() {
    	
    	String s=new String(String.valueOf(tiles.length)+"\n");
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			s=s+(String.valueOf(tiles[i][j]));
    			s=s+",";    			
    		}
    		s=s+"\n";
    	}
    	return s;
    }

    // board dimension n
    public int dimension() {
    	return size;
    }

    // number of tiles out of place
    public int hamming() {
    	int k=1;
    	int count=0;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			if(tiles[i][j]!=k++||tiles[i][j]!=0)count++;
    		}
    	}
    	return count;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
    	int sumOfManHattanDistance=0;
    	int k=1;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			//if element matches or element i a open space for silder
    			if(tiles[i][j]==k ||tiles[i][j]==0) {
    				k++;
    				continue;
    			}
    			int numberAt=tiles[i][j];
    			int manHattenDistance=Math.abs(i-(numberAt/size))+Math.abs(j-(numberAt%size));
    			sumOfManHattanDistance+=manHattenDistance;
    			k++;
    		}
    	}
    	return sumOfManHattanDistance;
    }

    // is this board the goal board?
    public boolean isGoal() {
    	int k=1;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			if(k==9)return true;
    			if(tiles[i][j]!=k++)return false;
    		}
    	}
    	return true;
    	
    }

    // does this board equal y?
    public boolean equals(Object y) {
    	if(y==null)return false;
    	if(tiles==y)return true;
    	if(!(y instanceof Board))return false;
    	if(((Board)y).size!=size)return false;
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			if(tiles[i][j]!=((Board)y).tiles[i][j])return false;
    		}
    	}
    	return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors(){
    	//
    	LinkedList<Board> neighbors=new LinkedList<Board>();

    	int [] spaceLocation=getSpaceLocation();
    	int row=spaceLocation[0];
    	int col=spaceLocation[1];
    	
    	 if (row > 0)               neighbors.add(new Board(swapAndReturnNew(row, col, row - 1, col)));
         if (row < dimension() - 1) neighbors.add(new Board(swapAndReturnNew(row, col, row + 1, col)));
         if (col > 0)               neighbors.add(new Board(swapAndReturnNew(row, col, row, col - 1)));
         if (col < dimension() - 1) neighbors.add(new Board(swapAndReturnNew(row, col, row, col + 1)));
         
         return neighbors;
    	
    }
    private int[] getSpaceLocation() {
    	int [] result=new int[2];
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size;j++) {
    			if(tiles[i][j]==0) {
    				result[0]=i;
    				result[1]=j;
    				
    			}
    		}
    	}
    	return result;
    }
    private int[][]copy(int[][]tiles) {
    	int [][]copy=new int[tiles.length][tiles.length];
    	for(int i=0;i<tiles.length;i++) {
    		for(int j=0;j<tiles.length;j++) {
    			copy[i][j]=tiles[i][j];
    		}
    	}
    	return copy;
    }
    private int [][]swapAndReturnNew(int row1,int col1,int row2,int col2){
    	int[][] copy=copy(tiles);
    	int temp=copy[row1][col1];
    	copy[row1][col1]=copy[row2][col2];
    	copy[row2][col2]=temp;
    	return copy;
    	
    }
    

//     a board that is obtained by exchanging any pair of tiles
//     a board is unsolvable if there are odd numbers of inversion in the board
//    this can be removed by swapping any two tiles(not space) by doing this board becomes solvable
//    so we always try to solve two board one of which is twin of other
//    if we accidently land on unsolvable board both board can't be solvable so one can be solved
    
    public Board twin() {
    	for(int i=0;i<size;i++) {
    		for(int j=0;j<size-1;j++) {
    			if(tiles[i][j]!=0 &&tiles[i][j+1]!=0) {
    				return new Board(swapAndReturnNew(i,j,i,j+1));
    			}
    		}
    	}
    	return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
    	console.log("everything is working fine till now");
    	int [][]tiles= {{1,4,2},{2,6,5},{7,0,8}};
    	Board board=new Board(tiles);
    	console.log(board.toString());
    	Board newBoard=board.twin();
	   
    	for(Board nboard:board.neighbors()) {
		   console.log(nboard.toString());
		   console.log(nboard.isGoal());
	    }
    	int [][]test= {{1,2,3},{4,5,6},{7,8,0}};
    	
    	Board nboard=new Board(test);
    	console.log(nboard.toString());
    	console.log(nboard.isGoal());
    	console.log(nboard.manhattan());
 
    	
    }

}
