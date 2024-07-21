package com.eric.algorithm.ch1;

public class FindLastKNode {
    public ListNode findLastKNode(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
    }
}
