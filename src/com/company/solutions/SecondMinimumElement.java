package com.company.solutions;

/**
 * Find second minimum element in an array of ints
 */
public class SecondMinimumElement {
    public static int getSecondMinimumArray(int[] array){
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int element: array) {
            if (element < firstMin){
                secondMin = firstMin;
                firstMin = element;
            } else if (element != firstMin && element < secondMin) {
                secondMin = element;
            }
        }
        return secondMin;
    }
    public static void testSolution(){
        int res1 = getSecondMinimumArray(new int[] { 10, 3, 2, 1, 1, 2, 3 });
        int res2 = getSecondMinimumArray(new int[] { 1, 1, 1, 1, 1, 1, 1 });
    }
}
