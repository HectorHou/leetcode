//467. Unique Substrings in Wraparound String   Add to List QuestionEditorial Solution  My Submissions
//Total Accepted: 3140
//Total Submissions: 10231
//Difficulty: Medium
//Contributors: ramanjot
//Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
//
//Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.
//
//Note: p consists of only lowercase English letters and the size of p might be over 10000.
//
//Example 1:
//Input: "a"
//Output: 1
//
//Explanation: Only the substring "a" of string "a" is in the string s.
//Example 2:
//Input: "cac"
//Output: 2
//Explanation: There are two substrings "a", "c" of string "cac" in the string s.
//Example 3:
//Input: "zab"
//Output: 6
//Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
//Subscribe to see which companies asked this question
public class UniqueSubstringsinWraparoundString {
	/*
	 * Solution:
	 * We count the max length of the each available string when it ends with 'a' - 'z'
	 * Because that is the number of the solution strings that ends with the last character. 
	 */
	public int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0)
			return 0;
		
		int sum = 0;
		int[] count = new int[26];
		
		count[p.charAt(0) - 'a'] = 1;
		
		int maxLength = 1;
		for (int i = 1; i < p.length(); i++) {
			if (isNext(p.charAt(i - 1), p.charAt(i)))
				maxLength++;
			else
				maxLength = 1;
			count[p.charAt(i) - 'a'] = Math.max(count[p.charAt(i) - 'a'], maxLength);
		}
		
		for (int i = 0; i < 26; i++)
			sum += count[i];
		
		return sum;

	}

	private boolean isNext(char c1, char c2) {
		if (c1 + 1 == c2 || c1 == 'z' && c2 == 'a')
			return true;
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new UniqueSubstringsinWraparoundString().findSubstringInWraproundString("cac"));

	}

}

