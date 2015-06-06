package com.frank.leetcode;

/*
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

public class L2addTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode la = l1;
		ListNode lb = l2;
		int sum = 0;

		ListNode res = new ListNode((l1.val + l2.val) % 10);
		int bit = (l1.val + l2.val)/10;
		la=la.next;
		lb=lb.next;
		ListNode cur=res;
		while (la != null && lb != null) {
			sum = la.val + lb.val + bit;
			ListNode n = new ListNode(sum % 10);
			bit = sum / 10;
			cur.next = n;
			cur=n;
			la = la.next;
			lb = lb.next;
		}

		while (null != la) {
			sum = la.val + bit;
			ListNode n = new ListNode(sum % 10);
			bit = sum / 10;
			la = la.next;
			cur.next = n;
			cur=n;
		}

		while (lb != null) {
			sum = lb.val + bit;
			ListNode n = new ListNode(sum % 10);
			bit = sum / 10;
			lb = lb.next;
			cur.next = n;
			cur=n;
		}
		if (bit > 0) {
			cur.next = new ListNode(bit);
		}

		return res;
	}

	public static void main(String[] args) {
		ListNode la2 = new ListNode(1);
//		ListNode la4 = new ListNode(4);
//		ListNode la3 = new ListNode(3);
//		la2.next = la4;
//		la4.next = la3;

		ListNode lb4 = new ListNode(9);
		ListNode lb6 = new ListNode(9);
//		ListNode lb5 = new ListNode(5);
		lb4.next = lb6;
//		lb6.next = lb5;

		ListNode l = addTwoNumbers(la2, lb4);
		while (l != null) {
			System.out.println(l.val);
			l = l.next;
		}

	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}