// 17. Letter Combinations of a Phone Number   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 114156
// Total Submissions: 357202
// Difficulty: Medium
// Contributors: Admin
// Given a digit string, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.



public class LetterCombinationsofaPhoneNumber {

	private String[] num = new String[] { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> res = new LinkedList<>();
		digits = digits.replaceAll("1", "").replaceAll("0", "");
		if (digits.length() != 0)
			helper(res, digits, new StringBuilder());
		return res;
	}

	private void helper(List<String> res, String digits, StringBuilder sb) {
		if (sb.length() == digits.length()) {
			res.add(new String(sb));
			return;
		}
		for (char c : num[Character.digit(digits.charAt(sb.length()), 10) - 2].toCharArray()) {
			sb.append(c);
			helper(res, digits, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

	}

	public static void main(String[] args) {
		System.out.println(new LetterCombinationsofaPhoneNumber().letterCombinations("10"));
	}

}
