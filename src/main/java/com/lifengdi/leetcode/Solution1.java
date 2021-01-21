package com.lifengdi.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 李锋镝
 * @date: 2021-01-21 17:16
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
