package cc.chapter5;

public class Solution01 {
	public static int insertion (int n, int m, int i, int j){
		//Create mask
		int allOnes = ~0;
		int left = allOnes << (j+1);
		int right = (1 << i) - 1;
		int mask = left | right;
		//Clear jth - ith bits of N
		int n_new = n & mask;
		//Move M to the appropriate position correspond to N
		int m_new = m << i;
		return n_new | m_new;
	}
}
