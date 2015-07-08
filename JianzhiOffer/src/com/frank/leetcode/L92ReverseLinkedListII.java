package com.frank.leetcode;

public class L92ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n || head == null)
			return head;
		if (m == 1) {
			recursive(head, n - m, 0);
			return newhead;
		}
		int i = 1;
		ListNode curr = head.next;
		ListNode pre = head;
		while (++i < m) {
			pre = curr;
			curr = curr.next;
		}
		recursive(curr, n - m, 0);
		
		pre.next = newhead;
		curr.next = nextnode;
		return head;
	}

	ListNode newhead;
	ListNode nextnode;

	ListNode recursive(ListNode head, int len, int i) {
		if (len == i) {
			newhead = head;
			nextnode = head.next;
			return head;
		}
		ListNode n = recursive(head.next, len, i + 1);
		n.next = head;
		head.next = null;
		return head;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode n = new L92ReverseLinkedListII().reverseBetween(n1, 2, 3);
		System.out.println(n.val);
	}
}
