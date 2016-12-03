// 417. Pacific Atlantic Water Flow   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 5802
// Total Submissions: 17977
// Difficulty: Medium
// Contributors: Admin
// Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
//
// Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
//
// Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
//
// Note:
// The order of returned grid coordinates does not matter.
// Both m and n are less than 150.
// Example:
//
// Given the following 5x5 matrix:
//
//   Pacific ~   ~   ~   ~   ~
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//           *   *   *   *   * Atlantic
//
// Return:
//
// [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
// Subscribe to see which companies asked this question


public class PacificAtlanticWaterFlow {
	/*
	 * Solution:Put the points that can reach one of the oceans into a set by
	 * DFS (the point which can reach the point that can reach the ocean can
	 * reach the ocean)
	 * Calculating intersection set of them is the result.
	 */

	public List<int[]> pacificAtlantic(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return new ArrayList<>();
		int m = matrix.length, n = matrix[0].length;

		boolean[][] statePacific = new boolean[m][n];
		boolean[][] stateAtlantic = new boolean[m][n];

		Set<List<Integer>> setPacific = new HashSet<>();
		Set<List<Integer>> setAtlantic = new HashSet<>();

		for (int i = 0; i < m; i++) {
			DFS(setPacific, i, 0, matrix, statePacific);
			DFS(setAtlantic, i, n - 1, matrix, stateAtlantic);
		}
		for (int j = 0; j < n; j++) {
			DFS(setPacific, 0, j, matrix, statePacific);
			DFS(setAtlantic, m - 1, j, matrix, stateAtlantic);
		}

		setPacific.retainAll(setAtlantic);

		List<int[]> res = new ArrayList<>();
		for (List<Integer> list : setPacific)
			res.add(new int[] { list.get(0), list.get(1) });

		return res;
	}

	private void DFS(Set<List<Integer>> set, int i, int j, int[][] matrix, boolean[][] state) {
		if (state[i][j])
			return;

		state[i][j] = true;
		set.add(Arrays.asList(i, j));

		if (i - 1 >= 0 && matrix[i - 1][j] >= matrix[i][j])
			DFS(set, i - 1, j, matrix, state);
		if (i + 1 < matrix.length && matrix[i + 1][j] >= matrix[i][j])
			DFS(set, i + 1, j, matrix, state);
		if (j - 1 >= 0 && matrix[i][j - 1] >= matrix[i][j])
			DFS(set, i, j - 1, matrix, state);
		if (j + 1 < matrix[0].length && matrix[i][j + 1] >= matrix[i][j])
			DFS(set, i, j + 1, matrix, state);
	}

	public static void main(String[] args) {
		System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 },
				{ 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } }));

	}

}
