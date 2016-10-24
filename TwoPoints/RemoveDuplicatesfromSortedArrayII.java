// 80. Remove Duplicates from Sorted Array II   QuestionEditorial Solution  My Submissions
// Total Accepted: 93060
// Total Submissions: 270865
// Difficulty: Medium
// Contributors: Admin
// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?
//
// For example,
// Given sorted array nums = [1,1,1,2,2,3],
//
// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

public class RemoveDuplicatesfromSortedArrayII {

  /*
  *Solution: add if current != current - 2
  */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int p1 = 2, p2 = 2;
        while (p1 < nums.length){
            if (nums[p1] != nums[p2 - 2]){
                nums[p2++] = nums[p1];
            }
            p1++;
        }
        return p2;
    }
}
