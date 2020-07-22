package eightpuzzle;

import binaryHeap.MinPriorityQueue;
import edu.princeton.cs.algs4.MinPQ;
import utility.console;
import stack.Stack;



	public class Solver {
		private class Move implements Comparable<Move>{
			Board board;
			int numOfMoves=0;
			Move prevMove;
			
			Move(Board board){
				this.board=board;
				
			}
			Move (Board board,Move prev){
				this.board=board;
				prevMove=prev;
				numOfMoves=1+prev.numOfMoves;
			}

			@Override
			public int compareTo(Move move) {
				return (this.board.manhattan() - move.board.manhattan()+(this.numOfMoves-move.numOfMoves));
			}
			
		}

		
		Move lastMove;


	    // find a solution to the initial board (using the A* algorithm)
	    public Solver(Board initial) {
			MinPQ<Move>moves=new MinPQ<Move>();
			MinPQ<Move>twinMoves=new MinPQ<Move>();
	    	moves.insert (new Move(initial));
	    	twinMoves.insert(new Move(initial.twin()));
	    	int count=0;
	    	while(true) {
	    		lastMove=expand(moves);
	    		if((lastMove!=null) || (expand(twinMoves)!=null))return;
	    	}
	    }
	    public Move expand(MinPQ<Move>moves) {
	    	
	    	if(moves.isEmpty()) {
	    		console.log("pq is empty");
	    		return null;
	    	}
	    	
	    	Move bestMove=moves.delMin();
	    	console.log("best move");
	    	console.log(bestMove.board.toString());
	    	if(bestMove.board.isGoal())return bestMove;
	    	

	    	for(Board board:bestMove.board.neighbors()) {	
		    	if(bestMove.prevMove==null|| !board.equals(bestMove.prevMove.board)) {		    		
		    		moves.insert(new Move(board,bestMove));
		    	}	
	    		
	    	}
	    	return null;
	    }

	    // is the initial board solvable? (see below)
	    public boolean isSolvable() {
	    	return lastMove!=null;
	    }

	    // min number of moves to solve initial board; -1 if unsolvable
	    public int moves() {
	    	if(isSolvable()) {
	    		return lastMove.numOfMoves;
	    	}
	    	return -1;
	    	
	    }

	    // sequence of boards in a shortest solution; null if unsolvable
	    public Iterable<Board> solution(){
	    	if(isSolvable()) {
		    	Stack<Board>stack=new Stack<>();
		    	while(lastMove!=null) {
		    		stack.push(lastMove.board);
		    		lastMove=lastMove.prevMove;
		    	}
		    	return stack;
	    	}
	    	return null;
	    }

	    // test client (see below) 
	    public static void main(String[] args) {
	    	
	    	
	    	int [][]tiles= {{3,2,1},{6,4,5},{8,7,0}};
	    	Board board=new Board(tiles);
	    	console.log("initial puzzle");
	    	console.log(board.toString());
	    	Solver s=new Solver(board);
	    	if(s.isSolvable()) {
	    		int i=1;
	    		for(Board b:s.solution()) {
		    		console.log("step no:"+i+"\n"+b.toString());
		    		i++;
		    	}
	    	}
	    	else {
	    		console.log("impossible to solve");
	    	}
	    	
	    }

	}

