package medium;

import java.util.*;

/**
 * @author : tom
 * @date : 2019-03-21 16:38
 **/
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        List<List<String>> res = new ArrayList<List<String>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (String str : strs) {
            int key = 1;
            for (Character c : str.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<String>();
                res.add(t);
                map.put(key, res.size()-1);
            }
        }
        return res;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
