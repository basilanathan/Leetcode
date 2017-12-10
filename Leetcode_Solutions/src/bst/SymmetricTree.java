package bst;

/**
 * 
 * @author basila
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *  1
   / \
  2   2
 / \ / \
3  4 4  3

returns true
 *
 */

public class SymmetricTree {
	//recursive solution
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isSymmetricHelper(root.left, root.right);
	}

	private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if(left == null && right == null) return true;
		if(left == null || right == null) return false;
		
		if(left.val == right.val) {
			return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
		} else
			return false;
	}
	

}
