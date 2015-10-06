package cc.chapter6;

public class Solution08 {
	//Given that we have two eggs in all.
	// We have to compute the interval first. n + (n-1) + (n-2) + ... + 1 >= 100. n = 13.651. Let the interbal be 14.
	static int count = 0;
	static int breakPoint = 76; //Suppose egg will break when it's dropped from 76th floor.
	public static boolean ifBreak (int level){
		count++;
		return level >= breakPoint;
	}
	public static int findBreakPoint (int level){
		int interval = 14;
		int previous = 0;
		int egg1 = interval;
		//Drop egg1 at decreasing intervals.
		while (!ifBreak(egg1) && egg1 <= level){
			interval --;
			previous = egg1;
			egg1 = egg1 + interval;
		}
		// Egg1 break.
		// Drop egg2 at 1 increasing units.
		int egg2 = previous + 1;
		while (egg2 < egg1 && egg2 <= level && !ifBreak(egg2))
			egg2 ++;
		//If egg2 isn't broken, return -1;
		return egg2 > level ? -1:egg2;
	}
}
