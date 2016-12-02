// 120. Triangle   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 88411
// Total Submissions: 274776
// Difficulty: Medium
// Contributors: Admin
// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//
// For example, given the following triangle
// [
//      [2],
//     [3,4],
//    [6,5,7],
//   [4,1,8,3]
// ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


public class Triangle {
	/*
	 * Solution:Calculate the minTotal of every point from top to bottom.
	 */

	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		List<Integer> currList = null, lastList = null;
		for (int i = 1; i < triangle.size(); i++) {
			currList = triangle.get(i);
			lastList = triangle.get(i - 1);
			currList.set(0, currList.get(0) + lastList.get(0));
			currList.set(i, currList.get(i) + lastList.get(i - 1));
			for (int j = 1; j < i; j++)
				currList.set(j, currList.get(j) + Math.min(lastList.get(j - 1), lastList.get(j)));
		}
		return Collections.min(triangle.get(triangle.size() - 1));
	}
}
