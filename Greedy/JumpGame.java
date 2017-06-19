package com.hm;
//55. Jump Game
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 121671
//        Total Submissions: 413397
//        Difficulty: Medium
//        Contributor: LeetCode
//        Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Determine if you are able to reach the last index.
//
//        For example:
//        A = [2,3,1,1,4], return true.
//
//        A = [3,2,1,0,4], return false.
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Array Greedy

/**
 * Created by houming on 17-6-19.
 */
public class JumpGame {
    /*
    Solution: 1.use reachable to store the max index that we can reach from current position.
              2.reachable < current index means we cannot reach there anyway.
     */
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[]{
                2, 3, 1, 1, 4
        }));
    }

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i <= nums.length; i++) {
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
}
