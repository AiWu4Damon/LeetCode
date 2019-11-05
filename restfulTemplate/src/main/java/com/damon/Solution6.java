package com.damon;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 反转一个单链表
 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 进阶:
 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */


class Solution6 {
    public static ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){return head;}
        ListNode listNode = reverseList(head.next);
        for (ListNode initNode=listNode;;){
            if (initNode.next==null){
                initNode.next=head;
                head.next=null;
                break;
            }
            initNode = initNode.next;
        }
        return listNode;
    }

    public static void main(String[] args) {
//        //1->2->3->4->5->NULL
//        ListNode listNode = new ListNode(1);
//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(5);
//        listNode.next=listNode1;
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        ListNode listNode5 = reverseList(listNode);
//        System.out.println(listNode5);
        System.out.println(dataBaseColumnToJava("prod_name_no"));
    }

    private static String dataBaseColumnToJava(String dataBasekey){
        Matcher matcher = Pattern.compile("_(\\w)").matcher(dataBasekey);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }


}