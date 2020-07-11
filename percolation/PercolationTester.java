package percolation;
import java.util.Random;
import utility.*;


public class PercolationTester {

	private  static void generateRandomArray (int[]arr,int size, int lessthan) {
		Random rand=new Random();
		for (int i=0;i<size;i++) {
			arr[i]=rand.nextInt(lessthan)+1;
		}
	}

    // test client (optional)
    public static void main(String[] args) {
    	
    	int gridSize=5;
    	int numberOfSimulations=10000;
    	int size=100;
    	int []arr=new int[size];
    	int lessthan=5;
    	double sumOfProb=0;

    	for(int j=0;j<numberOfSimulations;j++) {
    		Percolation p=new Percolation(gridSize);
    		generateRandomArray(arr, size,lessthan);
    		
			for(int i=0;i<arr.length-1 ;i=i+2) {
				int a=arr[i];
				int b=arr[i+1];
				p.open(a, b);
				
				if(p.percolates()) {
					int openSites=p.numberOfOpenSites();
					int totalSites=gridSize*gridSize;					
					double prob=(double)openSites/totalSites;					
					sumOfProb+=prob;
					break;
				}
								
			}

    	}
    	double average=sumOfProb/numberOfSimulations;
    	console.log("number of simulation performed = "+numberOfSimulations);
    	console.log("grid of size  "+gridSize+" X "+gridSize);
    	console.log("the system will percolate when "+average*100+" % of total sites are open");  	
    }

}
