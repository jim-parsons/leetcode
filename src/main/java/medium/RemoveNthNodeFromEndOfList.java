package medium;

/**
 * @author : tom
 * @date : 2019-03-21 16:10
 **/
public class RemoveNthNodeFromEndOfList {

    /**
     * 19
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     */
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head, target = head;
        while (cur != null) {
            if (n >= 0) {
                n--;
            } else {
                target = target.next;
            }
            cur = cur.next;
        }
        if (n == 0) {
            head = head.next;
            return head;
        }
        target.next = target.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        System.out.println(removeNthFromEnd(n1, 2).val);;
    }
}
