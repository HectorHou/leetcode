// 275. H-Index II   QuestionEditorial Solution  My Submissions
// Total Accepted: 35859
// Total Submissions: 107483
// Difficulty: Medium
// Contributors: Admin
// Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
//
// Hint:
//
// Expected runtime complexity is in O(log n) and the input is sorted.


public class H_IndexII {

	public static void main(String[] args) {
		System.out.println(new H_Index().hIndex(new int[] { 1, 1, 1, 9, 9 }));

	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;

		int lo = 0, hi = citations.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if ((citations.length - mid) == citations[mid])
				return citations[mid];
			else if ((citations.length - mid) > citations[mid])
				lo = mid + 1;
			else
				hi = mid;
		}
		return (citations.length - lo );
	}
}
