package com.hm;
//169. Majority Element
//        DescriptionHintsSubmissionsSolutions
//        Discuss   Editorial Solution Pick One
//        Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
//        You may assume that the array is non-empty and the majority element always exist in the array.
/**
 * Created by houming on 17-6-24.
 */
public class MajorityElement {
    /*
    Solution: 1. the count is never smaller than 0, so only the major element can remain.
     */
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0)
                major = num;
            if (num == major)
                count++;
            else
                count--;
        }
        return major;
    }

    public static void main(String[] args) {

    }
}
