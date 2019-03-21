package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tom
 * @date : 2019-03-21 17:40
 **/
public class WordPattern {

    /**
     * 290
     *
     * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
     *
     * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
     *
     * 示例1:
     *
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     * 示例 2:
     *
     * 输入:pattern = "abba", str = "dog cat cat fish"
     * 输出: false
     * 示例 3:
     *
     * 输入: pattern = "aaaa", str = "dog cat cat dog"
     * 输出: false
     * 示例 4:
     *
     * 输入: pattern = "abba", str = "dog dog dog dog"
     * 输出: false
     */

    public static boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (strArr.length != pattern.length()) {return false;}
        Map<Character, String> m1 = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            if (m1.containsKey(a)) {
                if (!m1.get(a).equals(strArr[i])) {
                    return false;
                }
            } else if (m1.containsValue(strArr[i])) {
                return false;
            } else {
                m1.put(a, strArr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));;
    }
}
