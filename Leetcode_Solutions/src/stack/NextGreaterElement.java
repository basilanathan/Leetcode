package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author basila
 * 
 * Time O(N) each element is pushed and popped at most once
 *
 */

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length > nums2.length) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<Integer>();
        for(int num : nums2) {
            while(!stack.isEmpty() && stack.peek() < num)
                map.put(stack.pop(), num);
            stack.push(num);
        }
        for(int i = 0; i < nums1.length; i++)
            nums1[i] = map.getOrDefault(nums1[i], -1);
        return nums1;
    }
}
