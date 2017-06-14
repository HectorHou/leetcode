package com.hm;
//209. Minimum Size Subarray Sum
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 80807
//        Total Submissions: 268506
//        Difficulty: Medium
//        Contributor: LeetCode
//        Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//        For example, given the array [2,3,1,2,4,3] and s = 7,
//        the subarray [4,3] has the minimal length under the problem constraint.
//
//        click to show more practice.
//
//        Credits:
//        Special thanks to @Freezen for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Array Two Pointers Binary Search
//        Show Similar Problems

/**
 * Created by hm on 17-6-14.
 */
public class MinimumSizeSubarraySum {
    /*
    Solution: 1.the first point aim at the first number of contiguous sub array and the second point aim at the next
    number of contiguous sub array.
              2.when sum is smaller than s, move the second point
              3.when sum is greater than s, move the first point
     */
    public static void main(String[] args) {
        System.out.print(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{
                2, 3, 1, 2, 4, 3
        }));
    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int minSub = Integer.MAX_VALUE;
        int i = 0, j = 1, sum = nums[0];
        while (j < nums.length) {
            if (sum < s) {
                sum += nums[j++];
            } else {
                while (sum >= s)
                    sum -= nums[i++];
                minSub = (j - i + 1) < minSub ? j - i + 1 : minSub;
                if (minSub == 1)
                    return 1;
            }
        }
        if (sum >= s) {
            while (sum >= s)
                sum -= nums[i++];
            minSub = (j - i + 1) < minSub ? j - i + 1 : minSub;
        }
        if (minSub == Integer.MAX_VALUE)
            return 0;
        else
            return minSub;
    }
}
