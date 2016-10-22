// 279. Perfect Squares   QuestionEditorial Solution  My Submissions
// Total Accepted: 54148
// Total Submissions: 157490
// Difficulty: Medium
// Contributors: Admin
// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
//
// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


public class PerfectSquares {

    public int numSquares(int n) {

        int[] helper = new int[n + 1];

        for (int i = 1; i <= n; i++){
            helper[i] = i;
            for (int j = 1; j * j <= i; j++){ //You can make it length short only if you devide it with a perfect number
                helper[i] = Math.min(helper[i], helper[i - j * j] + 1);
            }
        }

        return helper[n];
    }
}
