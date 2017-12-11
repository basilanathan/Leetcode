package bst;

/**
 * 
 * @author basila
 * 
 * Problem:
 * 108. Convert Sorted Array to Binary Search Tree
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
 * of the two subtrees of every node never differ by more than 1.
 * 
 * Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 *
 */

public class ArrayToBST {
	
	public TreeNode sortedArrayToBST(int[] num) {
		if(num.length == 0) return null;
		
		TreeNode head = insertNode(num, 0, num.length - 1);
		return head;
	}
	
	public TreeNode insertNode(int[] num, int low, int high) {
		if(low > high) return null;
		
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = insertNode(num, low, mid - 1);
		node.right = insertNode(num, mid + 1, high);
		return node;
	}

}
