package com.hm;

import java.util.*;
//56. Merge Intervals
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 125079
//        Total Submissions: 423610
//        Difficulty: Medium
//        Contributor: LeetCode
//        Given a collection of intervals, merge all overlapping intervals.
//
//        For example,
//        Given [1,3],[2,6],[8,10],[15,18],
//        return [1,6],[8,10],[15,18].
//
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Array Sort
//        Hide Similar Problems
/**
 * Created by houming on 17-6-19.
 */
public class MergeIntervals {
    /*
    Solution1: sort the intervals by start, and then merge them

    Solution2: sort the starts and ends respectively.
               if the latter one's start > the previous one's end, there is a new interval need to create.
               because if not, there will be an interval whose start is greater the its end.
     */
    public static void main(String[] args) {

    }

    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> res = new LinkedList<>();

        if (intervals == null || intervals.size() == 0)
            return res;

        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);

        for (Interval i : intervals) {
            if (res.size() == 0) {
                res.add(new Interval(i.start, i.end));
                continue;
            }
            Interval i0 = res.getLast();
            if (i0.end < i.start)
                res.add(new Interval(i.start,i.end));
            else if (i0.end < i.end)
                i0.end = i.end;
        }

        return res;
    }
    public List<Interval> merge2(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}

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
}