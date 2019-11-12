package com.junkai.leetcode.code01;

/**
 * 思路-连标：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class TwoNumberAdd {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1、定义dummyHead用来存储结果
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        // 2、判断链表是否全为空
        while (p != null || q != null) {
            // 3、获取对应位相加的两数
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            // 4、计算两数的和
            int sum = carry + x + y;
            // 5、计算和的进位
            carry = sum / 10;
            // 6、存储和的余数
            curr.next = new ListNode(sum % 10);
            // 7、节点长度+1
            curr = curr.next;
            // 8、递归调用
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
