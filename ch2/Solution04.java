public class Solution04 {
   public static ListNode partition (ListNode head, int val){
		if (head == null || head.next == null)
			return head;
		ListNode smallNum = new ListNode(-1);
		ListNode headSmall = smallNum;
		ListNode bigNum = new ListNode(-1);
		ListNode headBig = bigNum;
		while(head != null){
			if (head.val >= val){
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
