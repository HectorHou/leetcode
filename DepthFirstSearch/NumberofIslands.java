// 200. Number of Islands
//
//    Total Accepted: 77367
//    Total Submissions: 243274
//    Difficulty: Medium
//    Contributors: Admin
//
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
// 11110
// 11010
// 11000
// 00000
//
// Answer: 1
//
// Example 2:
//
// 11000
// 11000
// 00100
// 00011
//
// Answer: 3
//
// Credits:
// Special thanks to @mithmatt for adding this problem and creating all test cases.
//
// Subscribe to see which companies asked this question


public class NumberofIslands {
	/*
	 * Solution:Depth First Search.
	 */

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					visit(grid, visited, i, j);
					count++;
				}
			}
		}

		return count;
	}

	private void visit(char[][] grid, boolean[][] visited, int i, int j) {
		visited[i][j] = true;
		if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited[i - 1][j])
			visit(grid, visited, i - 1, j);
		if (i + 1 < grid.length && grid[i + 1][j] == '1' && !visited[i + 1][j])
			visit(grid, visited, i + 1, j);
		if (j - 1 >= 0 && grid[i][j - 1] == '1' && !visited[i][j - 1])
			visit(grid, visited, i, j - 1);
		if (j + 1 < grid[0].length && grid[i][j + 1] == '1' && !visited[i][j + 1])
			visit(grid, visited, i, j + 1);

	}

	public static void main(String[] args) {
		char[][] grid = new char[][] { "11000".toCharArray(), "11000".toCharArray(), "00100".toCharArray(),
				"00011".toCharArray() };

		System.out.println(new NumberofIslands().numIslands(grid));

	}

}
