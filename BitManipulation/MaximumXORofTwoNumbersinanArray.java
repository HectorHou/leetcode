// 421. Maximum XOR of Two Numbers in an Array   QuestionEditorial Solution  My Submissions
// Total Accepted: 2638
// Total Submissions: 7602
// Difficulty: Medium
// Contributors: shen5630
// Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
//
// Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
//
// Could you do this in O(n) runtime?
//
// Example:
//
// Input: [3, 10, 5, 25, 2, 8]
//
// Output: 28
//
// Explanation: The maximum result is 5 ^ 25 = 28.


public class MaximumXORofTwoNumbersinanArray {
	/*
	 * Solution:Build the answer bit by bit from left to right.
	 * If we know the nth bit how to get the (n+1)th bit?
	 * We just suppose it to be 1, then check if a ^ trie belongs to the set.
	 * Because a ^ b = c => a ^ c = b.
	 */

	public int findMaximumXOR(int[] nums) {
		int max = 0, helper = 0;

		for (int i = 30; i >= 0; i--) {
			helper |= (1 << i);
			Set<Integer> set = new HashSet<>();
			for (int num : nums) {
				set.add(num & helper);
			}

			int trie = max | (1 << i);
			for (int num : set) {
				if (set.contains(trie ^ num)) {
					max = trie;
					break;
				}
			}
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new MaximumXORofTwoNumbersinanArray().findMaximumXOR(new int[] { 3, 10, 5, 25, 2, 8 }));

	}

}
