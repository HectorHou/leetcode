package com.hm;
//329. Longest Increasing Path in a Matrix
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 34875
//        Total Submissions: 96989
//        Difficulty: Hard
//        Contributor: LeetCode
//        Given an integer matrix, find the length of the longest increasing path.
//
//        From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
//
//        Example 1:
//
//        nums = [
//        [9,9,4],
//        [6,6,8],
//        [2,1,1]
//        ]
//        Return 4
//        The longest increasing path is [1, 2, 6, 9].
//
//        Example 2:
//
//        nums = [
//        [3,4,5],
//        [3,2,6],
//        [2,2,1]
//        ]
//        Return 4
//        The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
//
//        Credits:
//        Special thanks to @dietpepsi for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question.
/**
 * Created by hm on 17-6-7.
 */
public class LongestIncreasingPathInAMatrix {
    /*
    Solution : 1.use bit vector to store the movements for each position.
               2.find the position that can be the start one.
               3.use dp array to store the common sub results
     */

    public static void main(String[] args) {
        System.out.print(new LongestIncreasingPathInAMatrix().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int row = matrix.length, col = matrix[0].length;
        int[][] direction = new int[row][col];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] mid = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int z = 0; z < 4; z++) {
                    int x = i + dirs[z][0];
                    int y = j + dirs[z][1];
                    if (x >= 0 && x < row && y >= 0 && y < col && matrix[x][y] > matrix[i][j]) {
                        direction[i][j] |= 1 << z;
                        mid[x][y] = true;
                    }
                }
            }
        }

        int maxLen = 0;
        int[][] helper = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!mid[i][j]) {
                    int len = getMaxLen(direction, dirs, helper, i, j);
                    maxLen = len > maxLen ? len : maxLen;
                }
            }
        }

        return maxLen;
    }

    private int getMaxLen(int[][] direction, int[][] dirs, int[][] helper, int i, int j) {
        if (direction[i][j] == 0)
            return 1;
        if (helper[i][j] != 0)
            return helper[i][j];

        int maxLen = 0;
        for (int x = 0; x < 4; x++) {
            if ((direction[i][j] & (1 << x)) != 0) {
                int len = 1 + getMaxLen(direction, dirs, helper, i + dirs[x][0], j + dirs[x][1]);
                maxLen = maxLen > len ? maxLen : len;
            }
        }
        helper[i][j] = maxLen;

        return maxLen;
    }
}
