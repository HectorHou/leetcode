package com.hm;

import java.util.Arrays;
//322. Coin Change
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 59143
//        Total Submissions: 224517
//        Difficulty: Medium
//        Contributor: LeetCode
//        You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
//
//        Example 1:
//        coins = [1, 2, 5], amount = 11
//        return 3 (11 = 5 + 5 + 1)
//
//        Example 2:
//        coins = [2], amount = 3
//        return -1.
//
//        Note:
//        You may assume that you have an infinite number of each kind of coin.
//
//        Credits:
//        Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Dynamic Programming

/**
 * Created by hm on 17-6-15.
 */
public class CoinChange {
    /*
    Solution: 1.the amount could be add from amount - coin[1|2|...], use an array to save the minimum coins to arrive the current amount.
     */
    public static void main(String[] args) {
        System.out.print(new CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (coins == null || coins.length == 0)
            return -1;

        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount; i++)
            for (int coin : coins)
                if (i != 0 && dp[i] == 0 || i + coin > amount || i + coin <= 0)
                    break;
                else
                    dp[i + coin] = dp[i + coin] == 0 ? dp[i] + 1 : dp[i + coin] > dp[i] + 1 ? dp[i] + 1 : dp[i + coin];

        if (dp[amount] == 0)
            return -1;
        else return dp[amount];
    }
}
