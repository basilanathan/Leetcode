/**
 * 
 * @author basila
 * 
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Remove_Linked_List_Elements {
	//iterative solution with fake head
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode curr = head, prev = fakeHead;
		while(curr != null) {
			if(curr.val == val) {
				prev.next = curr.next;
			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}
		return fakeHead.next;
	}
	
	//recursive solution
	public ListNode removeElementsRecur(ListNode head, int val) {
		if(head == null) return null;
		head.next = removeElementsRecur(head.next, val);
		return head.val == val ? head.next : head;
	}

}
