package com.cc.chapter2;

import com.cc.chapter2.Solution06.LinkedListNode;

public class Solution08 {
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
	public static LinkedListNode insertAfter (LinkedListNode node, int data){
		LinkedListNode newNode = new LinkedListNode(data);
		node.next = newNode;
		return node;
	}
	public static LinkedListNode loopDetection(LinkedListNode head){
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		while (p2 != null && p2.next != null){
			p1 = p1.next;
			p2 = p2.next.next;
			if (p1 == p2)
				break;
		}
		/*while (p1 != p2){
			p1 = p1.next;
			p2 = p2.next.next;
		}*/
		if (p2 == null || p2.next == null)
			return null;
		p1 = head;
		while (p1 != p2){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	public static void main (String args[]){
		LinkedListNode l1 = new LinkedListNode(1);
		LinkedListNode ptr = l1;
		insertAfter(ptr, 2);
		ptr = ptr.next;
		insertAfter(ptr, 3);
		LinkedListNode loopStart = ptr;
		ptr = ptr.next;
		insertAfter(ptr, 4);
		ptr = ptr.next;
		ptr.setNext(loopStart);
		/*while (true){
			System.out.println(l1.data);
			l1 = l1.next;
			if (l1.next == null){
				System.out.println(l1.data);
				break;
			}
		}*/
		System.out.println(loopDetection(l1).data);
	}
}
