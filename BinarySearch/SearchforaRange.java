// 34. Search for a Range   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 112872
// Total Submissions: 366722
// Difficulty: Medium
// Contributors: Admin
// Given a sorted array of integers, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].
//
// Subscribe to see which companies asked this question
//
// Show Tags
// Show Similar Problems
// Have you met this question in a real interview? Yes


public class SearchforaRange {
	/*
	 * Solution :Use binary search to find one of the match target, then find
	 * the where it starts and ends.
	 */
	public int[] searchRange(int[] nums, int target) {
		int i = Arrays.binarySearch(nums, target);
		if (i < 0)
			return new int[] { -1, -1 };
		int left, right;
		for (left = i; left >= 0; left--)
			if (nums[left] != target) {
				left++;
				break;
			}
		for (right = i; right < nums.length; right++)
			if (nums[right] != target) {
				right--;
				break;
			}
		return new int[] { left, right };

	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new SearchforaRange().searchRange(new int[] { 2, 2 }, 3)));

	}

}
