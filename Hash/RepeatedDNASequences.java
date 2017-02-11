//187. Repeated DNA Sequences
//Description  Submission  Solutions  Add to List
//Total Accepted: 66707
//Total Submissions: 223146
//Difficulty: Medium
//Contributors: Admin
//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
//
//For example,
//
//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
//
//Return:
//["AAAAACCCCC", "CCCCCAAAAA"].
//Subscribe to see which companies asked this question.

public class RepeatedDNASequences {
	/*
	 * Solution:
	 * By using HashMap count each substring's repeat times.
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<>();
		if (s == null || s.length() <= 10)
			return res;

		Map<String, Integer> map = new HashMap<>();
		String str = null;
		for (int i = 0; i <= s.length() - 10; i++) {
			str = s.substring(i, i + 10);
			if (!map.containsKey(str))
				map.put(str, 0);
			map.put(str, map.get(str) + 1);
		}
		for (String ss : map.keySet())
			if (map.get(ss) > 1)
				res.add(ss);
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new RepeatedDNASequences().findRepeatedDnaSequences("AAAAAAAAAAA"));
	}

}

