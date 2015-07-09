package com.frank.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class L225ImplementStackusingQueues {
	Queue<Integer> que1 = new LinkedList<Integer>();
	Queue<Integer> que2 = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		if (que1.isEmpty()) {
			que2.add(x);
		} else
			que1.add(x);

	}

	// Removes the element on top of the stack.
	public void pop() {
		if (que1.isEmpty()) {
			while (que2.size() > 1) {
				que1.add(que2.poll());
			}
			que2.poll();
		} else {
			while (que1.size() > 1) {
				que2.add(que1.poll());
			}
			que1.poll();
		}
	}

	// Get the top element.
	public int top() {
		int val=0;
		if (que1.isEmpty()) {
			while (que2.size() > 1) {
				que1.add(que2.poll());
			}
			val=que2.poll();
			que1.add(val);
		} else {
			while (que1.size() > 1) {
				que2.add(que1.poll());
			}
			val=que1.poll();
			que2.add(val);
		}
		return val;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return que1.isEmpty() && que2.isEmpty();
	}

	public static void main(String[] args) {
		L225ImplementStackusingQueues stack=new L225ImplementStackusingQueues();
		stack.push(1);
		stack.push(2);
		stack.pop();
		System.out.println(stack.top());
	}

}
