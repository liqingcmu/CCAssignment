package dp;

import java.io.*;
import java.util.*;
import java.math.*;

public class Solution11 {
    // fk(n) = f k-1 (n) + f k-1 (n-k) + f k-1 (n-2k) + ...+ f k-1 (n-mk)   n-mk>0
    // fk(n) = f k-1 (n) + f k (n-k)
    public static long[] count (int A[], int T[]){
        Arrays.sort(A);
        Arrays.sort(T);
        int length_dp = T[T.length - 1] + 1;
        long[] dp = new long[length_dp];
        long[] result = new long[T.length];
        dp[0] = 1;
        for (int i = 0; i < A.length; i++){
            for (int j = 1; j <= T[T.length - 1];j++){
                if (j >= A[i])
                {
                    if(dp[j] + dp[j - A[i]] <= 1000000007)
                        dp[j] = dp[j] + dp[j - A[i]];
                    else
                        dp[j] = (dp[j] + dp[j - A[i]]) % 1000000007;
                }
            }
        }
        for (int j = 0; j < T.length; j++){
            int index = T[j];
            result[j] = dp[index];
        }
        return result;
    }
    public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    
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
		long[] countPaths = count(A, T);
		for(long c : countPaths)
			System.out.println(c);
		in.close();
    
}
}
