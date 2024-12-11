package src;
public class LinkListTest {
    // 输入一个数组，转换为一条单链表
    ListNode createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // 创建一条单链表
        LinkListTest test = new LinkListTest();
        ListNode head = test.createLinkedList(new int[]{1, 2, 3, 4, 5});

        // 遍历单链表
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}