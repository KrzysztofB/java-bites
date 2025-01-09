package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Data class for
 * @see AddTwoNumbers
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int... values) {
        ListNode node = null;
        for (int idx = values.length - 1; idx >= 0; idx--) {
            node = new ListNode(values[idx], node);
        }
        return node;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    public List<Integer> toList() {
        var result = new ArrayList<Integer>();
        ListNode node = this;
        while(node!=null){
            result.add(node.val);
            node = node.next;
        }
        return result;
    }
}
