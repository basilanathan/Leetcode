package stack;

/**
 * 
 * @author basila
 * 
 * Serialization is the process of converting a data structure or object into a sequence of 
 * bits so that it can be stored in a file or memory buffer, or transmitted across a network 
 * connection link to be “resurrected” later in the same or another computer environment.
 * 
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 *
 */

public class PreorderSerialization {
	public boolean isValidSerialization(String preorder) {
		String[] strs = preorder.split(",");
		int degree = -1; //root had no indegree compensate with -1
		for(String str : strs) {
			degree++; // all nodes have 1 indegree (root compensated)
			if (degree > 0) { // total degree should never exceeds 0
				return false;
			}
			if (!str.equals("#")) { // only non-leaf node has 2 outdegree
				degree -= 2;
			}
		}
		return degree == 0;
	}

}
