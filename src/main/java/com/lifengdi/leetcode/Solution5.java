package com.lifengdi.leetcode;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * 最长回文子串
 *
 * @author: 李锋镝
 * @date: 2021-01-21 17:16
 */
public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] strArray = s.toCharArray();
        int[] range = new int[2];
        for (int i = 0; i < s.length(); i++) {
            i = getLongestPalindromeLength(strArray, i, range);
        }

        return s.substring(range[0], range[1] + 1);
    }

    /**
     * 获取回文子串的长度，并记录最长回文子串开始、结束的字符的下标
     * @param strArray 字符数组
     * @param beginIndex 开始下标
     * @param range 最长回文子串开始、结束的字符的下标
     * @return 中间重复部分的最后一个字符的位置
     */
    public int getLongestPalindromeLength(char[] strArray, int beginIndex, int[] range) {
        // 开始 = 结束
        int endIndex = beginIndex;
        // 若strArray[endIndex+1] == strArray[beginIndex] 则可以将其视为一个字符，无论长度是多少eg: a,aa,aaa
        while (endIndex < strArray.length - 1 && strArray[endIndex + 1] == strArray[beginIndex]) {
            endIndex++;
        }
        // 下一次循环的起点，即中间重复部分的最后一个字符的位置
        int rs = endIndex;

        // 从中间向两边扩散比较
        while (beginIndex > 0 && endIndex < strArray.length - 1 && strArray[beginIndex - 1] == strArray[endIndex + 1]) {
            beginIndex--;
            endIndex++;
        }
        if (endIndex - beginIndex > range[1] - range[0]) {
            range[0] = beginIndex;
            range[1] = endIndex;
        }
        return rs;
    }
}
