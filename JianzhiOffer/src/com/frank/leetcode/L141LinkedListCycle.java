package com.frank.leetcode;

public class L141LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head==null)
			return false;
		ListNode slow=head;
		ListNode quick=head;
		while(quick!=null && quick.next!=null){
			slow=slow.next;
			quick=quick.next.next;
			if(quick==slow)
				return true;
		}
		return false;
	}
}
