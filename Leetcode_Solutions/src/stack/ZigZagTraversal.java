package stack;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class ZigZagTraversal {
	
	//iterative solution
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) return new ArrayList<>();
		List<List<Integer>> result = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		
		boolean zigzag = false;
		
		while(!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int count = queue.size();
			
			for(int i = 0; i < count; i++) {
				TreeNode node = queue.poll();
				if (zigzag) {
					level.add(0, node.val);
				} else {
					level.add(node.val);
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(level);
			zigzag = !zigzag;
		}
	}
	
	//recursive solution
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
            
        helper(root, list, 0);
        
        return list;
    }
    
    public void helper(TreeNode root, List<List<Integer>> list, int level) {
        
        if(root == null) return;
        
        if(list.size() <= level) {
            list.add(level, new LinkedList<Integer>());
        }
        
        if(level%2==0) list.get(level).add(root.val);
        else list.get(level).add(0,root.val);
        
        helper(root.left, list, level+1);
        helper(root.right, list, level+1);
    }
	

}
