package com.lifengdi.leetcode;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: 李锋镝
 * @date: 2021-01-21 17:16
 */
public class Solution3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = 0, result = 0;// 最大长度
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            // 当前字符在flag之后出现的下标
            int pos = s.indexOf(s.charAt(i), flag);
            // pos < i 说明当前字符之前出现过，属于重复字符
            if (pos < i) {
                // 判断maxLength和result大小
                result = Math.max(maxLength, result);
                // 如果剩余的字符串长度没有result大，则直接返回result
                if (result >= s.length() - 1 - pos) {
                    return result;
                }
                // 重新记录最大长度
                maxLength = i - pos -1;
                // 更新flag
                flag = pos + 1;
            }
            maxLength++;
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String s = "cddcdfe5cd";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
