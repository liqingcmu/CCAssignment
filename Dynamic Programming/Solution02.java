package dp;
import java.io.*;
import java.util.*;
import java.math.*;
public class Solution02 {
    public static class Node{
			int x; //position
			int y;
			int state; // 0 is unvisited, 1 is visited, -1 is not allowed to visit
			int step = Integer.MAX_VALUE;//From the beginning, how many steps needed in the shortest way
			int countOfMin = 0;//From the beginning, how many shortest ways
			public Node (int x, int y){
				this.x = x;
				this.y = y;
				this.state = 0;
			}
			public Node(){
				this.state = 0;
				
			}
			public int getState() {
				return state;
			}
			public void setState(int state) {
				this.state = state;
			}
			public int getStep() {
				return step;
			}
			public void setStep(int step) {
				this.step = step;
			}
			public int getCountOfMin() {
				return countOfMin;
			}
			public void setCountOfMin(int countOfMin) {
				this.countOfMin = countOfMin;
			}
			
		}
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner in = new Scanner(System.in);
	    	int row  = in.nextInt();
	    	int column = in.nextInt();
	    	//System.out.println(row + "  " + column);
	    	Node[][] matrix = new Node[row][column];
	    	for(int i = 0; i < row; ++i){
	    		for(int j = 0; j < column; ++j){
	    			matrix[i][j] = new Node(i,j);
	    		}
	    	}
	    	in.nextLine();
	    	//System.out.println(in.nextLine() + 1);
	    	//System.out.println(in.nextLine() + 2);
	    	//System.out.println(in.nextLine() + 3);
	    	// Initialize the matrix
	    	for (int i = 0; i < row; i++){
	    		String s = in.nextLine();
	    		
	    		for (int j = 0; j < s.length(); j++){
	    			if(s.charAt(j) == 'o')
	    				matrix[i][j].setState(0);
	    			else if (s.charAt(j) == 'x')
	    				matrix[i][j].setState(-1);
	    		}
	    		//System.out.println();
	    	}
	    	//Initialize the top leftmost node;
	    	matrix[0][0].setState(1);
	    	matrix[0][0].setStep(0);
	    	matrix[0][0].setCountOfMin(1);
	    	Queue<Node> queue = new LinkedList<Node>();
	    	queue.add(matrix[0][0]);
	    	while (!queue.isEmpty()){
	    		Node cur = queue.poll();
	    		int i = cur.x;
	    		int j = cur.y;
	    		//int min = cur.getStep();
                //int min = Integer.MAX_VALUE;
	    		if (i-1 >= 0){
	    			if (matrix[i-1][j].getState() == 0){
	    				
	    				queue.add(matrix[i-1][j]);
	    				matrix[i-1][j].setState(2);
	    			}
	    			if (matrix[i-1][j].getState() == 1){
	    				//min = min != 0 ? Math.min(matrix[i-1][j].getStep() + 1, min) : (matrix[i-1][j].getStep() + 1);
	    				//cur.setStep(min);
                        cur.setStep(cur.getStep() > matrix[i-1][j].getStep()  + 1? matrix[i-1][j].getStep() + 1: cur.getStep());
	    			//System.out.println(cur.getStep());
	    			}
	    			
	    		}
	    		if (i+1 < row){
	    			if (matrix[i+1][j].getState() == 0){
	    				queue.add(matrix[i+1][j]);
	    				matrix[i+1][j].setState(2);
	    			}
	    			if (matrix[i+1][j].getState() == 1){
	    				cur.setStep(cur.getStep() > matrix[i+1][j].getStep()+1 ? matrix[i+1][j].getStep() + 1: cur.getStep());
	    			}
	    		}
	    		if (j-1 >=0){
	    			if (matrix[i][j-1].getState() == 0){
	    				queue.add(matrix[i][j-1]);
	    				matrix[i][j-1].setState(2);
	    			}
	    			if (matrix[i][j-1].getState() == 1){
	    				cur.setStep(cur.getStep() > matrix[i][j - 1].getStep()+1 ? matrix[i][j - 1].getStep() + 1: cur.getStep());
                    }
	    		}
	    		if (j+1 < column){
	    			if (matrix[i][j+1].getState() == 0){
	    				queue.add(matrix[i][j+1]);
	    				matrix[i][j+1].setState(2);
	    			}
	    			if (matrix[i][j+1].getState() == 1){
                        cur.setStep(cur.getStep() > matrix[i][j + 1].getStep()+1 ? matrix[i][j + 1].getStep() + 1: cur.getStep());
	    				//min = Math.min(min, matrix[i][j+1].getStep());
	    			}
	    		}
                //cur.setStep(min+1);
	    		//Compute the number of neighbors with minimum steps.
	    		int lastmin = cur.getStep() -1;
	    		if (i-1 >= 0){
	    			if (matrix[i-1][j].getStep() == lastmin){
	    				if(matrix[i - 1][j].getCountOfMin() + cur.getCountOfMin() > 1000000007)
	    			        cur.setCountOfMin((matrix[i-1][j].getCountOfMin() + cur.getCountOfMin()) % 1000000007);
                        else 
                            cur.setCountOfMin(matrix[i-1][j].getCountOfMin() + cur.getCountOfMin()) ;
	    			}
	    		}
	    		if (i+1 < row){
	    			if (matrix[i+1][j].getStep() == lastmin){
                        if(matrix[i + 1][j].getCountOfMin() + cur.getCountOfMin() > 1000000007)
	    			        cur.setCountOfMin((matrix[i+1][j].getCountOfMin() + cur.getCountOfMin()) % 1000000007);
                        else 
                            cur.setCountOfMin(matrix[i+1][j].getCountOfMin() + cur.getCountOfMin()) ;
	    			//System.out.println(cur.getCountOfMin());
	    			}
	    			
	    		}
	    		if (j-1 >=0){
	    			if (matrix[i][j-1].getStep() == lastmin){
	    				if(matrix[i][j-1].getCountOfMin() + cur.getCountOfMin() > 1000000007)
	    			        cur.setCountOfMin((matrix[i][j-1].getCountOfMin() + cur.getCountOfMin()) % 1000000007);
                        else 
                            cur.setCountOfMin(matrix[i][j-1].getCountOfMin() + cur.getCountOfMin()) ;
	    			}
	    		}
	    		if (j+1 < column){
	    			if (matrix[i][j+1].getStep() == lastmin){
	    				if(matrix[i][j+1].getCountOfMin() + cur.getCountOfMin() > 1000000007)
	    			        cur.setCountOfMin((matrix[i][j+1].getCountOfMin() + cur.getCountOfMin()) % 1000000007);
                        else 
                            cur.setCountOfMin(matrix[i][j+1].getCountOfMin() + cur.getCountOfMin()) ;
	    			}
	    		}
	    		cur.setState(1);
	    	}
            if (matrix[row-1][column-1].getStep() == Integer.MAX_VALUE){
                System.out.println(0);
	    	  System.out.println(-1);
            }
            else{   
	    	System.out.println(matrix[row-1][column-1].getCountOfMin());
	    	System.out.println(matrix[row-1][column-1].getStep());
            }
}
}
