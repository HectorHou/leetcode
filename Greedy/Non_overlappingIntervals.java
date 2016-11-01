// 435. Non-overlapping Intervals   QuestionEditorial Solution  My Submissions
// Total Accepted: 853
// Total Submissions: 2419
// Difficulty: Medium
// Contributors: love_FDU_llp
// Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//
// Note:
// You may assume the interval's end point is always bigger than its start point.
// Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
// Example 1:
// Input: [ [1,2], [2,3], [3,4], [1,3] ]
//
// Output: 1
//
// Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
// Example 2:
// Input: [ [1,2], [1,2], [1,2] ]
//
// Output: 2
//
// Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
// Example 3:
// Input: [ [1,2], [2,3] ]
//
// Output: 0
//
// Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}
}

public class Non_overlappingIntervals {
	/*
	 * Solution: 1.Sort intervals by start(1st) and end(2nd).
	 * 2.Use Greedy strategy.
	 * - if start1 == start2 then we remove start2 because it has
	 * larger end which means the longest interval
	 * - if end1 > start2 which means we have to remove one from two intervals, then we remove the
	 * interval which has larger end because it may cross more start
	 * - if end1 <= start2 then we don't need to remove anyone of them
	 */
	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length < 2)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {

				return (Integer.compare(o1.start, o2.start) != 0) ? Integer.compare(o1.start, o2.start)
						: Integer.compare(o1.end, o2.end);
			}

		});
		Interval interval = intervals[0];
		int count = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start == interval.start) {
				count++;
			} else if (intervals[i].start < interval.end) {
				count++;
				interval = (intervals[i].end < interval.end) ? intervals[i] : interval;
			} else {
				interval = intervals[i];
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Non_overlappingIntervals()
				.eraseOverlapIntervals(new Interval[] { new Interval(1, 2), new Interval(1, 3), new Interval(2, 3) }));
	}

}
