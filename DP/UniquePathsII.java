// 63. Unique Paths II   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 86936
// Total Submissions: 282267
// Difficulty: Medium
// Contributors: Admin
// Follow up for "Unique Paths":
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.
//
// Note: m and n will be at most 100.
//
// Subscribe to see which companies asked this question
//
// Hide Tags Array Dynamic Programming
// Hide Similar Problems (M) Unique Paths


public class UniquePathsII {
	/*
	 * Solution :use arr[][] as to store the number of ways from top-left to
	 * arr[i][j]
	 * an better solution from leetcode
//	  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//    int width = obstacleGrid[0].length;
//    int[] dp = new int[width];
//    dp[0] = 1;
//    for (int[] row : obstacleGrid) {
//        for (int j = 0; j < width; j++) {
//            if (row[j] == 1)
//                dp[j] = 0;
//            else if (j > 0)
//                dp[j] += dp[j - 1];
//        }
//    }
//    return dp[width - 1];
}
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
			return 0;
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		int[][] a = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			a[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1)
				break;
			a[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				a[i][j] = obstacleGrid[i][j] == 1 ? 0 : (a[i - 1][j] + a[i][j - 1]);
			}
		}
		return a[m - 1][n - 1];
	}

	public static void main(String[] args) {
		System.out.println(
				new UniquePathsII().uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));

	}

}
