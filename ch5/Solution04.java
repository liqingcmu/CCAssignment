package cc.chapter5;

public class Solution04 {
	public static int flip (int number, int bit){
		if (((number >> bit) & 1) == 1) // Set from 1 to 0
			return number & (~(1 << bit));
		else// Set from 0 to 1
			return number | (1 << bit);
	}
	public static int nextSmallest (int number) throws Exception{
		for (int i = 0; i < 32; i++){
			if ((((number >> i) & 1) == 1) && i > 0 && (((number >> (i-1)) & 1) == 0)){
				number = flip(number, i);
				number = flip(number, i-1);
				return number;
			}
		}
		throw new Exception("Can't find the next smallest number.");
	}
	public static int prevLargest (int number) throws Exception{
		for (int i = 0; i < 32; i++){
			if ((((number >> i) & 1) == 0) && i > 0 && (((number >> (i-1)) & 1) == 1)){
				number = flip(number, i);
				number = flip(number, i-1);
				return number;
			}
		}
		throw new Exception("Can't find the previous largest number.");
	}
	public static void main(String args[]) throws Exception{
		int n = 45;
		System.out.println(nextSmallest(45));
		System.out.println(prevLargest(45));
	}
}
