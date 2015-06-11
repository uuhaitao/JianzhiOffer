package com.frank.leetcode;

public class L24swapNodesinPairs {

	 public ListNode swapPairs(ListNode head) {
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

}
