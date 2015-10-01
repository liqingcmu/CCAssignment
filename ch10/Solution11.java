package chapter10;

import java.util.Arrays;

public class Solution11 {
/**
*Original array: small-medium-large
*Arranged array: medium-small-large
*The method runs O(n logn) time*/
	
	public static void peakAndVally (int[] array){
		Arrays.sort(array);
		for (int i = 1; i < array.length; i = i+2){
			swap(array, i-1, i);
		}
	}
	public static void swap (int[] array, int valley, int peak){
		int temp = array[valley];
		array[valley] = array[peak];
		array[peak] = temp;
	}
	
}
