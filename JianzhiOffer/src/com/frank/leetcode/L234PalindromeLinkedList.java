package com.frank.leetcode;

public class L234PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null)
			return true;
		ListNode slow=head;
		ListNode quick=head;
		while(quick!=null && quick.next!=null){
			slow=slow.next;
			quick=quick.next.next;
		}
		quick=head;
		
		ListNode curr=slow.next;
		ListNode pre=slow;
		pre.next=null;
		while(curr!=null){
			ListNode nextNode=curr.next;
			curr.next=pre;
			pre=curr;
			curr=nextNode;
		}
		
		while(pre!=null){
			if(pre.val!=quick.val)
				return false;
			pre=pre.next;
			quick=quick.next;
		}
		
		return true;
	}
}
