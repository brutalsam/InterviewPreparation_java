package com.company.solutions;

import java.util.*;

/**
 * https://leetcode.com/problems/high-five/
 * Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
 *
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.
 */
public class HighFive {
    public static int[][] highFive(int[][] items) {
        HashMap<Integer, ArrayList<Integer>> db = new HashMap();
        for (int[] input: items) {
            if (db.containsKey(input[0])) {
                ArrayList<Integer> list = db.get(input[0]);
                list.add(input[1]);
                db.replace(input[0], list);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(input[1]);
                db.put(input[0], list);
            }
        }

        int [][] result = new int[db.size()][2];
        int cnt = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> student :db.entrySet()) {
            ArrayList<Integer> marks = student.getValue();
            Collections.sort(marks, Collections.reverseOrder());
            Integer min = Math.min(marks.size(), 5);
            Integer sum = 0;
            for (int i = 0; i < min; i++) {
                sum += marks.get(i);
            }

            result[cnt][0] = student.getKey();
            result[cnt++][1] = sum / min;
        }
        return result;
    }

    public static void testSolution(){
        int[][] arr = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        int[][] res = highFive(arr);
    }
}
