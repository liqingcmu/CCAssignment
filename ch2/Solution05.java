package com.cc.chapter2;

import com.cc.chapter2.Solution01.LinkedListNode;

public class Solution05 {
	//Assume the linked list is singly list.
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
	/*public static class PartialSum {
		public LinkedListNode sum;
		int carry;
		public PartialSum(){
			sum = null;
			carry = 0;
		}
	}*/
	public static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2, int carry){
		if (l1 == null && l2 == null && carry ==0)
			return null;
		int value = carry;
		if (l1 != null)
			value = value+l1.data;
		if (l2 != null)
			value = value+l2.data;
		LinkedListNode result = new LinkedListNode();
		result.data = value % 10;
		if (l1 != null || l2 != null){
			LinkedListNode nextDigit = sumLists(l1 == null ? null : l1.next,l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
			result.setNext(nextDigit);
		}
		return result;
	}
	/*public static LinkedListNode sumLists2(LinkedListNode l1, LinkedListNode l2, int carry){
		int length1 = l1.length();
		int length2 = l2.length();
		if (length1 > length2)
			l2 = pad(l2,length1-length2);
		else
			l1 = pad(l1,length2-length1);
		PartialSum sum = sumListsHelper(l1, l2);
		if (sum.carry == 0)
			return sum.sum;
		else{
			LinkedListNode result = insertBefore(sum.sum, sum.carry);
			return result;
		}
	}
	public static PartialSum sumListsHelper(LinkedListNode l1, LinkedListNode l2){
		if (l1 == null && l2 == null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = sumListsHelper(l1.next, l2.next);
		int val = sum.carry + l1.data + l2.data;
		LinkedListNode result = insertBefore(sum.sum, val%10);
		sum.sum = result;
		sum.carry = val/10;
		return sum;
	}
	public static LinkedListNode pad (LinkedListNode list, int num){
		LinkedListNode head = list;
		for (int i = 0; i < num; i++){
			head = insertBefore(head, 0);
		}
		return head;
	}
	public static LinkedListNode insertBefore(LinkedListNode list, int data){
    	LinkedListNode node = new LinkedListNode(data);
    	if (list != null)
    		node.next = list;
    	return node;
    }*/
	/*public static void main (String args[]){
		LinkedListNode l1 = new LinkedListNode(7);
		LinkedListNode head1 = l1;
		l1.next = new LinkedListNode(1);
		l1.next.next = new LinkedListNode(6);
		LinkedListNode l2 = new LinkedListNode(5);
		//LinkedListNode head2 = l2;
		l2.next = new LinkedListNode(9);
		l2.next.next = new LinkedListNode(2);
		LinkedListNode result = sumLists(l1,l2,0);
		LinkedListNode result2 = sumLists2(l1,l2,0);
		//l1 = insertBefore(l1,8);
		//System.out.println(l1.length());
		while (true){
			System.out.println(l1.data);
			l1 = l1.next;
			if (l1.next == null){
				System.out.println(l1.data);
				break;
			}
				
		}
		System.out.println("========");
		while (true){
			System.out.println(result.data);
			result = result.next;
			if (result.next == null){
				System.out.println(result.data);
				break;
			}
				
		}
		System.out.println("========");
		while (true){
			System.out.println(result2.data);
			result2 = result2.next;
			if (result2.next == null){
				System.out.println(result2.data);
				break;
			}
				
		}
	}*/
}
