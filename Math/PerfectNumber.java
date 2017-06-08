package com.hm;
//507. Perfect Number
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 8175
//        Total Submissions: 24560
//        Difficulty: Easy
//        Contributors:
//        wallflower
//        We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
//
//        Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
//        Example:
//        Input: 28
//        Output: True
//        Explanation: 28 = 1 + 2 + 4 + 7 + 14
//        Note: The input number n will not exceed 100,000,000. (1e8)
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Math
//        Have you met this question in a real interview? Yes
/**
 * Created by hm on 17-6-8.
 */
public class PerfectNumber {
    /*
    Solution : 1.use the same idea of finding prime number to get the divisors.
     */

    public static void main(String[] args) {
        System.out.print(new PerfectNumber().checkPerfectNumber(28));
    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 0 || num % 2 == 1)
            return false;
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num)
                    sum += num / i;
            }
        }
        return sum == 2 * num;
    }
}
