// 131. Palindrome Partitioning   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 82490
// Total Submissions: 269646
// Difficulty: Medium
// Contributors: Admin
// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
//
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]
// Subscribe to see which companies asked this question


public class PalindromePartitioning {
	/*
	 * Solution:Use Backtracing thought.
	 * Every time we check if the current string's substring which starts from the head and length
	 * between 1 and string's length is a palindrome. If so, then we add it to the list and remain
	 * the left substring as an parameter.
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> res = new LinkedList<>();
		if (s == null || s == "")
			return res;
		helper(res, new LinkedList<String>(), s);
		return res;
	}

	private void helper(List<List<String>> res, LinkedList<String> list, String s) {
		if (s.length() == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		for (int i = 1; i <= s.length(); i++) {
			if (isPalindrome(s.substring(0, i))) {
				list.add(s.substring(0, i));
				helper(res, list, s.substring(i, s.length()));
				list.removeLast();
			}
		}

	}

	private boolean isPalindrome(String string) {
		int length = string.length();
		for (int i = 0; i < length / 2; i++)
			if (string.charAt(i) != string.charAt(length - 1 - i))
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().partition("efefe"));

	}

}
