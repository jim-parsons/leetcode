package hard;

import java.util.LinkedHashMap;

/**
 * @date : 2019-02-14 15:13
 **/
public class LRUCache<K, V> {

    private final LinkedHashMap<K, V> linkedHashMap;

    public LRUCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }

        this.linkedHashMap = new LinkedHashMap<K, V>(16, 0.75f, true);
    }
}
