package com.hm;
//330. Patching Array
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 21169
//        Total Submissions: 66604
//        Difficulty: Hard
//        Contributor: LeetCode
//        Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
//
//        Example 1:
//        nums = [1, 3], n = 6
//        Return 1.
//
//        Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
//        Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
//        Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
//        So we only need 1 patch.
//
//        Example 2:
//        nums = [1, 5, 10], n = 20
//        Return 2.
//        The two patches can be [2, 4].
//
//        Example 3:
//        nums = [1, 2, 2], n = 5
//        Return 0.
//        Credits:
//        Special thanks to @dietpepsi for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Greedy

/**
 * Created by hm on 17-6-9.
 */
public class PatchingArray {
    /*
    Solution: 1.use firstMissNum to store the fist nunber that we current can not arrive.
              2.if the current number in array is bigger than firstMissNum, it means that we can't arrive
              it only if we add it to the array which add one to count and then the number we can arrive
              extend to the number we can arrive add to firstMissNum
              3.else firstMissNum because it add to the current number in the array.
     */
    public static void main(String[] args) {
        System.out.print(new PatchingArray().minPatches(new int[]{1, 5, 10}, 20));
    }

    public int minPatches(int[] nums, int n) {
        int i = 0, count = 0;
        long firstMissNum = 1;
        while (firstMissNum <= n) {
            if (i < nums.length && nums[i] <= firstMissNum) {
                firstMissNum += nums[i++];
            } else {
                count++;
                firstMissNum += firstMissNum;
            }
        }
        return count;
    }
}
