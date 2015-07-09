package com.frank.leetcode;

public class L143ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		int len = 0;
		ListNode curr = head;
		while (curr != null) {
			len++;
			curr = curr.next;
		}

		int halflen = len - len / 2;
		curr = head;
		int i = 0;
		while (i < halflen) {
			curr = curr.next;
			i++;
		}

		

		ListNode quick = iterReverse(curr);

		curr = head;
		i = 0;
		while (i < halflen) {
			ListNode slownext = curr.next;
			curr.next = quick;
			if (quick != null) {
				ListNode quicknext = quick.next;
				quick.next = slownext;
				quick = quicknext;
			}
			curr = slownext;
			i++;
		}
	}


	ListNode iterReverse(ListNode head) {
		ListNode pre=head;
		ListNode curr=pre.next;
		while(curr!=null){
			ListNode next=curr.next;
			curr.next=pre;
			pre=curr;
			curr=next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode curr=n1;
		for(int i=2;i<100000;i++){
			ListNode tmp=new ListNode(i);
			curr.next=tmp;
			curr=tmp;
		}
		new L143ReorderList().reorderList(n1);
	}

}
