// 81. Search in Rotated Sorted Array II   QuestionEditorial Solution  My Submissions
// Total Accepted: 77828
// Total Submissions: 237353
// Difficulty: Medium
// Contributors: Admin
// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?
//
// Would this affect the run-time complexity? How and why?
//
// Write a function to determine if a given target is in the array.

public class SearchinRotatedSortedArrayII {

  /*
	 * Solution :Binary Search Theory
	 * 				Key1:Find the ordering part (lo - mid or mid - hi)
   *        Key2:when nums[lo] == nums[mid], target can be both side, so we reduce it by add one to lo
	 */

    public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi){
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] == target)
				return true;
			else if (nums[mid] < target){
			    if (nums[lo] == nums[mid])
			        lo++;
				else if(nums[lo] < nums[mid] || nums[lo] > target)
					lo = mid + 1;
				else
					hi = mid;
			} else {
			    if (nums[lo] == nums[mid])
			        lo++;
				else if (nums[lo] < nums[mid] && nums[lo] > target)
					lo = mid + 1;
				else
					hi = mid;
			}
		}
		return nums[lo] == target ;
	}
}
