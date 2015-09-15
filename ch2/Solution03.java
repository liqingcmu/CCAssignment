public static boolean deleteMiddleNode (LinkedListNode node){
		if (node == null || node.next == null){
			return false;
		}
		LinkedListNode nextNode = node;
		node.data = nextNode.data;
		node.next = nextNode.next;
		return true;
	}
