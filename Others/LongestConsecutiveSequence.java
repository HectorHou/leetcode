// 128. Longest Consecutive Sequence   QuestionEditorial Solution  My Submissions
// Total Accepted: 80997
// Total Submissions: 235626
// Difficulty: Hard
// Contributors: Admin
// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
//
// Your algorithm should run in O(n) complexity.
//

public class LongestConsecutiveSequence {
  /* Solution: Use UnionFind Thought.
  *            Use HashMap to store value and the length of subSeq.
  *            HashMap's key should represent the insert num.
  *            HashMap's 2 brink node's value should represent the length of the subSeq.
  */
    public int longestConsecutive(int[] nums) {

        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums){
            if (map.containsKey(num))
                continue;

            int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;

            int sum = left + right + 1;
            map.put(num, 0);
            map.put(num - left, sum);
            map.put(num + right, sum);

            maxLength = maxLength > sum ? maxLength : sum;
        }
        return maxLength;
    }
}
