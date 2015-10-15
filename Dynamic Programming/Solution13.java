package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution13 {
	/*
	 * Complete the function below.
	 */
	    static long highestStack(int[][] boxes) {
	        Arrays.sort(boxes, new Comparator<int[]>(){
	            public int compare(int[] A, int[] B){
	                //int a[] = (int[])A;
	                //int b[] = (int[])B;
	                return A[0] - B[0];
	            }
	        });
	        
	        long[] dp = new long[boxes.length];
	        for (int i = 0; i < dp.length;i++){
	            dp[i] = boxes[i][2];
	        }
	        long max = 0;
	        for (int i = 0; i < boxes.length; i++){//width sorted
	            //dp[i] = boxes[i][2];
	            for (int j = 0; j < i; j++){
	                if (boxes[j][1] < boxes[i][1] && boxes[j][0] < boxes[i][0]){
	                    if (dp[j] + boxes[i][2] < 1000000007)
	                        dp[i] = Math.max(dp[j] + boxes[i][2], dp[i]);
	                    else 
	                        dp[i] = Math.max((dp[j] + boxes[i][2])%1000000007, dp[i]);
	                }
	                    
	            }
	            max = Math.max(max, dp[i]);
	        }
	       // long max = dp[0];
	        //for (int i = 0; i < dp.length; i++){
	          //  if (dp[i] > max)
	            //    max = dp[i];
	        //}
	        return max;
	    }
	    public static void main(String[] args) throws IOException{
			Scanner in = new Scanner(System.in);
			int N = Integer.parseInt(in.nextLine().trim());
			int[][] boxes = new int[N][3];
			for (int i = 0; i < N; i++) {
				String[] split = in.nextLine().split(" ");
				for (int j = 0; j < split.length; j++) {
					boxes[i][j] = Integer.parseInt(split[j]);
				}
			}
			System.out.println(highestStack(boxes));
			in.close();
	    }

}
