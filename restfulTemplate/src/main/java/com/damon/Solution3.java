package com.damon;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 示例：
 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807
 */
class Solution3 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1==null||l2==null){return l1==null?l2:l1;}
        ListNode l1Next=l1.next;
        ListNode l2Next=l2.next;
        ListNode l3return =new ListNode(l1.val+l2.val);
        ListNode l3n = l3return;
        while(l1Next!=null||l2Next!=null){
            l3n.next= new ListNode( (l1Next==null?0:l1Next.val)+ (l2Next==null?0:l2Next.val));
            l3n=l3n.next;
            l1Next = l1Next==null?null:l1Next.next;
            l2Next = l2Next==null?null:l2Next.next;
        }
        for (ListNode l3Next=l3return;l3Next!=null;){
            if (l3Next.val>=10){
                l3Next.val-=10;
                if (l3Next.next==null){
                    l3Next.next  = new ListNode(1);
                }else{
                    l3Next.next.val+=1;
                }
            }
            l3Next=l3Next.next;
        }
        return l3return;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        listNode.next=listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next =listNode2;

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        listNode3.next =listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next =listNode5;

        ListNode listNode6 = addTwoNumbers(listNode, listNode3);
        System.out.println(listNode6);
    }
}
