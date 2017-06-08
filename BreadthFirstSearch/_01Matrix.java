package com.hm;

import java.util.LinkedList;
import java.util.List;
//542. 01 Matrix
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 6243
//        Total Submissions: 18877
//        Difficulty: Medium
//        Contributors:
//        Stomach_ache
//        Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
//
//        The distance between two adjacent cells is 1.
//        Example 1:
//        Input:
//
//        0 0 0
//        0 1 0
//        0 0 0
//        Output:
//        0 0 0
//        0 1 0
//        0 0 0
//        Example 2:
//        Input:
//
//        0 0 0
//        0 1 0
//        1 1 1
//        Output:
//        0 0 0
//        0 1 0
//        1 2 1
//        Note:
//        The number of elements of the given matrix will not exceed 10,000.
//        There are at least one 0 in the given matrix.
//        The cells are adjacent in only four directions: up, down, left and right.
/**
 * Created by hm on 17-6-8.
 */
public class _01Matrix {
    /*
    Solution : 1.use bfs strategy to search the matrix.
               2.0s are level 0 and the neighbors are level 1 and the neighbors' neighbors are level 2 ...
               3.use list to store each level and find next level
     */
    public static void main(String[] args) {
        System.out.print(new _01Matrix().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
    }

    public static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;

        int row = matrix.length, col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];

        List<int[]> list = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while (!list.isEmpty()) {
            List<int[]> list0 = new LinkedList<>();
            for (int[] pos : list) {
                matrix[pos[0]][pos[1]] = level;
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0], y = pos[1] + dir[1];
                    if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                        list0.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            list = list0;
            level++;
        }

        return matrix;
    }
}
