package com.frank.leetcode;

public class L206ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head==null)
			return null;
		recursive(head);
		return newhead;
	}
	ListNode newhead;
	ListNode recursive(ListNode head){
		if(head.next==null){
			newhead=head;
			return head;
		}
		ListNode n=recursive(head.next);
		n.next=head;
		head.next=null;
		return head;
	}
	public static void main(String[] args) {
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		n1.next=n2;
		n2.next=n3;
		
		ListNode n=new L206ReverseLinkedList().reverseList(n1);
		System.out.println(n.val);
	}
	
}
