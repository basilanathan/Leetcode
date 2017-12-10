package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthBinaryTree {
	//recursive solution
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		
		int lDepth = maxDepth(root.left);
		int rDepth = maxDepth(root.right);
		
		return Math.max(lDepth, rDepth) + 1;
	}
	
	//iterative DFS
	public int maxDepthDfs(TreeNode root) {
		if(root == null) return 0;
		
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		stack.push(root);
		value.push(1);
		int max = 0;
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int temp = value.pop();
			max = Math.max(temp, max);
			if (node.left != null) {
				stack.push(node.left);
				value.push(temp + 1);
			}
			if (node.right != null) {
				stack.push(node.right);
				value.push(temp + 1);
			}
		}
		return max;
	}
	
	//iterative BFS
	public int maxDepthBFS(TreeNode root) {
	    if(root == null) {
	        return 0;
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    int count = 0;
	    while(!queue.isEmpty()) {
	        int size = queue.size();
	        while(size-- > 0) {
	            TreeNode node = queue.poll();
	            if(node.left != null) {
	                queue.offer(node.left);
	            }
	            if(node.right != null) {
	                queue.offer(node.right);
	            }
	        }
	        count++;
	    }
	    return count;
	}
	
}
