// 47. Permutations II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 98459
// Total Submissions: 319788
// Difficulty: Medium
// Contributors: Admin
// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]
// Subscribe to see which companies asked this question



public class PermutationsII {
	/*
	 * Solution:Ues a boolean array to store if the num is visited.
	 * If the current num is visited, then we don't add it to the list.
	 * To avoid duplicate, we don't add the num that equals with the
	 * last num and last wasn't visited, because if the two lists only have
	 * difference between these two nums ,then the two lists are the same.
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new LinkedList<>();
		boolean[] visited = new boolean[nums.length];
		Arrays.sort(nums);
		List<Integer> list = new LinkedList<>();
		helper(res, list, nums, visited);
		return res;

	}

	private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] visited) {
		if (list.size() == nums.length) {
			res.add(new LinkedList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (visited[i] == true)
				continue;
			if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)
				continue;
			list.add(nums[i]);
			visited[i] = true;
			helper(res, list, nums, visited);
			visited[i] = false;
			((LinkedList<Integer>) list).removeLast();
		}
	}

	public static void main(String[] args) {
		System.out.println(new PermutationsII().permuteUnique(new int[] { 1, 1, 2 }));

	}

}
