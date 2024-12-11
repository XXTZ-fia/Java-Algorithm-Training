//双链表
package myutil;

import java.util.NoSuchElementException;

/*
 * 1.同时持有头尾节点的引用
 * 2.虚拟头尾节点
 * 3.内存泄漏
 */
public class MyLinkedList<E> {
    private Node<E> head, tail;
    private int size;

    private static class Node<E> {
        E val;
        Node<E> next;
        Node<E> prev;

        Node(E val) {
            this.val = val;
        }
    }

    public MyLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    public void addLast(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = tail.prev;
        // temp <-> tail
        temp.next = x;
        x.prev = temp;

        x.next = tail;
        tail.prev = x;
        // temp <-> x <-> tail
        size++;
    }

    public void addFirst(E e) {
        Node<E> x = new Node<>(e);
        Node<E> temp = head.next;
        // head <-> temp
        temp.prev = x;
        x.prev = head;
        // head <-> x <-> temp
        x.next = temp;
        head.next = x;

        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);

        if(index == size) {
            addLast(e);
            return;
        }

        Node<E> p = getNode(index);
        Node<E> temp = p.prev;

        Node<E> x = new Node<>(e);
        // temp <-> p
        p.prev = x;
        x.next = p;
        // temp <-> x <-> p
        x.prev = temp;
        temp.next = x;

        size++;
    }

    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> x = head.next;
        Node<E> temp = x.next;
        // head <-> x <-> temp
        head.next = temp;
        temp.prev = head;

        x.prev = null;
        x.next = null;
        // head <-> temp
        size--;
        return x.val;
    }

    public E removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> x = tail.prev;
        Node<E> temp = x.prev;
        // temp <-> x <-> tail
        temp.next = tail;
        tail.prev = temp;

        x.prev = null;
        x.next = null;
        // temp <-> tail
        size--;
        return x.val;
    }

    public E remove(int index) {
        checkElementIndex(index);

        Node<E> x = getNode(index);
        Node<E> p = x.prev;
        Node<E> n = x.next;
        p.next = n;
        n.prev = p;

        x.prev = null;
        x.next = null;

        size--;
        return x.val;
    }

    public E get(int index) {
        checkElementIndex(index);
        Node<E> x = getNode(index);
        return x.val;
    }

    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    public E set(int index, E e) {
        checkElementIndex(index);

        Node<E> x = getNode(index);
        E oldVal = x.val;
        x.val = e;

        return oldVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node<E> getNode(int index) {
        Node<E> x = head.next;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    // 检查 index 索引位置是否可以存在元素
    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // 检查 index 索引位置是否可以添加元素
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void display() {
        System.out.println("size = " + size);
        for (Node<E> p = head.next; p != tail; p = p.next) {
            System.out.print(p.val + " -> ");
        }
        System.out.println("null");
        System.out.println();
    }

}
