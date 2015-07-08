package com.frank.leetcode;

public class L160IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		if (headA == headB)
			return headA;
		int la = getlength(headA);
		int lb = getlength(headB);
		int gap = Math.abs(la - lb);

		ListNode na = headA;
		ListNode nb = headB;

		if (gap > 0) {
			int step = 0;
			if (la > lb) {
				while (step < gap) {
					step++;
					na = na.next;
				}
			}
			if (la < lb) {
				while (step < gap) {
					step++;
					nb = nb.next;
				}
			}
		}

		while (na != null && nb != null && na != nb) {
			na=na.next;
			nb=nb.next;
		}
		if (na == nb)
			return na;
		else
			return null;
	}

	int getlength(ListNode head) {
		if (head == null)
			return 0;
		int len = 0;
		ListNode curr = head;
		while (curr != null) {
			len++;
			curr = curr.next;
		}
		return len;
	}
}
