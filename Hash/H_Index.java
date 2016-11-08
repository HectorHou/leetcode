//274. H-Index   QuestionEditorial Solution  My Submissions
//Total Accepted: 53948
//Total Submissions: 171019
//Difficulty: Medium
//Contributors: Admin
//Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
//
//According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
//
//For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
//
//Note: If there are several possible values for h, the maximum one is taken as the h-index.
//
//Hint:
//
//An easy approach is to sort the array first.
//What are the possible values of h-index?
//A faster approach is to use extra space.


public class H_Index {
	/*
	 * Solution : What are the possible values of h-index?
	 * The possible values are from 0 to the length of citations even if the citation can greater than that.
	 * So create an array to store the times each citation appears.
	 * Greater citations stores in array[length].
	 */

	public static void main(String[] args) {
		System.out.println(new H_Index().hIndex(new int[]{3, 0, 6, 1, 5}));

	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0)
			return 0;

		int[] arr = new int[citations.length + 1];

		for (int i : citations)
			arr[citations.length < i ? citations.length : i]++;

		int count = 0;
		for (int i = citations.length; i > 0; i--) {
			count += arr[i];
			if (count >= i)
				return i;
		}

		return 0;
	}
}
