package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : tom
 * @date : 2019-03-20 19:07
 **/
public class ValidAnagram {

    /**
     * 242
     *
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
     *
     * 示例 1:
     *
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     *
     * 输入: s = "rat", t = "car"
     * 输出: false
     *
     */

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c)-1);
            }
        }
        for (Integer integer : map.values()) {
            if (integer != 0) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnagram1(String s, String t) {
        // 建立字符表
        int[] stable = new int[26];
        int[] ttable = new int[26];
        for (char c : s.toCharArray()) {
            stable[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            ttable[c - 'a']++;
        }
        for (int i = 0; i < stable.length; i++) {
            if (stable[i] != ttable[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram v = new ValidAnagram();
        System.out.println(v.isAnagram("anagram", "nagaram"));
    }
}
