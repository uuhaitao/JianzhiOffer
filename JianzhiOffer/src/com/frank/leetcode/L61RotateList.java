package com.frank.leetcode;

/**
 * Created by haitao on 7/18/15.
 *
 * Given a list, rotate the list to the right by k places, where k is non-negative.

 For example:
 Given 1->2->3->4->5->NULL and k = 2,
 return 4->5->1->2->3->NULL.
 *
 *
 */
public class L61RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null || head.next==null || k==0)
            return head;
        int len=0;
        ListNode tmp=head;
        while (tmp!=null)
        {
            len++;
            tmp=tmp.next;
        }
        k%=len;
        if (k==0)
            return head;
        int c=0;

        ListNode newhead=null;
        ListNode slow=head;
        ListNode quick=head;
        while (c++<k)
            quick=quick.next;
        if(quick==null)
        {
            ListNode previous=head;
            ListNode curr=head.next;
            previous.next=null;
            while(curr!=null){
                ListNode nextN=curr.next;
                curr.next=previous;
                previous=curr;
                curr=nextN;
            }
            return previous;
        }
        while (quick!=null && quick.next!=null)
        {
            quick=quick.next;
            slow=slow.next;
        }
        newhead=slow.next;
        slow.next=null;
        quick.next=head;

        return newhead;
    }
    public static void main(String[]args)
    {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(4);
        ListNode l5=new ListNode(5);
        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        new L61RotateList().rotateRight(l1,3);

    }
}
