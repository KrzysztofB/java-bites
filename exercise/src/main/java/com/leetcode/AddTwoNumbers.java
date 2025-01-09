package com.leetcode;

/**
 * @see <a href="https://leetcode.com/problems/add-two-numbers/">Add Two Numbers at Leetcode</a>
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        var result = new ListNode();
        var current = result;
        int carry = 0;
        while (true) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.val = sum % 10;
            carry = sum / 10;
            if (l1 != null || l2 != null) {
                var next = new ListNode();
                current.next = next;
                current = next;
            } else {
                if (carry > 0) {
                    var next = new ListNode();
                    current.next = next;
                    current = next;
                    current.val = carry;
                }
                break;
            }
        }
        return result;
    }
}
