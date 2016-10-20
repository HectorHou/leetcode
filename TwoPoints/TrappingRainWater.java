// 42. Trapping Rain Water   QuestionEditorial Solution  My Submissions
// Total Accepted: 85248
// Total Submissions: 247742
// Difficulty: Hard
// Contributors: Admin
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
//
//
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//

public class TrappingRainWater {

    public int trap(int[] height) {
        /*
        * Solution: The lower elevation depends the water it traps, so erery time we move the lower point.
        *           The water it traps is (the highest by now - current height)
        */

        if (height == null || height.length < 3)
            return 0;

        int lo = 0, hi = height.length - 1;
        int maxLeft = height[0], maxRight = height[height.length - 1];
        int sum = 0;

        while (lo < hi){

            if (height[lo] <= height[hi]){
                if (height[lo] <= maxLeft)
                    sum += (maxLeft - height[lo]);
                else
                    maxLeft = height[lo];
                lo++;
            } else {
                if (height[hi] <= maxRight)
                    sum += (maxRight - height[hi]);
                else
                    maxRight = height[hi];
                hi--;
            }
        }

        return sum;
    }
}
