package strings;

/**
 * 
 * @author basila
 * 
 * Time O(N^2)
 * Space O(1)
 *
 */

public class LPS {
	
	//G E E K E G
	private static int lo;
	private static int maxLength;
	
	public static String longestPalindrome(String s) {
		int len = s.length();
		if (len < 2) return s;
		
		for(int i = 0; i < len - 1; i++) {
			extendPalindrome(s, i, i); //odd number -> one character for middle
			extendPalindrome(s, i, i + 1); //even number -> two characters for middle
		}
		return s.substring(lo, lo + maxLength);
	}

	private static void extendPalindrome(String s, int j, int k) {
		
		while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
			j--;
			k++;
		}
		if (maxLength < k - j - 1) {
			lo = j + 1;
			maxLength = k - j - 1;
		}
	}
	
	public static void main(String[] args) {
		String test1 = longestPalindrome("geekeg");
		String test2 = longestPalindrome("xxxbcbxxxxxa");
		System.out.println(test1);
		System.out.println(test2);
	}

}
