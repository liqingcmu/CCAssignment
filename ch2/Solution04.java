package com.cc.chapter2;

import com.cc.chapter2.Solution03.LinkedListNode;

public class Solution04 {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public static ListNode partition (ListNode head, int x){
		if (head == null || head.next == null)
			return head;
		ListNode smallNum = new ListNode(-1);
		ListNode headSmall = smallNum;
		ListNode bigNum = new ListNode(-1);
		ListNode headBig = bigNum;
		while(head != null){
			if (head.val >= x){
				bigNum.next = head;
				bigNum = bigNum.next;
			}
			else{
				smallNum.next = head;
				smallNum = smallNum.next;
			}
			head = head.next;
		}
		bigNum.next = null;
		smallNum.next = headBig.next;
		head = headSmall.next;
		return head;
	}
	
	
}
