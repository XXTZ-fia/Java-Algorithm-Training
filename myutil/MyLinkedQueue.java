package myutil;

public class MyLinkedQueue <E> {
    private MyLinkedList<E> list = new MyLinkedList<>();

    public void push(E e) {
        list.addLast(e);
    }

    public E pop() {
        return list.removeFirst();
    }

    public E peek() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }
}
