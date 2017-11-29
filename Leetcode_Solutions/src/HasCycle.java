/**
 * 
 * @author basila
 * @date 11/29/2017
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space? 0(1)
 * 
 * Use two pointers, walker and runner.
 * walker moves step by step. runner moves two steps at time.
 * if the Linked List has a cycle walker and runner will meet at some point.
 *
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
public class HasCycle {
	public boolean hasCycle(listNode head) {
		if(head == null) return false;
		ListNode walker = head;
		ListNode runner = head;
		
		while(runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			if(walker == runner) return true;
		}
		return false;
	}

}
