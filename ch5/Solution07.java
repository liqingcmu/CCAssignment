package cc.chapter5;

public class Solution07 {
	public static int pairwiseSwap (int a){
		/**
		 * Use even bit mask(0101 0101) and odd bit mask (1010 1010).
		 * Shift even results to left, shift odd results to right.And OR the results.
		 * Suppose this is a 32-bit integer.*/
		int odd_mask = 0xAAAAAAAA;
		int even_mask = 0x55555555;
		return (odd_mask >>> 1) | (even_mask << 1);//Use logical right shift
	}
}
