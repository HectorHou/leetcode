package com.hm;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by hm on 17-6-6.
 */
public class TrappingRainWaterII {
    /*
    Solution : 1.Use PriorityQueue to process the smallest cell whose neighbor must could add water to
                the current cell's height if the neighbor's height is smaller each time.
               2.update the array visited and the queue.
               3.until the inside cells are all visited
     */
    public static void main(String[] args) {
        System.out.print(new TrappingRainWaterII().trapRainWater(new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}}));
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3)
            return 0;

        int sum = 0;
        Queue<Cell> queue = new PriorityQueue<>();
        int row = heightMap.length, col = heightMap[0].length;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            queue.add(new Cell(heightMap[i][0], i, 0));
            queue.add(new Cell(heightMap[i][col - 1], i, col - 1));
            visited[i][0] = true;
            visited[i][col - 1] = true;
        }
        for (int i = 1; i < col - 1; i++) {
            queue.add(new Cell(heightMap[0][i], 0, i));
            queue.add(new Cell(heightMap[row - 1][i], row - 1, i));
            visited[0][i] = true;
            visited[row - 1][i] = true;
        }

        int count = 0, finish = (row - 2) * (col - 2);
        // dirs is the movement to the neighbor
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (count < finish) {
            Cell cell = queue.poll();
            for (int[] dir : dirs) {
                int x = cell.x + dir[0], y = cell.y + dir[1];
                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    count++;
                    sum += Math.max(0, cell.height - heightMap[x][y]);
                    queue.add(new Cell(Math.max(heightMap[x][y], cell.height), x, y));
                    visited[x][y] = true;
                }
            }
        }
        return sum;
    }

    private static class Cell implements Comparable<Cell> {
        int height;
        int x, y;

        public Cell(int height, int x, int y) {
            this.height = height;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Cell other) {
            return this.height - other.height;
        }

    }
}
