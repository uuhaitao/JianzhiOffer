package com.frank.leetcode;

public class L138CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode newhead = null;
		if (head == null)
			return null;
		
		RandomListNode curr=head;
		while(curr!=null){
			int val=curr.label;
			RandomListNode copy=new RandomListNode(val);
			copy.next=curr.next;
			curr.next=copy;
			curr=copy.next;
		}
		
		curr=head;
		while(curr!=null){
			curr.next.random=curr.random==null?null:curr.random.next;
			curr=curr.next.next;
		}
		
		newhead=head.next;
		curr=head;
		while(curr!=null){
			RandomListNode newElement=curr.next;
			curr.next=newElement.next;
			if(newElement.next!=null){
				newElement.next=newElement.next.next;
			}
			curr=curr.next;
		}
		
		return newhead;
	}
}
