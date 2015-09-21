 package com.cc.chapter1;

public class Solution06 {
	public static String strCompression (String str){
		int length = str.length();
		int compressedLength = count(str);
		if (compressedLength >= length)
			return str;
		int countConsecutive = 0;
		StringBuilder compressedStr = new StringBuilder(compressedLength);
		for (int i = 0; i < length; i++){
			countConsecutive++;
			if ( i+1 >= length || str.charAt(i) != str.charAt(i+1) ){
				compressedStr.append(str.charAt(i));
				compressedStr.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressedStr.toString();
	}
	public static int count (String str){
		int countConsecutive = 0;
		int compressedLength = 0;
		int length = str.length();
		for (int i = 0; i < length; i++){
			countConsecutive++;
			if (i+1 >= length || str.charAt(i) != str.charAt(i+1)){
				compressedLength = compressedLength + 1 + String.valueOf(countConsecutive).length();
				countConsecutive = 0;
			}
		}
		return compressedLength;
	}
	public static void main (String args[]){
		String str ="aabccccaaa";
		System.out.println(strCompression(str));
	}
}
