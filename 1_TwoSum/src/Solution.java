/**
 * Time : O(N) ; Space: O(N) : Each look up in the table costs only O(1) time.
 * @tag : Array; Hash Table
 * @by  : Basila Nathan
 * @date: 11/21/17
 ***************************************************************************
 * Description:
 * Given an array of integers, find two numbers such that they add up to 
 * a specific target number. 
 * The function twoSum should return indices of the two numbers such that 
 * they add up to the target, where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not 
 * zero-based. 
 * 
 * You may assume that each input would have exactly one solution. 
 * Input: numbers={2, 7, 11, 15}, target=9 
 * Output: index1=1, index2=2
 * 
 ***************************************************************************
 * {@link https://leetcode.com/problems/two-sum/solution/ }
 */

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
