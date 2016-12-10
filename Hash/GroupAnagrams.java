// 49. Group Anagrams   Add to List QuestionEditorial Solution  My Submissions
// Total Accepted: 105455
// Total Submissions: 336223
// Difficulty: Medium
// Contributors: Admin
// Given an array of strings, group anagrams together.
//
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Return:
//
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.
//
// Subscribe to see which companies asked this question


public class GroupAnagrams {
	/*
	 * Solution:Alphabetize the string as a hashmap's key to find out if the
	 * string belongs to the same list.
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new LinkedList<>();
		if (strs == null || strs.length == 0)
			return res;
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] cc = s.toCharArray();
			Arrays.sort(cc);
			String key = new String(cc);
			if (!map.containsKey(key)) {
				map.put(key, new LinkedList<>());
			}
			map.get(key).add(s);
		}
		res.addAll(map.values());
		return res;

	}

	public static void main(String[] args) {
		System.out
				.println(new GroupAnagrams().groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

	}

}
