package com.lifengdi.leetcode;

import java.util.Objects;

/**
 * @author: 李锋镝
 * @date: 2021-01-19 13:05
 */
public class Solution2 {

    public static class ListNode {
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
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return execute(l1, l2, 0);
    }

    private static ListNode execute(ListNode l1, ListNode l2, int bit) {
        ListNode rs = new ListNode();
        if (Objects.isNull(l1) && Objects.isNull(l2)) {
            if (bit > 0) {
                rs.val = bit;
                return rs;
            }
            return null;
        }
        boolean l1NotNull = Objects.nonNull(l1);
        boolean l2NotNull = Objects.nonNull(l2);
        int v1 = l1NotNull ? l1.val : 0;
        int v2 = l2NotNull ? l2.val : 0;
        int v = v1 + v2 + bit;
        bit = 0;
        if (v > 9) {
            v = v - 10;
            bit = 1;
        }
        rs.val = v;
        ListNode l1Next = l1NotNull ? l1.next : null;
        ListNode l2Next = l2NotNull ? l2.next : null;
        rs.next = execute(l1Next, l2Next, bit);

        return rs;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(5))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode listNode = addTwoNumbers(l1, l2);
        while (true) {
            System.out.println(listNode.val);
            listNode = listNode.next;
            if (Objects.isNull(listNode)) {
                break;
            }
        }
    }
}
