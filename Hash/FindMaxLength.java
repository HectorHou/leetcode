package com.hm;

import java.util.HashMap;
import java.util.Map;

//525. Contiguous Array
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 8294
//        Total Submissions: 22298
//        Difficulty: Medium
//        Contributors:
//        bishwa
//        Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
//
//        Example 1:
//        Input: [0,1]
//        Output: 2
//        Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
//        Example 2:
//        Input: [0,1,0]
//        Output: 2
//        Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//        Note: The length of the given binary array will not exceed 50,000.
/**
 * Created by hm on 17-6-4.
 */
public class FindMaxLength {
    /*
    Solution: 1.use hashmap to store the current sum and index
              2.when hashmap already contains the sum, the numbers from index in hashmap to current index contains equal number 1 and 0
     */
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > res)
                    res = i - map.get(sum);
            } else
                map.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(new FindMaxLength().findMaxLength(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
