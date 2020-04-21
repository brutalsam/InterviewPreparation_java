package com.company.solutions;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {
    public static int trapTwoPointers(int[] height) {
        if (height.length < 3)
            return 0;
        int leftP = 0;
        int rightP = height.length - 1;
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (leftP < rightP){
            if (height[leftP] < height[rightP]){
                if (height[leftP] >= leftMax){
                    leftMax = height[leftP++];
                } else{
                    result += leftMax - height[leftP++];
                }
            } else {
                if(height[rightP]>= rightMax){
                    rightMax = height[rightP--];
                } else {
                    result += rightMax - height[rightP--];
                }
            }
        }
        return result;
    }

    public static int tapWaterBrutForce(int[] height){
        if (height.length < 3)
            return 0;
        int result = 0;
        for (int i = 1; i < height.length - 1; i++){
            int leftMax = 0;
            for (int l = i - 1; l >= 0 ; l--){
                if (leftMax < height[l]){
                    leftMax = height[l];
                }
            }
            int rightMax = 0;
            for (int r = i + 1; r < height.length ; r++){
                if (rightMax < height[r]){
                    rightMax = height[r];
                }
            }
            int minimumHeight = Math.min(leftMax, rightMax);
            if (minimumHeight > height[i]){
                result += Math.min(leftMax, rightMax) - height[i];
            }

        }
        return result;
    }

    public static int trapWithStack(int[] height)
    {
        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<Integer>();
        while (current < height.length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.pop();
                if (st.empty())
                    break;
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }

    public static void testSolution() {
        int[] input1 = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] input2 = new int[]{1, 2, 3, 4};
        int[] input3 = new int[]{4, 3, 2, 1};
        int[] input4 = new int[]{1,2,3,4, 3, 2, 1};
        int[] input5 = new int[]{2, 0, 2};
//        var res1 = trapTwoPointers(input4);
//        var result2 =  tapWaterBrutForce(input5);
        var result2 =  trapWithStack(input1);
    }
}
