package com.frank.leetcode;

public class L203RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		ListNode curr=head;
		while(curr!=null && curr.val==val){
			curr=curr.next;
		}
		if(curr==null)
			return null;
		ListNode res=curr;
		while(curr!=null && curr.next!=null){
			if(curr.next.val==val){
				curr.next=curr.next.next;
			}else{
				curr=curr.next;
			}
		}
		
		return res;
	}

}
