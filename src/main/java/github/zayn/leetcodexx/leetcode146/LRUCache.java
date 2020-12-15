package github.zayn.leetcodexx.leetcode146;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 */
public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int cap;
    /**
     * 保持插入顺序
     */
    private Map<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.keySet().contains(key)) {
            int value = map.get(key);
            map.remove(key);
            // 保证每次查询后，都在末尾
            map.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.keySet().contains(key)) {
            map.remove(key);
        } else if (map.size() == cap) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key, value);
    }
}


