package easy;

/**
 * @author : tom
 * @date : 2019-03-21 19:43
 **/
public class LongestPalindrome {
    /**
     * 409
     *
     * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
     *
     * 注意:
     * 假设字符串的长度不会超过 1010。
     *
     * 示例 1:
     *
     * 输入:
     * "abccccdd"
     *
     * 输出:
     * 7
     *
     * 解释:
     * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
     *
     * 回文字符串的长度= 偶数个字符长度+所有（奇数字符长度-1）+一个长度为一的元素（放在回文字符串的最中间）
     * 存在这种情况，没有长度为一的字符串，此时如果有奇数长度的字符串
     */

    public int longestPalindrome(String s) {
        // 如果出现偶数次,那么可以构建回文串
        // 如果出现奇数次,那么(奇数-1)也可以
        char[] lower = new char[26];
        char[] upper = new char[26];
        for (char c : s.toCharArray()) {
            if (c >= 97) {
                lower[c - 'a']++;
            } else {
                upper[c - 'A']++;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            // 输出结果都是双数
            // 因为先除2,在乘2,对于偶数来说没变化,但是对于奇数会变
            res += (lower[i] / 2) * 2;
            res += (upper[i] / 2) * 2;
        }
        // res 等于原长度才是
        return res == s.length() ? res : res + 1;
    }

}
