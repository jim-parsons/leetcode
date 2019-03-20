package medium;

/**
 * @author : tom
 * @date : 2019-03-20 11:18
 **/
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 3
     *
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */

    public int lengthOfLongestSubstring(String s) {
        char[] chars = new char[256];
        int i = 0, j = 0;
        int max = 0;
        while (i < s.length()) {
            if (j < s.length() && chars[s.charAt(j)] == 0) {
                chars[s.charAt(j++)]++;
            } else {
                chars[s.charAt(i++)]--;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    }
}
