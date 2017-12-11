package bst;

/**
 * 
 * @author basila
 * 
 * 110. Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the 
 * depth of the two subtrees of every node never differ by more than 1.
 *
 */

public class BalancedBinaryTree {
	//For the current node root, calling depth() for its left and right children actually has to 
	//access all of its children, thus the complexity is O(N). We do this for each node in the tree, 
	//so the overall complexity of isBalanced will be O(N^2). This is a top down approach.
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		int left = Heigth(root.left);
		int right = Heigth(root.right);
		
		return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	
	public int Heigth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(Heigth(root.left), Heigth(root.right)) + 1;
	}
	
	//DFS solution
	//Instead of calling depth() explicitly for each child node, we return the height of the current 
	//node in DFS recursion. When the sub tree of the current node (inclusive) is balanced, 
	//the function dfsHeight() returns a non-negative value as the height. Otherwise -1 is returned. 
	//According to the leftHeight and rightHeight of the two children, the parent node could check if 
	//the sub tree is balanced, and decides its return value.
	public boolean isBalancedDFS(TreeNode root) {
	    if (root == null) return true;
	    return dfsHeight(root) != -1;
	}

	public int dfsHeight(TreeNode root) {
	    if (root == null)
	        return 0;
	    int leftHeight = dfsHeight(root.left);
	    if (leftHeight == -1) return -1;
	    int rightHeight = dfsHeight(root.right);
	    if (rightHeight == -1) return -1;
	    if (Math.abs(leftHeight - rightHeight) > 1)
	        return -1;
	    return Math.max(dfsHeight(root.left), dfsHeight(root.right)) + 1;
	}
}
