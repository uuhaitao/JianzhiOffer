package com.frank.leetcode;

public class L24swapNodesinPairs {

	public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
			return head;
			
		ListNode curr = head;
		ListNode pre=new ListNode(-1);
		ListNode res=pre;
		
		while (curr != null && curr.next != null) {
		    ListNode second=curr.next;
		    ListNode third=second.next;
		    second.next=curr;
		    curr.next=null;
		    pre.next=second;
			pre=curr;
		    curr = third;
		}
		if(curr!=null)
			pre.next=curr;
		
		return res.next;
    }

	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode n4=new ListNode(4);
		head.next=n2;
		n2.next=n3;
		n3.next=n4;
		
		swapPairs(head);
		
	}

}
