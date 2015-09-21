package com.cc.chapter1;

import java.util.Arrays;

public class Solution02 {
	/*public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}*/
	public static boolean ifPermutation (String str1, String str2){
		if (str1.length() != str2.length())
			return false;
		if (str1.equals(str2))
			return true;
		char[] charOfStr1 = str1.toCharArray();
		char[] charOfStr2 = str2.toCharArray();
		Arrays.sort(charOfStr1);
		Arrays.sort(charOfStr2);
		for (int i = 0; i < charOfStr1.length; i++){
			if (charOfStr1[i] != charOfStr2[i])
				return false;
		}
		
		return true;
	}
	public static boolean ifPermutation1 (String str1, String str2){
		int length = str1.length();
		if (length != str2.length())
			return false;
		if (str1.equals(str2))
			return true;
		int[] alphabet = new int[128];
		char[] charOfStr1 = str1.toCharArray();
		for (char c : charOfStr1){
			alphabet[c]++;
		}
		for (int i = 0; i < length; i++){
			int a = (int)str2.charAt(i);
			alphabet[a]--;
			if (alphabet[a]<0)
				return false;
		}
		
		return true;
	}
	public static void main (String args[]){
		String str1 = "abcde";
		String str2 = "asdfe";//badec
		/*char[] charOfStr = str2.toCharArray();
		Arrays.sort(charOfStr);
		System.out.println(charOfStr);*/
		System.out.println(ifPermutation1(str1,str2));
	}
}
