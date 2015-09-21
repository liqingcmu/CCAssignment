package com.cc.chapter1;

import java.util.Arrays;

public class Solution01 {
	public static boolean isUnique(String str){
		char[] arrayOfStr = str.toCharArray();
		Arrays.sort(arrayOfStr);
		for (int i = 0; i < arrayOfStr.length-1; i++){
			if (arrayOfStr[i] == arrayOfStr[i+1])
				return false;
		}
		return true;
	}
	public static boolean isUnique1(String str){
		int length = str.length();
		if (length > 128)
			return false;
		boolean[] alphabet = new boolean[128];
		for (int i = 0; i < length-1; i++){
			if (alphabet[str.charAt(i)])
				return false;
			alphabet[str.charAt(i)] = true;
		}
		return true;
	}
	public static void main(String args[]){
		String str = "asdf";
		boolean a = isUnique1(str);
		System.out.println(a);
	}
}
