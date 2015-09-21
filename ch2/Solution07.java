package com.cc.chapter2;

import com.cc.chapter2.Solution06.LinkedListNode;

public class Solution07 {
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
	public static class Result {
		LinkedListNode tail;
		int size;
		public Result(LinkedListNode tail, int size){
			this.size = size;
			this.tail = tail;
		}
	}
	//Different
	public static Result getTailAndSize(LinkedListNode list){
		if (list == null)
			return null;
		int size = 0;
		LinkedListNode current = list;
		while (current != null){
			size++;
			current = current.next;
		}
		Result resultTail = new Result (current, size);
		return resultTail;
	}
	
	public static LinkedListNode intersection (LinkedListNode l1, LinkedListNode l2){
		if (l1 == null || l2 == null)
			return null;
		Result result1 = getTailAndSize(l1);
		Result result2 = getTailAndSize(l2);
		if (result1.tail != result2.tail)
			return null;
		LinkedListNode shortList = result1.size >= result2.size ? l2 : l1;
		LinkedListNode longList = result1.size < result2.size ? l2 : l1;
		longList = getKthNode (longList, Math.abs(result1.size - result2.size));
		while (shortList != longList){
			longList = longList.next;
			shortList = shortList.next;
		}
		return longList;
	}
	//Assume the first element is the case of k = 1.
	public static LinkedListNode getKthNode (LinkedListNode list, int kth){
		LinkedListNode current = list;
		while (kth > 0 && list != null){
			current = current.next;
			kth--;
		}
		return current;
	}
	public static LinkedListNode insertAfter (LinkedListNode node, int data){
		LinkedListNode newNode = new LinkedListNode(data);
		node.next = newNode;
		return node;
	}
	public static LinkedListNode insertAfter1 (LinkedListNode node1, LinkedListNode node2){
		node1.next = node2;
		return node1;
	}
	
	public static void main (String args[]){
		LinkedListNode l1 = new LinkedListNode(3);
		LinkedListNode ptr = l1;
		insertAfter(ptr, 1);
		ptr = ptr.next;
		insertAfter(ptr, 5);
		ptr = ptr.next;
		LinkedListNode pointer = ptr;
		insertAfter(ptr, 9);
		ptr = ptr.next;insertAfter(ptr, 7);
		ptr = ptr.next;insertAfter(ptr, 2);
		ptr = ptr.next;insertAfter(ptr, 1);
		
		
		LinkedListNode l2 = new LinkedListNode(4);
		LinkedListNode ptr1 = l2;
		insertAfter1(ptr1, pointer);
		/*while (true){
			System.out.println(l1.data);
			l1 = l1.next;
			if (l1.next == null){
				System.out.println(l1.data);
				break;
			}
				
		}*/
		System.out.println(intersection(l1,l2).data);
	}
}
