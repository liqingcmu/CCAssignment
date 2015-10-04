package cc.chapter5;

public class Solution06 {
	// Using XOR can count the difference between the two numbers. 
	public static int conversion (int a, int b){
		int count = 0;
		int c = a ^ b;
		while (c != 0){
			if ((c&1) == 1)
				count++;
			c = c>>1;
		}
		return count;
	}
	public static void main (String args[]){
		System.out.println(conversion(29,15));
	}
}
