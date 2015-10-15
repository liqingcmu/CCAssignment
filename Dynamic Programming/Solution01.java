package dp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution01 {
	/*
	 * Complete the function below.
	 */

	    static long[] countPaths(int[] A, int[] T) {
	        Arrays.sort(A);
	        Arrays.sort(T);
	        int length_dp = T.length;
	        long[] dp = new long[T[length_dp - 1] + 1];
	        dp[0] = 1;
	        long[] result = new long[T.length];
	        for (int i = 1; i <= T[length_dp - 1]; i++){
	            for (int j = 0; j < A.length; j++){
	                if (i >= A[j])
	                {
	                    if(dp[i] + dp[i - A[j]] <= 1000000007)
	                        dp[i] = dp[i] + dp[i - A[j]];
	                    else
	                        dp[i] = (dp[i] + dp[i - A[j]]) % 1000000007;
	                }
	            }
	        }
	        for (int j = 0; j < T.length; j++){
	            int index = T[j];
	            result[j] = dp[index];
	        }
	        return result;
	    }
	    public static void main(String[] args) throws IOException{
	        Scanner in = new Scanner(System.in);
			String[] split = in.nextLine().split(" ");
			int[] A = new int[split.length];
			for(int i=0; i<split.length; i++)
				A[i] = Integer.parseInt(split[i]);
			int N = Integer.parseInt(in.nextLine().trim());
			int[] T = new int[N];
			for(int i=0; i<N; i++) {
				T[i] = Integer.parseInt(in.nextLine().trim());
			}
			long[] countPaths = countPaths(A, T);
			for(long c : countPaths)
				System.out.println(c);
			in.close();

	    }


}
