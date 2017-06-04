package com.hm;
//434. Number of Segments in a String
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 20445
//        Total Submissions: 55356
//        Difficulty: Easy
//        Contributors:
//        love_Fawn
//        Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
//
//        Please note that the string does not contain any non-printable characters.
//
//        Example:
//
//        Input: "Hello, my name is John"
//        Output: 5
//        Subscribe to see which companies asked this question.
//
//        Hide Tags String

/**
 * Created by hm on 17-6-4.
 */
public class NumberOfSegmentsInAString {
    /*
    Solution: 1.donot forget the space at the start or at the end of the String
     */
    public int countSegments(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) != ' ') {
                count++;

                while (i < s.length() && s.charAt(i) != ' ')
                    i++;
            } else
                i++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(new NumberOfSegmentsInAString().countSegments("  Hello, my name is John  "));
    }
}
