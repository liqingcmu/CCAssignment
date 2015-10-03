package cc.chapter5;

public class Solution03 {
	public static int flipBitToWin(int n){
		int maxSeq = 0;
		for (int i = 0; i < 32; i++)
			maxSeq = Math.max(maxSeq, longestSeqOf1s(n,i));
		return maxSeq;
	}
	public static boolean getBit (int n, int i){
		boolean b = (n & (1 << i)) != 0;
		return b;
	}
	public static int longestSeqOf1s(int n, int indexIgnore){
		int max = 0;
		int counter = 0;
		for (int i = 0; i < 32; i++){
			if (i == indexIgnore || getBit(n, i)){
				counter ++;
				max = Math.max(counter, max);
			}
			else
				counter = 0;
		}
		return max;
	}
	public static void main (String args[]){
		int i = 1775;
		System.out.println(flipBitToWin(i));
	}
}
