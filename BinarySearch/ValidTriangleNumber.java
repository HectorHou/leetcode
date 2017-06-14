package com.hm;

import java.util.Arrays;
//611. Valid Triangle Number
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 2106
//        Total Submissions: 6574
//        Difficulty: Medium
//        Contributors:
//        fallcreek
//        Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
//
//        Example 1:
//        Input: [2,2,3,4]
//        Output: 3
//        Explanation:
//        Valid combinations are:
//        2,3,4 (using the first 2)
//        2,3,4 (using the second 2)
//        2,2,3
//        Note:
//        The length of the given array won't exceed 1000.
//        The integers in the given array are in the range of [0, 1000].
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Array
//        Show Similar Problems

/**
 * Created by hm on 17-6-14.
 */
public class ValidTriangleNumber {
    /*
    Solution: 1.sort the array
              2.think nums[i] and nums[j] as the two smaller edges of the triangle and use binary search to
              find the largest edge's index or the index where it should be put.
              3.when there are many equal numbers, we need the right number when use binary search.
     */
    public static void main(String[] args) {
        System.out.print(new ValidTriangleNumber().triangleNumber(new int[]{
                2, 2, 3, 4
        }));
    }

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3)
            return 0;

        int count = 0;
        Arrays.sort(nums);
        int x = 0;
        while (x < nums.length && nums[x] == 0)
            x++;
        for (int i = x; i < nums.length - 2; i++)
            for (int j = i + 1; j < nums.length - 1; j++) {
                int max = nums[i] + nums[j] - 1;
                int index = Arrays.binarySearch(nums, max);
                if (index < 0) {
                    count += -index - j - 2;
                } else {
                    while (index + 1 < nums.length && nums[index + 1] == nums[index])
                        index++;
                    count += index - j;
                }
            }

        return count;
    }
}
