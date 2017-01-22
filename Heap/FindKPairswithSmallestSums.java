//373. Find K Pairs with Smallest Sums   Add to List QuestionEditorial Solution  My Submissions
//Total Accepted: 20339
//Total Submissions: 68087
//Difficulty: Medium
//Contributors: Admin
//You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
//Define a pair (u,v) which consists of one element from the first array and one element from the second array.
//
//Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
//
//Example 1:
//Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
//
//Return: [1,2],[1,4],[1,6]
//
//The first 3 pairs are returned from the sequence:
//[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//Example 2:
//Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
//
//Return: [1,1],[1,1]
//
//The first 2 pairs are returned from the sequence:
//[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
//Example 3:
//Given nums1 = [1,2], nums2 = [3],  k = 3 
//
//Return: [1,3],[2,3]
//
//All possible pairs are returned from the sequence:
//[1,3],[2,3]
//Credits:
//Special thanks to @elmirap and @StefanPochmann for adding this problem and creating all test cases.
//
//Subscribe to see which companies asked this question

public class FindKPairswithSmallestSums {
	/*
	 * Solution:
	 * 1.Based on the situation that each array is sorted in ascending order.
	 * We can find a matrix that the minimum number is at the left-top.
	  2   4   6
   +------------
 1 |  3   5   7
 7 |  9  11  13
11 | 13  15  17
	 *2.Add k numbers from the first column to the heap.
	 *3.Put the top number to the result list and add the right number of it to the heap.
	 *(We can guarantee the minimum must in the heap)
	 */
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> res = new LinkedList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return res;

		PriorityQueue<int[]> queue = new PriorityQueue<>(
				(a, b) -> nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
		for (int i = 0; i < nums2.length && i < k; i++)
			queue.add(new int[] { 0, i });

		while (!queue.isEmpty() && k-- > 0) {
			int[] index = queue.poll();
			if (index[0] + 1 < nums1.length)
				queue.add(new int[] { index[0] + 1, index[1] });
			res.add(new int[] { nums1[index[0]], nums2[index[1]] });
		}

		return res;
	}

	public static void main(String[] args) {
		new FindKPairswithSmallestSums().kSmallestPairs(new int[] { 1, 3, 4 }, new int[] { 2, 4, 6 }, 5).stream()
				.iterator().forEachRemaining(array -> {
					System.out.println(Arrays.toString(array));
				});
	}

}

