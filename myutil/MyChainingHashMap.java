package myutil;
import java.util.LinkedList;

// 用拉链法实现哈希表
public class MyChainingHashMap {
    static class KVNode {
        int key;
        int value;

        public KVNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    // 底层 table 数组中的每个元素是一个链表
    private LinkedList<KVNode>[] table;

    public MyChainingHashMap(int capacity) {
        table = new LinkedList[capacity];
    }

    private int hash(int key) {
        return key % table.length;
    }

    public int get(int key) {
        int index = hash(key);

        if(table[index] == null) {
            return -1;
        }

        LinkedList<KVNode> list = table[index];
        // 遍历链表
        for (KVNode node : list) {
            if (node.key == key) {
                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            // 链表为空，新建一个链表，插入 key-value
            table[index] = new LinkedList<>();
            table[index].add(new KVNode(key, value));
            return;
        }

        LinkedList<KVNode> list = table[index];
        for (KVNode node : list) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        list.addLast(new KVNode(key, value));
    }

    public void remove(int key) {
        LinkedList<KVNode> list = table[hash(key)];
        if (list == null) {
            return;
        }

        // 如果 key 存在，则删除
        // 这个 removeIf 方法是 Java LinkedList 的方法，可以删除满足条件的元素，时间复杂度 O(N)
        list.removeIf(node -> node.key == key);
    }



}
