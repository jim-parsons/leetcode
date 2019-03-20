package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : tom
 * @date : 2019-03-20 14:22
 **/
public class FindAllAnagramsInAString {

    /**
     * 438
     *
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     *
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     *
     * 说明：
     *
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     * 示例 1:
     *
     * 输入:
     * s: "cbaebabacd" p: "abc"
     *
     * 输出:
     * [0, 6]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     *  示例 2:
     *
     * 输入:
     * s: "abab" p: "ab"
     *
     * 输出:
     * [0, 1, 2]
     *
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {return list;}
        char[] chars = new char[256];
        for (char c : p.toCharArray()) {
            chars[c]++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            if (chars[s.charAt(right++)]-- >= 1) {
                count--;
            }
            if (count==0){
                list.add(left);
            }
            // 1. 保证窗口长度不变
            // 2. 窗口左边右移,
            if (left-right==p.length() && chars[s.charAt(left++)]++ >= 0) {
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString f = new FindAllAnagramsInAString();
        System.out.println(f.findAnagrams("cbaebabacd", "abc"));
    }
}
