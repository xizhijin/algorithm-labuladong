package com.eric.algorithm.ch1;

public class RemoveLastKNode {

    public ListNode removeLastKNode(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        FindLastKNode findLastKNode = new FindLastKNode();
        ListNode x = findLastKNode.findLastKNode(head, k+1);
        x.next = x.next.next;
        return dummy.next;
    }
}
