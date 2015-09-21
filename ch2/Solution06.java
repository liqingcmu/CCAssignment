package com.cc.chapter2;

import java.util.Stack;

import com.cc.chapter2.Solution05.LinkedListNode;

public class Solution06 {
	public static class LinkedListNode {  
	    public int data;  
	    public LinkedListNode next;  
	    public LinkedListNode() {  
	        this.data = -1;
	        this.next = null;
	    }
	    public LinkedListNode(int data) {  
	        this.data = data;    
	        this.next = null;
	    }
	    public void setNext(LinkedListNode node){
	    	this.next = node;
	    }
	    public int length (){
	    	int count = 0;
	    	LinkedListNode node = this;
	    	while (node.next != null){
	    		count++;
	    		node = node.next;
	    	}
	    	return count+1;
	    }
	}
	//Use two pointers and stack ADT
	public static boolean palindrome(LinkedListNode head){
		if (head == null || head.next == null)
			return false;
		LinkedListNode ptr1 = head;
		LinkedListNode ptr2 = head;
		Stack<Integer> firstHalf = new Stack<Integer>();
		while (ptr2 != null && ptr2.next != null){ //ptr2 != null--odd;ptr2.next != null--even
			firstHalf.push(ptr1.data);
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
		}
		if (ptr2 != null) //The list has odd length.
			ptr1 = ptr1.next;
		while (ptr1 != null){
			int first = firstHalf.pop();
			if (first != ptr1.data)
				return false;
			ptr1 = ptr1.next;
		}
		return true;
	}
	public static LinkedListNode insertAfter (LinkedListNode node, int data){
		LinkedListNode newNode = new LinkedListNode(data);
		node.next = newNode;
		return node;
	}
	public static void main (String args[]){
		LinkedListNode l1 = new LinkedListNode(7);
		LinkedListNode ptr = l1;
		insertAfter(ptr, 5);
		//ptr = ptr.next;
		//insertAfter(ptr, 7);
		/*insertAfter(l1, 1);
		insertAfter(l1, 1);
		insertAfter(l1, 1);*/
		while (true){
			System.out.println(l1.data);
			l1 = l1.next;
			if (l1.next == null){
				System.out.println(l1.data);
				break;
			}
				
		}
		System.out.println(palindrome(l1));
	}
}
