// 78. Subsets   QuestionEditorial Solution  My Submissions
// Total Accepted: 126242
// Total Submissions: 354955
// Difficulty: Medium
// Contributors: Admin
// Given a set of distinct integers, nums, return all possible subsets.
//
// Note: The solution set must not contain duplicate subsets.
//
// For example,
// If nums = [1,2,3], a solution is:
//
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

public class subsets {
  /*
  *Solution : Backtracking
  */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(result, list, nums, 0);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start){
        result.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
