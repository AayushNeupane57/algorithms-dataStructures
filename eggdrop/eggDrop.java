package eggdrop;
import java.util.List;

import java.util.ArrayList;
public class eggDrop {
	
	//to prevent duplicate calls in our recursive calls
	static int[][] memo;
	static int level;
	static List floorsTop;
	eggDrop(int egg,int floor) {
		floorsTop=new ArrayList();
		memo=new int[egg][floor];
		for(int i=0;i<egg;i++) {
			for(int j=0;j<floor;j++) {
				memo[i][j]=-1;
			}
		}
	}
	 public static int solve(int egg,int floor){
		 	if(memo[egg][floor]!=-1) {
		 		
		 		return memo[egg][floor];
		 	}
		 	int result;
		 	
	        if(egg<1){
	             result =floor;
	        }
	        else if(floor==0||floor==1){
	            result= 1;
	        }
	        else {
	        List<Integer> floors=new ArrayList<>();
	        int min=10000;
	        //this is simulation we check for every case for every possible floor
	        //for every floor we calculate number of tries for two cases 
	        //1. if egg breaks 
	        //2.if egg don't breaks
	        //some time it takes shorter step when egg breaks and other time it takes 
	        //shorter step if egg don't break at that floor
	        //in worst case one which take longer tries/step could happen 
	        //so we store max among this two
	        
	        
		        for(int k=1;k<floor;k++){
		            int temp=1+max(solve(egg-1,k-1),solve(egg,floor-k));
		            //min variable is storing the minimum berore this simulation or for lower floors
		            //if new simulation takes shorter tries than min that means it is the new min
		           
		            //yaa min change hunu vaneko agadi drop gareko floor efficient thyena and this is
		            //new efficient 
		            min=minOf(min,temp);
		            
		            
		        }
	        result= min;
	        floorsTop=floors;
	        }
	        memo[egg][floor]=result;
	        return result;
	    }
	    
	    public static int minOf(int first,int second){
	        return first<=second?first:second;
	    }
	    
	    public static int max(int first,int second){
	        return first>=second?first:second;
	    }

	     public static void main(String []args){
	       
	    	 // 2 eggs 0 and 1
	        int egg=1;
	        //for 1000 stories 0-999
	        int floor=999;
	        //object is just called to initialize memo array maybe not good way
	        //passed  egg+1 to create say when egg is 0 and 1 create 2 row for egg in  2d matrix
	        eggDrop ew =new eggDrop(egg+1,floor+1);
	        int min=solve(egg,floor);
	         System.out.println("the minimum is "+min);
	        
	        
	     }
}
