package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tom
 * @date : 2019-03-21 17:33
 **/
public class IsomorphicStrings {

    /**
     * 205
     *
     * 给定两个字符串 s 和 t，判断它们是否是同构的。
     *
     * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
     *
     * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
     *
     * 示例 1:
     *
     * 输入: s = "egg", t = "add"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "foo", t = "bar"
     * 输出: false
     * 示例 3:
     *
     * 输入: s = "paper", t = "title"
     * 输出: true
     */

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {return false;}
        Map<Character, Character> m1 = new HashMap<Character, Character>(s.length());
        Map<Character, Character> m2 = new HashMap<Character, Character>(t.length());
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (m1.containsKey(a) && m1.get(a) != b) {
                return false;
            } else if (m2.containsKey(b) && m2.get(b) != a) {
                return false;
            } else {
                m1.put(a, b);
                m2.put(b, a);
            }
        }
        return true;
    }
}
