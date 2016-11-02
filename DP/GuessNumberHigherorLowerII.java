// 375. Guess Number Higher or Lower II   QuestionEditorial Solution  My Submissions
// Total Accepted: 10991
// Total Submissions: 32623
// Difficulty: Medium
// Contributors: Admin
// We are playing the Guess Game. The game is as follows:
//
// I pick a number from 1 to n. You have to guess which number I picked.
//
// Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
//
// However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.
//
// Example:
//
// n = 10, I pick 8.
//
// First round:  You guess 5, I tell you that it's higher. You pay $5.
// Second round: You guess 7, I tell you that it's higher. You pay $7.
// Third round:  You guess 9, I tell you that it's lower. You pay $9.
//
// Game over. 8 is the number I picked.
//
// You end up paying $5 + $7 + $9 = $21.
// Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
//
// Hint:
//
// The best strategy to play the game is to minimize the maximum loss you could possibly face. Another strategy is to minimize the expected loss. Here, we are interested in the first scenario.
// Take a small example (n = 3). What do you end up paying in the worst case?
// Check out this article if you're still stuck.
// The purely recursive implementation of minimax would be worthless for even a small n. You MUST use dynamic programming.
// As a follow-up, how would you modify your code to solve the problem of minimizing the expected loss, instead of the worst-case loss?


public class GuessNumberHigherorLowerII {
	/*
	 * Solution : Use DP and need an array to store past calculation. The amount
	 * is ths minimum of (the first guess amount add the maximum between (the
	 * left guess amount and the right guess))
	 */
	public int getMoneyAmount(int n) {
		int[][] helper = new int[n + 1][n + 1];
		return getMoneyAmount(1, n, helper);
	}

	private int getMoneyAmount(int lo, int hi, int[][] helper) {
		if (helper[lo][hi] != 0)
			return helper[lo][hi];

		if (lo >= hi)
			return 0;
		if (lo + 1 == hi)
			return lo;

		int minAmount = Integer.MAX_VALUE;

		for (int i = lo + 1; i < hi; i++) {
			int amount = i + Math.max(getMoneyAmount(lo, i - 1, helper), getMoneyAmount(i + 1, hi, helper));
			minAmount = (minAmount > amount) ? amount : minAmount;
		}
		helper[lo][hi] = minAmount;

		return minAmount;
	}

	public static void main(String[] args) {
		System.out.println(new GuessNumberHigherorLowerII().getMoneyAmount(100));
	}

}
