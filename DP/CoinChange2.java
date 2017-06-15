package com.hm;
//518. Coin Change 2
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 4326
//        Total Submissions: 14145
//        Difficulty: Medium
//        Contributors:
//        vchernoy
//        You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
//
//        Note: You can assume that
//
//        0 <= amount <= 5000
//        1 <= coin <= 5000
//        the number of coins is less than 500
//        the answer is guaranteed to fit into signed 32-bit integer
//        Example 1:
//
//        Input: amount = 5, coins = [1, 2, 5]
//        Output: 4
//        Explanation: there are four ways to make up the amount:
//        5=5
//        5=2+2+1
//        5=2+1+1+1
//        5=1+1+1+1+1
//        Example 2:
//
//        Input: amount = 3, coins = [2]
//        Output: 0
//        Explanation: the amount of 3 cannot be made up just with coins of 2.
//        Example 3:
//
//        Input: amount = 10, coins = [10]
//        Output: 1
//        Subscribe to see which companies asked this question.
/**
 * Created by hm on 17-6-15.
 */
public class CoinChange2 {
    /*
    Solution: 1.different from CoinChange use one dp array because the different selected order add for more than once.
              2.use two dimensional array to store the count of current amount by using the current coins.
              3.dp[i][j] = dp[i-1][j](not use current coin) + dp[i][j-coins[i-1]](must use current coin)
     */
    public static void main(String[] args) {
        System.out.print(new CoinChange2().change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i < coins.length + 1; i++) {
            dp[i][0] = 1;
            for (int j = 1; j < amount + 1; j++) {
                dp[i][j] += dp[i - 1][j];
                if (j - coins[i - 1] >= 0)
                    dp[i][j] += dp[i][j - coins[i - 1]];
            }
        }

        return dp[coins.length][amount];
    }
}
