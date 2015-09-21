package com.cc.chapter2;

import java.util.LinkedList;

import com.cc.chapter2.Solution01.LinkedListNode;

public class Solution02 {
	/**
	 * Return kth to Last
	 * Assume if k = 1, return the last element of the linked list.*/
	public class LinkedListNode {  
	    public int data;  
	    public LinkedListNode next;  
	    public LinkedListNode(int data) {  
	        this.data = data;    
	    }  
	}
	/*The method returnKTOLast includes the passed argument: length of the linkedlist.*/
	public static LinkedListNode returnKTOLast (LinkedListNode head, int length, int k){
		if (length > k+1 || head == null)
			return null;
		int count = 0;
		LinkedListNode current = head;
		while (count < length - k + 1){
			current = current.next;
			count++;
		}
		return current;
	}
	/*The method returnKTOLast1 takes O(1) time and O(n) space.*/
	public static LinkedListNode returnKTOLast1 (LinkedListNode head, int k){
		if (head == null)
			return null;
		LinkedListNode ptr1 = head;
		LinkedListNode ptr2 = head;
		for (int i = 0; i < k; i++){
			if (ptr1 == null)
				return null;
			ptr1 = ptr1.next;
		}
		while (ptr1 != null){
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return ptr2;
	}
}
