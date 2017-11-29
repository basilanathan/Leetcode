class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null) {
			return null;
		}
		
		ListNode newHead = new ListNode(-1); //dummy
		newHead.next = head;
		ListNode temp = newHead;
		
		ListNode one = null;
		ListNode two = null;
		
		while(temp.next != null && temp.next.next != null) {
			one = temp.next;
			two = temp.next.next;
			
			one.next = two.next;
			two.next = one;
			temp.next = two;
			
			temp = one;
		}
		return newHead.next;
	}

}
