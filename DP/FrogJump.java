package com.hm;

import java.util.*;
//403. Frog Jump
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 14776
//        Total Submissions: 46567
//        Difficulty: Hard
//        Contributor: LeetCode

//A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
//
//        Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
//
//        If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.
//
//        Note:
//
//        The number of stones is ≥ 2 and is < 1,100.
//        Each stone's position will be a non-negative integer < 231.
//        The first stone's position is always 0.
//        Example 1:
//
//        [0,1,3,5,6,8,12,17]
//
//        There are a total of 8 stones.
//        The first stone at the 0th unit, second stone at the 1st unit,
//        third stone at the 3rd unit, and so on...
//        The last stone at the 17th unit.
//
//        Return true. The frog can jump to the last stone by jumping
//        1 unit to the 2nd stone, then 2 units to the 3rd stone, then
//        2 units to the 4th stone, then 3 units to the 6th stone,
//        4 units to the 7th stone, and 5 units to the 8th stone.
//        Example 2:
//
//        [0,1,2,3,4,8,9,11]
//
//        Return false. There is no way to jump to the last stone as
//        the gap between the 5th and 6th stone is too large.
//        Subscribe to see which companies asked this question.
//
//        Hide Tags Dynamic Programming

/**
 * Created by hm on 17-6-9.
 */
public class FrogJump {
    /*
    Solution: 1.use map to store data. stone is key and the set of steps that a frog can jump from the stone.
              2.if current stone add to one of steps is end point, then return true.
              3.update map by add new steps to the stone that the current stone can jump to.
     */
    public static void main(String[] args) {
        System.out.print(new FrogJump().canCross(new int[]{
                0, 1, 2, 3, 4, 8, 9, 11
        }));
    }

    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (Integer stone : stones)
            map.put(stone, new HashSet<>());
        map.get(stones[0]).add(1);

        int arrive = stones[stones.length - 1];
        for (Integer stone : stones) {
            for (Integer step : map.get(stone)) {
                int next = stone + step;
                if (next == arrive)
                    return true;
                if (map.containsKey(next)) {
                    Set<Integer> set = map.get(next);
                    if (step != 1)
                        set.add(step - 1);
                    set.add(step);
                    set.add(step + 1);
                }
            }
        }
        return false;
    }
}
