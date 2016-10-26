// 438. Find All Anagrams in a String
//
//    Total Accepted: 2503
//    Total Submissions: 7292
//    Difficulty: Easy
//    Contributors: Stomach_ache
//
// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
// The order of output does not matter.
//
// Example 1:
//
// Input:
// s: "cbaebabacd" p: "abc"
//
// Output:
// [0, 6]
//
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
//
// Example 2:
//
// Input:
// s: "abab" p: "ab"
//
// Output:
// [0, 1, 2]
//
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
public class FindAllAnagramsinaString {
  /*Solution :sliding window
  *           use count record the match length, count == 0 means totally matched.
  *           new charater in, if it in p, count--
  *           old charater out, if it in p, count++
  *           use array to check if charater in p
  */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length())
            return list;
        int[] helper = new int[26];
        for (char c : p.toCharArray())
            helper[c - 'a']++;
        int left = 0, right = 0, count = p.length();
        while (right < p.length() - 1){
            if (helper[s.charAt(right++) - 'a']-- >= 1)
                count--;
        }
        while (right < s.length()) {
            if (helper[s.charAt(right++) - 'a']-- >= 1)
                count--;
            if (count == 0)
                list.add(left);
            if (helper[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }
        return list;
    }
}
