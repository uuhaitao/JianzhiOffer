package com.frank.leetcode;

/*
 * Merge k Sorted Lists
 */

public class L23MergekSortedLists {

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
		if (la != null)
			curr.next = la;
		if (lb != null)
			curr.next = lb;
		return res.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		
		if(lists==null ||lists.length==0){
			return null;
		}
		if(lists.length==1)
			return lists[0];
		int lens=lists.length;
		int left_len=lens/2;
		ListNode[] left=new ListNode[left_len];
		ListNode[] right=new ListNode[lens-left_len];
//		int right
		for(int i=0;i<left_len;i++){
			left[i]=lists[i];
		}
		for(int j=0;j<lens-left_len;j++){
			right[j]=lists[j+left_len];
		}
		
		ListNode l1=mergeKLists(left);
		ListNode l2=mergeKLists(right);
		
		return mergeTwoLists(l1,l2);
	}


}
