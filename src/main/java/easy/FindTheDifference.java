package easy;

/**
 * @author : tom
 * @date : 2019-03-21 19:01
 **/
public class FindTheDifference {

    /**
     * 389
     *
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     *
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     *
     * 请找出在 t 中被添加的字母。
     *
     *
     *
     * 示例:
     *
     * 输入：
     * s = "abcd"
     * t = "abcde"
     *
     * 输出：
     * e
     *
     * 解释：
     * 'e' 是那个被添加的字母。
     */

    public static char findTheDifference(String s, String t) {
        int sum = 0;
        for (char c : t.toCharArray()) {
            sum += c;
        }
        for (char c : s.toCharArray()) {
            sum -= c;
        }
        return (char) sum;
    }

    public static char findTheDifference1(String s, String t) {
        char c = t.charAt(t.length()-1);
        for (int i = 0; i < s.length(); i++) {
            c ^= (s.charAt(i) ^ t.charAt(i));
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
