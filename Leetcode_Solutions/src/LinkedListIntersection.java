
/**
 * 
 * @author basila
 * 
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class LinkedListIntersection {
    //without lenght
//  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//      //check
//      if(headA == null || headB == null) return null;
     
//      //head pointers
//      ListNode a = headA; 
//      ListNode b = headB;
     
     
//      while(a != b) {
//          //the shorter will reach null first
//          a = a == null ? headB : a.next;
//          b = b == null ? headA : b.next;
         
//      }
//      //when a = b return any
//      return a;
     
//  }
 
 //with length
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = length(headA), lenB = length(headB);
		// move headA and headB to the same start point
		while (lenA > lenB) {
			headA = headA.next;
			lenA--;
		}
		while (lenA < lenB) {
			headB = headB.next;
			lenB--;
		}
		// find the intersection until end
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int length(ListNode node) {
		int length = 0;
		while (node != null) {
			node = node.next;
			length++;
		}
		return length;
	}

}
