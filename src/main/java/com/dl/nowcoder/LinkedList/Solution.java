package com.dl.nowcoder.LinkedList;

/**
 * @author DML
 */
public class Solution {
    /**
     * 删除指定位置的元素
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode();
        ListNode slow = pre;
        pre.next = head;
        //找到指定位置的节点
        slow = findByIndex(pre, n);
        //删除指定位置的链表节点
        slow.next = slow.next.next;
//        System.out.println(slow.next);
//        System.out.println(head);
        //此处需要返回pre.next；而不能是head；当链表长度为1，且要删除的n=1时返回head则元原来的链表
        //当链表长度为1，且要删除的n=1时slow.next指向head节点，执行完代码之后slow.next为空，head还是原来的元素
        return pre.next;
    }

    public ListNode findByIndex(ListNode head, int n) {
//        //为了排除但列表的列表头元素的特殊性，使用哨法
//        ListNode pre = new ListNode();
//        pre.next = head;
        //双指针定位
        //定义快慢指针，指针间距为要找寻的特殊位置
        ListNode fast = head;
        ListNode slow = head;
        //确定快指针的位置
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        //找到指定位置的链表元素
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 逆置链表：
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //定义两个节点，cur保存当前位置 pre保存上一个节点
        //定义一个临时节点，保存当前位置
        ListNode pre = null;
        ListNode cur = head;
        ListNode tem = head;
        //cur/tem为空说明链表只有一个节点，无法逆置
        //
        while (tem != null) {
            //先把临时节点向后移动
            tem = tem.next;
            //修改当前节点next的指向
            cur.next = pre;
            //前一个节点不能从原链表走，否则会链表中断
            pre = cur;
            if (tem != null) {
                cur = tem;
            }
        }
        return cur;
    }

    /**
     * 合并两个升序的链表
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode temp = new ListNode();
        ListNode res = temp;
        //两个链表中有一个为空时直接返回不为空的哪一个
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }
        //均不为空时对比大小
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                temp.next = list2;
                list2 = list2.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
            }
            temp = temp.next;
        }
        //有一个链表结束之后，结果链表指向没有结束的链表
        temp.next = list1 == null ? list2 : list1;
        return res.next;
    }

    /**
     * 获得一个链表存储1,2,3,4,5
     *
     * @return
     */
    public ListNode initListNode() {
        ListNode head = new ListNode();
        ListNode temp = new ListNode();
        head = temp;

        for (int i = 1; i <= 5; i++) {
            ListNode listNode = new ListNode(i);
            temp.next = listNode;
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = solution.initListNode();
        ListNode headPre = head;
        while (headPre != null) {
            System.out.print(headPre.val);
            headPre = headPre.next;
        }
        head = solution.reverseList(head);
        System.out.println("--------------");
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
