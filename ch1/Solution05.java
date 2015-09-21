package com.cc.chapter1;

public class Solution05 {
	public static boolean oneAway(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		if (length1 == length2) //replacement
			return replacement(str1, str2);
		else if (length1 == length2+1) //remove
			return remove(str1, str2);
		else if (length2 == length1+1) //insert
			return remove(str2, str1);
		return false;
	}
	public static boolean replacement(String str1, String str2){
		int length = str1.length();
		boolean ifHasOne = false;
		for (int i = 0; i < length; i++){
			if( str1.charAt(i) != str2.charAt(i)){
				if (ifHasOne == true)
					return false;
				ifHasOne = true;
			}
		}
		return true;
	}
	public static boolean remove(String str1, String str2){
		int length1 = str1.length();
		int length2 = str2.length();
		int ptr1, ptr2;
		boolean ifHasOne = false;
		for (ptr1 = 0, ptr2 = 0; ptr1 < length1 && ptr2 < length2;){
			if (str1.charAt(ptr1) != str2.charAt(ptr2)){
				if (ifHasOne == true)
					return false;
				ifHasOne = true;
				ptr1++;
			}
			else{
				ptr1++;
				ptr2++;
			}
		}
		return true;
	}
	public static void main(String args[]){
		String str1 = "pale";
		String str2 = "pdld";
		System.out.println(oneAway(str1,str2));
	}
}
