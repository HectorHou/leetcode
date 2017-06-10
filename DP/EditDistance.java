package com.hm;
//72. Edit Distance
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 86295
//        Total Submissions: 275618
//        Difficulty: Hard
//        Contributor: LeetCode
//        Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//
//        You have the following 3 operations permitted on a word:
//
//        a) Insert a character
//        b) Delete a character
//        c) Replace a character
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Dynamic Programming String
//        Show Similar Problems
//        Have you met this question in a real interview? Yes

/**
 * Created by hm on 17-6-10.
 */
public class EditDistance {
    /*
    Solution: 1.use dp array to store sub question's result.
              2.dp[i][j] means the minDistance of word1[0..i-1] and word[0..j-1]
              3.if word1[i-1] == word2[j-1], then dp[i][j] = dp[i-1][j-1]
              4.else dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])
     */
    public static void main(String[] args) {
        System.out.print(new EditDistance().minDistance("abcdefg", "bcdefga"));
    }

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return 0;

        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < len1 + 1; i++)
            dp[i][0] = i;
        for (int i = 1; i < len2 + 1; i++)
            dp[0][i] = i;

        for (int i = 1; i < len1 + 1; i++)
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }

        return dp[word1.length()][word2.length()];
    }
}
