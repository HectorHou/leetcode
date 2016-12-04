// 90. Subsets II   QuestionEditorial Solution  My Submissions
// Total Accepted: 87238
// Total Submissions: 262972
// Difficulty: Medium
// Contributors: Admin
// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
// Note: The solution set must not contain duplicate subsets.
//
// For example,
// If nums = [1,2,2], a solution is:
//
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

public class SubsetsII {
  /*
  *Solution : Prevent the duplicate subsets.
  *            We First sort the nums and for every iteration we only add the same numbers once.
  */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        helper(result, new LinkedList<Integer>(), nums, 0);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start){
        result.add(new ArrayList(list));
        for (int i = start; i < nums.length; i++){
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i++;
        }
    }
}
