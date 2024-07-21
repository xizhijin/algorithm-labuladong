package com.eric.algorithm.ch1;

public class ListSegSort {
    /**
     * 对链表进行分区，将值大于等于x的节点放在小于x的节点之后，并保持两部分内部的相对顺序。
     *
     * @param head 链表的头节点
     * @param x 分区值
     * @return 分区后的链表的头节点
     */
    public ListNode listSegSort(ListNode head, int x) {
        // 创建两个哑节点dummy1和dummy2，分别用于构建小于x和大于等于x的两个链表部分
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        // p1和p2分别指向dummy1和dummy2，用于遍历过程中连接节点
        ListNode p1 = dummy1, p2 = dummy2;
        // p用于遍历原链表
        ListNode p = head;

        while (p != null) {
            if (p.val >= x) {
                // 如果当前节点的值大于等于x，将其接到p2指向的链表的尾部
                p2.next = p;
                p2 = p2.next;
            } else {
                // 如果当前节点的值小于x，将其接到p1指向的链表的尾部
                p1.next = p;
                p1 = p1.next;
            }

            // 保存当前节点的下一个节点，准备断开当前节点与其下一个节点的连接
            ListNode temp = p.next;
            // 断开当前节点与其下一个节点的连接，为分区操作做准备
            p.next = null;
            // 将p指向下一个待处理的节点
            p = temp;
        }

        // 将小于x的链表的尾部连接到大于等于x的链表的头部
        p1.next = dummy2.next;
        // 防止形成环，需要将大于等于x的链表的尾部的next设置为null
        dummy2.next = null;
        // 返回分区后链表的头节点
        return dummy1.next;
    }
}
