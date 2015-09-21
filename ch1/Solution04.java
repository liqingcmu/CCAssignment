package com.cc.chapter1;

public class Solution04 {
	public static boolean isPalindromePermutation(String str){
		int oddCount = 0;
		char[] arrayOfStr = str.toCharArray();
		int[] table = new int[Character.getNumericValue('z')-Character.getNumericValue('a')+1];
		for (char c :arrayOfStr){
			int x = getElemNumber(c);
			if(x != -1){
				table[x]++;
				if (table[x] % 2 == 0)
					oddCount--;
				else
					oddCount++;
			}
		}
		return oddCount<=1;
	}
	public static int getElemNumber(char c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int A = Character.getNumericValue('A');
		int Z = Character.getNumericValue('Z');
		int val = Character.getNumericValue(c);
		if (val >= a && val <= z)
			return val - 'a';
		else if (val >= A && val <= Z)
			return val - 'A';
		return -1;
	}
}
