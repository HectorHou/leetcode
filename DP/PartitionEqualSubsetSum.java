//416. Partition Equal Subset Sum   QuestionEditorial Solution  My Submissions
//Total Accepted: 6758
//Total Submissions: 18398
//Difficulty: Medium
//Contributors: Admin
//Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//
//Note:
//Each of the array element will not exceed 100.
//The array size will not exceed 200.
//Example 1:
//
//Input: [1, 5, 11, 5]
//
//Output: true
//
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//Example 2:
//
//Input: [1, 2, 3, 5]
//
//Output: false
//
//Explanation: The array cannot be partitioned into equal sum subsets.

public class PartitionEqualSubsetSum {
	/*
	 * Solution: 1.Find the sum of each subarray
	 * 			   2.Use dp to find if there is some numbers in the mainarray add up to the sum
	 */

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if ((sum & 1) == 1)
			return false;
		sum >>= 1;

		boolean[] helper = new boolean[sum + 1];
		helper[0] = true;

		for (int i = 0; i < nums.length; i++) {
			// for (int j = nums[i]; j < sum + 1; j++) {
			// if (helper[j - nums[i]])
			// helper[j] = true;
			// }
			/*
			 * If we do that in ascending order, the previous operation will affect the next operation
			 */
			for (int j = sum; j >= nums[i]; j--) {
				if (helper[j - nums[i]])
					helper[j] = true;
			}
			if (helper[sum])
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PartitionEqualSubsetSum().canPartition(new int[] { 1, 2, 5, 100 }));
	}

}
