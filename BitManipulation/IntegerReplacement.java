package com.hm;
//397. Integer Replacement
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 19166
//        Total Submissions: 64444
//        Difficulty: Medium
//        Contributor: LeetCode
//        Given a positive integer n and you can do operations as follow:
//
//        If n is even, replace n with n/2.
//        If n is odd, you can replace n with either n + 1 or n - 1.
//        What is the minimum number of replacements needed for n to become 1?
//
//        Example 1:
//
//        Input:
//        8
//
//        Output:
//        3
//
//        Explanation:
//        8 -> 4 -> 2 -> 1
//        Example 2:
//
//        Input:
//        7
//
//        Output:
//        4
//
//        Explanation:
//        7 -> 8 -> 4 -> 2 -> 1
//        or
//        7 -> 6 -> 3 -> 2 -> 1
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Math Bit Manipulation

/**
 * Created by hm on 17-6-16.
 */
public class IntegerReplacement {
    /*
    Solution: 1.if n is even, replace n with n/2
              2.if n is odd, we need to check out whether +1 or -1 could get more 0 to the n
              3.-1 means get one more 0, +1 means get the number of 1 at the ending of n
              4.but if all the bits in n is 1, then we will get one more 1 to n which lead 3 need to -1
     */
    public static void main(String[] args) {
        System.out.print(new IntegerReplacement().integerReplacement(2147483647));
    }

    public int integerReplacement(int n) {
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0)
                n >>>= 1;
            else if (n == 3 || ((n >>> 1) & 1) == 0)
                n--;
            else
                n++;
            count++;
        }
        return count;
    }
}
