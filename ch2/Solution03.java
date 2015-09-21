package com.cc.chapter2;

import com.cc.chapter2.Solution02.LinkedListNode;

public class Solution03 {
	public class LinkedListNode {  
	    public int data;  
	    public LinkedListNode next;  
	    public LinkedListNode(int data) {  
	        this.data = data;    
	    }  
	}
	public static boolean deleteMiddleNode (LinkedListNode node){
		if (node == null || node.next == null){
			return false;
		}
		LinkedListNode nextNode = node;
		node.data = nextNode.data;
		node.next = nextNode.next;
		return true;
	}
}
