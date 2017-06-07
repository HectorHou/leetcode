package com.hm;

import java.util.Arrays;
//473. Matchsticks to Square
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 7867
//        Total Submissions: 22806
//        Difficulty: Medium
//        Contributors:
//        weezer
//        Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
//
//        Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
//
//        Example 1:
//        Input: [1,1,2,2,2]
//        Output: true
//
//        Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
//        Example 2:
//        Input: [3,3,3,3,4]
//        Output: false
//
//        Explanation: You cannot find a way to form a square with all the matchsticks.
//        Note:
//        The length sum of the given matchsticks is in the range of 0 to 10^9.
//        The length of the given matchstick array will not exceed 15.
//        Subscribe to see which companies asked this question.
/**
 * Created by hm on 17-6-7.
 */
public class MatchsticksToSquare {
    /*
    Solution : 1.return false if the sum of the arrays can't divide by 4.
               2.use dfs to find the solution
               3.add num from the big one where it will return fast than from the small one.
     */
    public static void main(String[] args) {

    }

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 4 != 0)
            return false;

        Arrays.sort(nums);

        return dfs(nums, new int[4], nums.length - 1, sum / 4);
    }

    private boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == -1){
            for (int sum : sums)
                if (sum != target)
                    return false;
            return true;
        }else{
            for (int i = 0; i < 4; i++){
                if (sums[i] + nums[index] > target)
                    continue;
                sums[i] += nums[index];
                if (dfs(nums,sums,index -1, target))
                    return true;
                sums[i] -= nums[index];
            }
            return false;
        }
    }
}
