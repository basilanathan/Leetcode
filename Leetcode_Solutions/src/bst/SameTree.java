package bst;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author basila
 * 
 * Problem:
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the 
 * nodes have the same value.
 * 
 * Input:
 *         1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

 * Output: true
 *
 */

public class SameTree {
	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null || q == null) return false;
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}
	
	//without recursion BFS
	public static boolean isSameTreeDequeue(TreeNode p, TreeNode q) {
		Deque<TreeNode> queue = new LinkedList<>();
		queue.addLast(p);
		queue.add(q);
		while(!queue.isEmpty()) {
			p = queue.removeFirst();
			q = queue.removeFirst();
			
			if (p == null && q == null) {
				continue;
			} else if(p == null || q == null || p.val != q.val) {
				return false;
			} else {
				queue.addLast(p.left);
                queue.addLast(q.left);
                queue.addLast(p.right);
                queue.addLast(q.right);
			}
		}
		return true;
	}
}
