package com.hm;

import java.util.ArrayList;
import java.util.List;
//229. Majority Element II
//        DescriptionHintsSubmissionsSolutions
//        Discuss   Editorial Solution Pick One
//        Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

/**
 * Created by houming on 17-6-24.
 */
public class MajorityElementII {
    /*
    Solution: 1.same idea as MajorityElement.
              2.we need to recheck the two elements again because if the element which is not more than n/3
              could remain when it is more than the left elements except it and the other major element.
     */

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorities = new ArrayList<>(2);
        if (nums == null || nums.length < 1)
            return majorities;
        int majority1 = 0, majority2 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 == 0 && num != majority2)
                majority1 = num;
            else if (count2 == 0)
                majority2 = num;

            if (num == majority1)
                count1++;
            else if (num == majority2)
                count2++;
            else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == majority1)
                count1++;
            if (num == majority2)
                count2++;
        }
        if (count1 > nums.length / 3)
            majorities.add(majority1);
        if (count2 > nums.length / 3 && majority1 != majority2)
            majorities.add(majority2);
        return majorities;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElementII().majorityElement(new int[]{1, 2, 2, 3, 2, 1, 1, 3}));
    }
}
