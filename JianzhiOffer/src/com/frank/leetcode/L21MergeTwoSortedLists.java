package com.frank.leetcode;

/*
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */

public class L21MergeTwoSortedLists {


	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode la = l1;
		ListNode lb = l2;

		ListNode curr = new ListNode(0);
		ListNode res = curr;

		while (la != null && lb != null) {

			if (la.val < lb.val) {
				curr.next = la;
				curr = la;
				la = la.next;
			} else {
				curr.next = lb;
				curr = lb;
				lb = lb.next;
			}
		}
		if(la!=null)
			curr.next=la;
		if(lb!=null)
			curr.next=lb;
		
		
		return res.next;
	}
}
