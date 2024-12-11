package src;
import java.util.ArrayList;
public class ArrayListTest {
    static public void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            // 在末尾追加元素，时间复杂度 O(1)
            arr.add(i);
        }

        // 在中间插入元素，时间复杂度 O(N)
        // 在索引 2 的位置插入元素 666
        arr.add(2, 666);

        // 在头部插入元素，时间复杂度 O(N)
        arr.add(0, -1);

        // 删除末尾元素，时间复杂度 O(1)
        arr.remove(arr.size() - 1);

        // 删除中间元素，时间复杂度 O(N)
        // 删除索引 2 的元素
        arr.remove(2);

        // 根据索引查询元素，时间复杂度 O(1)
        int a = arr.get(0);

        // 根据索引修改元素，时间复杂度 O(1)
        arr.set(0, 100);

        // 根据元素值查找索引，时间复杂度 O(N)
        int index = arr.indexOf(666);
    }

}
