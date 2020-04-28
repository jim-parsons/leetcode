package study;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private HashMap<Integer, Node> map;

    private DoubleList cache;

    private int cap;

    public LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        cache = new DoubleList();
    }


    public int get(int key) {
        if(!map.containsKey(key)) return -1;


        int val = map.get(key).val;
        // 添加到头部
        put(key, val);
        return val;
    }

    private void put(int key, int val) {
        Node x = new Node(key, val);

        if(map.containsKey(key)) {
            Node last = map.get(key);
            cache.remove(last);
            cache.addFirst(x);
        } else {
            if(this.cap == cache.size()) {
                // 先删除最后一个
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
        }
        map.put(key, x);
    }








    class Node {
        public int key;
        public int val;

        public Node next;
        public Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class DoubleList {
        private Node head, tail;

        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }


        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;

            head.next.prev = x;
            head.next = x;
            size++;
        }


        public void remove(Node x) {
            // prev - x - next

            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }


        public Node removeLast() {
            if(tail.prev == head) {
                return null;
            }

            Node last = tail.prev;

            remove(last);
            return last;
        }

        public int size() {return  size;}

    }

}
