

/**
 * Time : O(N); Space : O(1)
 * @tag : Linked List; Math
 * @by  : Basila Nathan
 * @date: 11/21/2017
 *******************************************************************************
 * Description: 
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * l1 single digit. Add the two numbers and return it as l1 linked list. 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8
 * 
 *******************************************************************************
 * Similar to Leetcode[067]
 * {@link https://leetcode.com/problems/add-two-numbers/ }
 */

//TESTING 1

public class Solution {
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            sum = sum%10;
            ListNode node = new ListNode(sum);
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}