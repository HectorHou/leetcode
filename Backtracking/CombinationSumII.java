// 40. Combination Sum II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 93968
// Total Submissions: 303365
// Difficulty: Medium
// Contributors: Admin
// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used once in the combination.
//
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]

public class CombinationSumII {
	/*
	 * Solution: Backing Tracing Problem. Because the array has duplicates and
	 * we don't want that. So first we sort the array. Eath time we scan the
	 * array we start from the index last time use and we don't use the same
	 * integer at the same position that means we can't just add an element
	 * which we just remove.
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new LinkedList<>();
		if (candidates == null || candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		helper(res, new LinkedList<Integer>(), candidates, target, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, LinkedList<Integer> list, int[] candidates, int target, int i) {
		if (target == 0) {
			res.add(new LinkedList<>(list));
			return;
		}
		for (int j = i; j < candidates.length; j++) {
			if (candidates[j] > target || (j > i && candidates[j] == candidates[j - 1]))
				continue;
			list.add(candidates[j]);
			helper(res, list, candidates, target - candidates[j], j + 1);
			list.removeLast();
		}

	}

	public static void main(String[] args) {
		System.out.println(new CombinationSumII().combinationSum2(new int[] { 3, 1, 3, 5, 1, 1 }, 8));
	}
}
