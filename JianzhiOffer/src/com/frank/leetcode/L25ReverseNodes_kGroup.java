package com.frank.leetcode;

public class L25ReverseNodes_kGroup {
	
    boolean hasKnode(ListNode head, int k){
		ListNode l=head;
		int i=0;
		while(l!=null ){
			i++;
			l=l.next;
			if(i>=k)
				return true;
		}
		return false;
	}
	ListNode get_K(ListNode begin,int k){
		ListNode current=begin;
		int n=0;
		while(n<k){
			current=current.next;
			n++;
		}
		return current;
	}
    
	ListNode reverse_K(ListNode begin,int k){
		ListNode previous=begin;
		ListNode curr=begin.next;
		previous.next=null;
		int n=1;
		while(curr!=null&& n<k){
			ListNode nextN=curr.next;
			curr.next=previous;
			previous=curr;
			curr=nextN;
			n++;
		}
		return previous;
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k==1 ||! hasKnode(head,k))
			return head;
		ListNode curr = head;
		ListNode pre = new ListNode(-1);
		ListNode res = pre;
		while (curr != null && hasKnode(curr,k)) {
			ListNode K_1Node=get_K(curr,k);
			
			ListNode tmp_new=reverse_K(curr,k);
			pre.next=tmp_new;
			pre=tmp_new;
			while(pre!=null && pre.next!=null){
				pre=pre.next;
			}
			curr=K_1Node;
		}
		
		if (curr != null)
			pre.next = curr;

		return res.next;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next=n5;

		new L25ReverseNodes_kGroup().reverseKGroup(head, 2);
	}
	

}
