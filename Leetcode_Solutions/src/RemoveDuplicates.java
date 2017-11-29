

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class RemoveDuplicates {
	//iterative solution
	public ListNode deleteDuplicates(ListNode head) {
		ListNode currentNode = head;
		
		while(currentNode != null && currentNode.next != null) {
			if(currentNode.val == currentNode.next.val) {
				currentNode.next = currentNode.next.next;
			} else {
				currentNode = currentNode.next;
			}
		}
		return head;
	}
	
	//recursive solution
	public ListNode deleteDuplicates_Recur(ListNode head) {
		if(head == null && head.next == null) return head;
		head.next = deleteDuplicates_Recur(head.next);
		return head.val = head.next.val ? head.next : head;
	}

}
