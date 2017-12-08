package stack;

import java.awt.List;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class PreorderTraversal {
	//iterative solution
	public List<Integer> preordertraversal(TreeNode root) {
		
		List<Integer> result = new LinkedList<>();
		Deque<TreeNode> stack = new LinkedList<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node != null) {
				result.add(node.val);
				stack.push(node.right);
				stack.push(node.left);
			}
		}
		
		return result;
	}
	
	//recursive solution
	//with Helper method to have a List as paramater, so we can modify the parameter and 
	//don't have to instantiate a new List at each recursive call:
	
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}
	
	public void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);
		preHelper(root.left,pre);
		preHelper(root.right,pre);
	}

}
