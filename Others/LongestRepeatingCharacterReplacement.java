package leetcode;

import java.util.Arrays;

//424. Longest Repeating Character Replacement   QuestionEditorial Solution  My Submissions
//Total Accepted: 1215
//Total Submissions: 3475
//Difficulty: Medium
//Contributors: Admin
//Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
//
//Note:
//Both the string's length and k will not exceed 104.
//
//Example 1:
//
//Input:
//s = "ABAB", k = 2
//
//Output:
//4
//
//Explanation:
//Replace the two 'A's with two 'B's or vice versa.
//Example 2:
//
//Input:
//s = "AABABBA", k = 1
//
//Output:
//4
//
//Explanation:
//Replace the one 'A' in the middle with 'B' and form "AABBBBA".
//The substring "BBBB" has the longest repeating letters, which is 4.

public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int maxLength = 0;
		int[] nums = new int[26];
		for (int i = 0; i < s.length() - maxLength; i++) {
			int j = i, count = 0, maxNum = 0;
			Arrays.fill(nums, 0);
			while (j < s.length()) {
				count++;
				if (++nums[s.charAt(j) - 'A'] > maxNum)
					maxNum = nums[s.charAt(j) - 'A'];
				if (maxNum + k < count) {
					maxLength = (maxLength > count - 1) ? maxLength : count - 1;
					break;
				}
				j++;
			}
			if (j == s.length())
				maxLength = (maxLength > count) ? maxLength : count;
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA", 3));
	}
}
