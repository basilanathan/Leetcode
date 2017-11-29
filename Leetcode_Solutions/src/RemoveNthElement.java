/**
 * 
 * @author basila
 * 
 * Time complexity : O(L). The algorithm makes one traversal of the list of LL nodes. Therefore time complexity is O(L)O(L).
 * Space complexity : O(1). We only used constant extra space.
 *
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class RemoveNthElement {
	//first Approach
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
    
    //second approach
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode headNode = new ListNode(9527);
        headNode.next = head;
        ListNode fastNode = headNode;
        ListNode slowNode = headNode;
        while(fastNode.next != null){
        	if(n <= 0){
        	    slowNode = slowNode.next;
        	} else {
        	    n--;
        	}
        	fastNode = fastNode.next;
        }
        if(slowNode.next != null)
        	slowNode.next = slowNode.next.next;
        return headNode.next;
    }

}
