package cc.chapter6;

import java.util.Random;

public class Solution07 {
	public static int[] one (){
		Random child = new Random();
		int boy = 0;
		int girl = 0;
		while (girl == 0){
			if (child.nextBoolean())//Next child is a girl
				girl++;
			else
				boy++;
		}
		int[] children = {boy, girl};
		return children;
	}
	public static double all (int n){// There are n families in all.
		int boy = 0;
		int girl = 0;
		for (int i = 0; i < n; i++){
			int[] children = one();
			boy = boy + children[0];
			girl = girl + children[1];
		}
		return girl / (double)(boy + girl);
	}
	public static void main (String args[]){
		System.out.println(all(10));
		System.out.println(all(100));
		System.out.println(all(1000000));
		//We can conclude that when n is big enough, the ratio is close to 0.5.
	}
}
