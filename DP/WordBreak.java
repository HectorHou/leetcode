package com.hm;

import java.util.Arrays;
import java.util.List;
//139. Word Break
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 145906
//        Total Submissions: 495917
//        Difficulty: Medium
//        Contributor: LeetCode
//        Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
//
//        For example, given
//        s = "leetcode",
//        dict = ["leet", "code"].
//
//        Return true because "leetcode" can be segmented as "leet code".
//
//        UPDATE (2017/1/4):
//        The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Dynamic Programming
//        Show Similar Problems

/**
 * Created by houming on 17-6-20.
 */
public class WordBreak {
    /*
    Solution: 1.use dp array to store whether s[0..i] is breakable.
              2.if s[0..i] is breakable and wordDict contains s[i+1..j], s[0..j] is breakable.
     */
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", Arrays.asList("leet", "co", "de")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] breakable = new boolean[s.length() + 1];
        breakable[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (breakable[j] && wordDict.contains(s.substring(j, i))) {
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
}