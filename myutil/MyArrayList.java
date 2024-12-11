package myutil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* 1.动态扩容缩容
 * 2.索引越界检查
 * 3.删除元素防止内存泄漏
 */
public class MyArrayList<E> {
    private E[] data;
    private int size;
    private static final int INIT_CAP = 1;

    public MyArrayList() {
        this(INIT_CAP);
    }
    public MyArrayList(int initCapacity) {
        data = (E[]) new Object[initCapacity];
        size = 0;
    }

    //尾部增加元素
    public void addLast(E e) {
        int cap = data.length;
        if(this.size == cap) {
            resize(cap * 2);
        }
        data[size] = e;
        this.size++;
    }

    //增加元素
    public void add(int index, E e) {
        checkPositionIndex(index);

        int cap = data.length;
        if(size == cap) {
            resize(cap * 2);
        }

        for(int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        min();
        E temp = data[size - 1];
        data[size - 1] = null;
        size--;
        return temp;
    }

    public E remove(int index) {
        checkPositionIndex(index);
        min();
        E temp = data[index];
        for(int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        return temp;
    }

    public E removeFirst() {
        return remove(0);
    }

    public void min() {
        int cap = data.length;
        if(size <= cap / 4 && cap / 2 != 0) {
            resize(cap / 2);
        }
    }

    public E get(int index) {
        // 检查索引越界
        checkElementIndex(index);

        return data[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];
        for(int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }
}
