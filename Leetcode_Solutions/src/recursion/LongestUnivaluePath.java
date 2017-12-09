package recursion;

/**
 * 
 * @author basila
 * 
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 *https://leetcode.com/problems/longest-univalue-path/description/
 *
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class LongestUnivaluePath {
	
    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        int l = node.left != null ? dfs(node.left, res) : 0;
        int r = node.right != null ? dfs(node.right, res) : 0;
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
        res[0] = Math.max(res[0], resl + resr);
        return Math.max(resl, resr);
    }

}

class Solution {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        help(root);
        return res;
    }
    public void help(TreeNode root) {
        if(root == null) return;
        int temp = count(root.left,root.val)+count(root.right,root.val);
        res = Math.max(res,temp);
        help(root.left);
        help(root.right);
    }
    public int count(TreeNode root,int val) {
        if(root == null || root.val != val) return 0;
        int left = count(root.left,val) + 1;
        int right = count(root.right,val) + 1;
        
        return Math.max(left,right);                                                  
    }
}
