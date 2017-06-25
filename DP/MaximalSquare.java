package com.hm;
//221. Maximal Square
//        DescriptionHintsSubmissionsSolutions
//        Discuss   Editorial Solution Pick One
//        Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//        For example, given the following matrix:
//
//        1 0 1 0 0
//        1 0 1 1 1
//        1 1 1 1 1
//        1 0 0 1 0
//        Return 4.

/**
 * Created by houming on 17-6-25.
 */
public class MaximalSquare {
    /*
    Solution: 1.use dp array to store the max size when use the current position as the square's right-bottom position
              2.dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1])
     */
    public int maximalSquare(char[][] matrix) {
        int maximum = 0;
        if (matrix == null || matrix.length == 0)
            return maximum;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i <= matrix.length; i++)
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maximum = maximum > dp[i][j] ? maximum : dp[i][j];
                }
        return maximum * maximum;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{
                "10100".toCharArray(), "10111".toCharArray(),
                "11111".toCharArray(), "10010".toCharArray()
        }));
    }
}
