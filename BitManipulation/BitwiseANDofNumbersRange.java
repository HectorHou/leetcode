
// 201. Bitwise AND of Numbers Range   QuestionEditorial Solution  My Submissions
// Total Accepted: 45920
// Total Submissions: 140036
// Difficulty: Medium
// Contributors: Admin
// Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
//
// For example, given the range [5, 7], you should return 4.
//
// Credits:
// Special thanks to @amrsaqr for adding this problem and creating all test cases.
//
// Subscribe to see which companies asked this question


public class BitwiseANDofNumbersRange {
	/*
	 * Solution: 1. First find how many numbers between m and n;
	 * 			   2. more than 1 number between them means the lowest bit changed between 0 and 1;
	 * 				   more than 2 numbers means the second bit changed
	 * 					more than 4 numbers means the third bit changed
	 * 				So we need find the highest 1 in the n-m and set the lower bits 0 higher bit 1, (if n-m == 1011 then we set x = 11...110000)
	 * 			   3. lower bits depend on x while higher bits depend on m ^ n so the result = m & n & x
	 */
	public int rangeBitwiseAnd(int m, int n) {
		if (m == n)
			return m;
		int x = format(n - m);

		return m & n & x;

	}

	private int format(int x) {
		int i = 31;
		while (((1 << i) & x) == 0)
			i--;
		return ~((1 << (i + 1)) - 1);
	}

	public static void main(String[] args) {
		System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(5, 7));
		System.out.println(new BitwiseANDofNumbersRange().rangeBitwiseAnd(10,20));

	}

}
