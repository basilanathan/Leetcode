import java.util.HashMap;
import java.util.Map;

public class Solution_3 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null && s.length() == 0) return 0;
		if(s.length() == 1) return 1;
		int result = 0, begin = 0;
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); i++) {
			if(m.containsKey(s.charAt(i))) {
				begin = Math.max(begin, m.get(s.charAt(i)) + 1 ); //if it exists move the start to the index after
				
			}
			
			m.put(s.charAt(i), i);
			result = Math.max(result, i + 1 - begin);
		
		}
		return result;

	}
}
