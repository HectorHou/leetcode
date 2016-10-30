// 395. Longest Substring with At Least K Repeating Characters   QuestionEditorial Solution  My Submissions
// Total Accepted: 5728
// Total Submissions: 16709
// Difficulty: Medium
// Contributors: Admin
// Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.
//
// Example 1:
//
// Input:
// s = "aaabb", k = 3
//
// Output:
// 3
//
// The longest substring is "aaa", as 'a' is repeated 3 times.
// Example 2:
//
// Input:
// s = "ababbc", k = 2
//
// Output:
// 5
//
// The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.


public class LongestSubstringwithAtLeastKRepeatingCharacters {

	/*
	 * Solution: suppose the length of substring is just the length of the
	 * string get the character that not feasible ( count (c) < k) then get any
	 * index of the charater divide it into 2 string that maybe contains the
	 * substring
	 */
	public int longestSubstring(String s, int k) {
		char[] cs = s.toCharArray();
		return helper(cs, 0, cs.length - 1, k);
	}

	private int helper(char[] cs, int i, int j, int k) {
		if (i > j || j - i + 1 < k)
			return 0;

		Map<Character, Set<Integer>> map = new HashMap<>();

		for (int x = i; x <= j; x++) {
			if (!map.containsKey(cs[x])) {
				map.put(cs[x], new HashSet<Integer>());
			}
			map.get(cs[x]).add(x);
		}
		Iterator<Map.Entry<Character, Set<Integer>>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Set<Integer> set = iterator.next().getValue();
			if (set.size() < k) {
				int value = set.iterator().next();
				return Math.max(helper(cs, i, value - 1, k), helper(cs, value + 1, j, k));
			}
		}

		return j - i + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestSubstringwithAtLeastKRepeatingCharacters().longestSubstring("ababbc", 2));
	}

}
