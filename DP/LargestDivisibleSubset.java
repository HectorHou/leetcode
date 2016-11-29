// 368. Largest Divisible Subset   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 15337
// Total Submissions: 46967
// Difficulty: Medium
// Contributors: Admin
// Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
//
// If there are multiple solutions, return any subset is fine.
//
// Example 1:
//
// nums: [1,2,3]
//
// Result: [1,2] (of course, [1,3] will also be ok)
// Example 2:
//
// nums: [1,2,4,8]
//
// Result: [1,2,4,8]
// Credits:
// Special thanks to @Stomach_ache for adding this problem and creating all test cases.
//
// Subscribe to see which companies asked this question
public class LargestDivisibleSubset {
	/*
	 * Solution: Use DP thought. 1.Set count[i] to record the length of list
	 * while using nums[i] as the tail of the list and parent[i] to record the
	 * front element of nums[i]'s index 2.When we get a new element, we set the
	 * count[curr] the maximum of (count[j] + 1) while (nums[curr] % nums[j] ==
	 * 0) and set parent[curr] j 3.For not scanning the count[] again, we also
	 * set maxIndex and max to record them. 4.Finally we just recover the list
	 * by maxIndex and nums[]
	 */

	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new LinkedList<>();

		if (nums.length == 0)
			return res;

		int[] count = new int[nums.length];
		int[] parent = new int[nums.length];

		Arrays.sort(nums);

		count[0] = 1;
		parent[0] = -1;

		int maxIndex = 0;
		int max = 0;

		for (int i = 1; i < nums.length; i++) {
			int maxCount = 1;
			int currParent = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (maxCount < count[j] + 1) {
						maxCount = count[j] + 1;
						currParent = j;
					}
				}
			}
			count[i] = maxCount;
			parent[i] = currParent;
			if (count[i] > max) {
				max = count[i];
				maxIndex = i;
			}

		}

		for (int i = maxIndex; i != -1; i = parent[i]) {
			res.add(0, nums[i]);
		}

		return res;

	}

	public static void main(String[] args) {
		System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[] { 1, 2, 4, 8 }));

	}

}
