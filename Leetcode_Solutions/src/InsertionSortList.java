class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
public class InsertionSortList {
	//first solution
    public ListNode insertionSortList(ListNode head) {
        if(head == null ) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null) {
            next = current.next;
            while(pre.next != null && pre.next.val < current.val) {
                pre = pre.next;
            }
            //insert between pre and pre.next
            current.next = pre.next;
            pre.next = current;
            pre = dummy;
            current = next;
            
        }
        return dummy.next;
        
    }
    //second solution
	public ListNode insertionSortList(ListNode head) {
 
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		ListNode temp= null;

		while (head != null) {
     //ListNode temp = head.next;
			temp = head.next;
 
 /* Before insert, the prev is at the last node of the sorted list.
    Only the last node's value is larger than the current inserting node 
    should we move the temp back to the head*/
			if (prev.val >= head.val) prev = dummy;

			while (prev.next != null && prev.next.val < head.val) {
				prev = prev.next;
			}
 
			head.next = prev.next;
			prev.next = head;
 // prev = dummy; // Don't set prev to the head of the list after insert
			head = temp;
		}
		return dummy.next;
	}

}
