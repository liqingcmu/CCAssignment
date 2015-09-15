public class LinkedListNode {  
	    public int data;  
	    public LinkedListNode next;  

	    public LinkedListNode(int data) {  
	        this.data = data;    
	    }  
	}
	/*The method removeDup takes O(n) time.*/
	public static void removeDup (LinkedListNode node){
		LinkedListNode previous = null;
		HashSet<Integer> word = new HashSet<Integer>();
		while (node != null){
			if (! word.contains(node.data)){
				word.add(node.data);
				previous = node;
			}
			else{
				previous.next = node.next;
			}
			node = node.next;
		}
	}
	/*The method removeDup1 takes O(n^2) time, even though takes O(1) space.*/
	public static void removeDup1 (LinkedListNode node){
		LinkedListNode ptr1 = node;
		while (ptr1 != null){
			LinkedListNode ptr2 = ptr1;
			while (ptr2.next != null){
				if (ptr1.data == ptr2.next.data){
					ptr2.next = ptr2.next.next;
				}
				else{
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
	}
