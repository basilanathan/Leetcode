package bst;

/**
 * 
 * @author basila
 * 
 * Problem:
 * Given a binary search tree with non-negative values, find the minimum absolute difference between 
 * values of any two nodes.
 * 
 * The idea is that the minimum absolute difference will only be between two consecutive 
 * nodes in an inorder traversal, because doing an inorder traversal on a BST gives a 
 * sorted list of elements.
 * 
 * So, we maintain one variable for the previously seen value, and another variable for the 
 * minimum difference seen so far, and update them accordingly. the variable prev starts with the 
 * value -1, and min starts with INT_MAX, which is updated when a new lower minimum is found. 
 * prev is updated when we see the first leaf (because that will be the first element visited 
 * during an inorder traversal.
 * 
 * Time; O(N)
 * Space: O(1)
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MinimumAbsoluteDifference {
	
	int prev = -1;
	int min = Integer.MAX_VALUE;
	
	public int getMinimumDifference(TreeNode root) {
		getMinDifference(root);
		return min;
	}
	
	public void getMinDifference(TreeNode root) {
		if (root == null) return;
		
		getMinDifference(root.left);
		
		int diff;
		
		if (prev == -1) {
			prev = root.val;
		} else {
			diff = (root.val - prev);
			if(min > diff)
			min = diff;
			prev = root.val;
		}
		
		getMinDifference(root.right);
	}
	
//    int min = Integer.MAX_VALUE;
//    Integer prev = null;
//    
//    public int getMinimumDifference(TreeNode root) {
//        if (root == null) return min;
//        
//        getMinimumDifference(root.left);
//        
//        if (prev != null) {
//            min = Math.min(min, root.val - prev);
//        }
//        prev = root.val;
//        
//        getMinimumDifference(root.right);
//        
//        return min;
//    }

}
