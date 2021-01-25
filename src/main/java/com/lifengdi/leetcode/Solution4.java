package com.lifengdi.leetcode;

/**
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @author: 李锋镝
 * @date: 2021-01-21 17:16
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int left = (l1 + l2 + 1) / 2;
        int right = (l1 + l2 + 2) / 2;
        return (find(nums1, 0, nums2, 0, left) + find(nums1, 0, nums2, 0, right)) / 2.0;
    }

    public int find(int[] nums1, int i, int[] nums2, int j, int midIndex) {
        if (i >= nums1.length) {
            return nums2[j + midIndex - 1];
        }
        if (j >= nums2.length) {
            return nums1[i + midIndex - 1];
        }
        if (midIndex == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int mid1 = (i + midIndex / 2 - 1 < nums1.length) ? nums1[i + midIndex / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + midIndex / 2 - 1 < nums2.length) ? nums2[j + midIndex / 2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            return find(nums1, i + midIndex / 2, nums2, j, midIndex - midIndex / 2);
        } else {
            return find(nums1, i, nums2, j + midIndex / 2, midIndex - midIndex / 2);
        }

    }
}
