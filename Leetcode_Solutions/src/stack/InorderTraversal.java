package stack;

import java.util.List;
import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * 1) Create an empty stack S.
 * 2) Initialize current node as root
 * 3) Push the current node to S and set current = current->left until current is NULL
 * 4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
 * 5) If current is NULL and stack is empty then we are done.
 * 
 * Time: O(n)
 * Space: O(h)
 * 
 * The only space usage in your code comes from elements in your Stack<>. 
 * the size of Stack<> at any point is the depth of the current node(i.e., distance from the root), 
 * the space complexity of your algorithm is O(height). If you have a balanced binary tree, 
 * for example, O(height) could be as low as O(log V), where V is the number of vertices in your tree. 
 * In the worst case, O(height) = O(V).
 *
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class InorderTraversal {
	//iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode current = root;
        
        //this is especially if stack is not empty
        while(current != null || !stack.empty()) {
            //this for current is not null
            while(current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right; //right side of tree or subtree
        }
        return list;
    }
    
    //recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new LinkedList<Integer>();
        if(root!=null){
            inorder(result,root);
        }
        return result;
        
    }
    public void inorder(List<Integer> result,TreeNode cur){
        if(cur!=null){
            inorder(result,cur.left);
            result.add(cur.val);
            inorder(result,cur.right);
        }
    }

}
