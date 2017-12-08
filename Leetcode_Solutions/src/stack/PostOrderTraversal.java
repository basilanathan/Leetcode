package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

//push N in stack -> push left tree of N in stack -> pop left tree of N -> push right tree of N in stack -> pop right tree of N -> pop N--------
public class PostOrderTraversal {
	//iterative solution
	public List<Integer> postorderTraversal(TreeNode root) {
		
		Deque<TreeNode> traversal = new LinkedList<>();
		List<Integer> result = new LinkedList<>();
		
		if(root == null) return result;
		
		traversal.push(root);
		
		while(!traversal.isEmpty()) {
			TreeNode node = traversal.pop();
			result.add(0, node.val); //adding back to front
			
			if (node.left != null) {
				traversal.push(node.left);
			}
			if (node.right != null) {
				traversal.push(node.right);
			}
		}
		return result;
	}
	
	//recursive solution
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(res, root);
        return res;
    }
    public void helper(List<Integer> list, TreeNode root){
        if(root == null)    return;
        helper(list, root.left);
        helper(list, root.right);
        list.add(root.val);
    }

}
