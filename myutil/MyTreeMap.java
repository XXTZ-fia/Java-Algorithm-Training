package myutil;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyTreeMap {
    // 大写 K 为键的类型，大写 V 为值的类型
    class TreeNode<K, V> {
        K key;
        V value;

        TreeNode<K, V> left;
        TreeNode<K, V> right;
        TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    
}
