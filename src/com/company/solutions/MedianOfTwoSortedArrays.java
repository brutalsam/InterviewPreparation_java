package com.company.solutions;

import javax.naming.PartialResultException;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 > len2 && len2 != 0) || len1 == 0 ){
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = len1;
        while (low <= high){
            int divider1 = (low + high + 1) / 2;
            int divider2 = (len1 + len2 + 1) / 2 - divider1;
            int maxLeft1 = divider1 == 0 ? Integer.MIN_VALUE: nums1[divider1 - 1];
            int minRight1 = divider1 == len1 ? Integer.MAX_VALUE : nums1[divider1];
            int maxLeft2 = divider2 == 0 ? Integer.MIN_VALUE: nums2[divider2 - 1];
            int minRight2 = divider2 == len2 ? Integer.MAX_VALUE : nums2[divider2];
            if (divider1 < len1 && maxLeft2 > minRight1){
                low = divider1 + 1;
            } else if (divider1 > 0 && maxLeft1 > minRight2){
                high = divider1 - 1;
            } else {
                int len = len1 + len2;
                if (len % 2 != 0){
                    return Math.max(maxLeft1, maxLeft2);
                }
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }
        }

        return 0.0; //Achtung!
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2){
        int len1 = array1.length;
        int len2 = array2.length;
        int i = 0;
        int j = 0;
        int[] result = new int[len1 + len2];
        while (i < len1 || j < len2){
            if (i < len1 && j < len2)
            {
                if (array1[i] < array2[j]){
                    result[i + j] = array1[i++];
                } else{
                    result[i + j] = array2[j++];
                }
            }
            else if (i == len1){
                result[i + j] = array2[j++];
            }else
                result[i + j] = array1[i++];
        }
        return result;
    }

    public static double findMedianWithMerging(int[] nums1, int[] nums2) {
        int [] mergedArr = mergeSortedArrays(nums1, nums2);
        int len = mergedArr.length;
        if (len % 2 == 0){
                int id = len / 2;
                return (mergedArr[id] + mergedArr [id - 1]) / 2.0;
        }
        return mergedArr[len / 2];
    }

    public static void testSolution(){
        int[] input1 = new int[] {3, 4, 5, 7, 10, 15, 17, 20, 21,  42};
        int[] input2 = new int[] {1, 2, 8, 11, 13, 14, 18, 20, 30, 31, 32, 33, 55};

        var result = findMedianSortedArrays(input1, input2);
        int[] input3 = new int[] {3, 8, 42, 51};
        int[] input4 = new int[] {1, 2, 9, 55};

        var result2 = findMedianSortedArrays(input3, input4);
        int[] input5 = new int[] {3, 8, 42, 51};
        int[] input6 = new int[] {1, 2};

        var result3 = findMedianSortedArrays(input5, input6);

        int[] input7 = new int[] {3, 8, 42, 51, 60};
        int[] input8 = new int[] {1, 2};

        var result4 = findMedianSortedArrays(input7, input8);
        int[] input9 = new int[] {};
        int[] input10 = new int[] {1};

        var result5 = findMedianSortedArrays(input9, input10);

    }
 }
