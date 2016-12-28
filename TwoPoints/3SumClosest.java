// 16. 3Sum Closest   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 106555
// Total Submissions: 349579
// Difficulty: Medium
// Contributors: Admin
// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
// Subscribe to see which companies asked this question


public class 3SumClosest {
    /*
    *solution:First sort nums.
    *Assume the middle num is from index 1 - nums.length-2.
    *Use two points idea from the both sides of nums to approach.
    */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        int left, right, sum;
        for (int mid = 1; mid < nums.length - 1; mid++){
            left = 0;
            right = nums.length - 1;
            while (left < mid && right > mid){
                sum = nums[left] + nums[mid] + nums[right];
                if (sum == target)
                    return target;
                else if (sum > target)
                    right--;
                else
                    left++;
                closestNum = (Math.abs(target - sum) > Math.abs(closestNum - target)) ?
                    closestNum : sum;
            }
        }
        return closestNum;
    }
}
