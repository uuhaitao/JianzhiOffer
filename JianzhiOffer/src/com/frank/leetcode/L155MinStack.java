package com.frank.leetcode;

import java.util.Stack;

public class L155MinStack {
	Stack<Integer> coreStack=new Stack<Integer>();
	Stack<Integer> MinStack=new Stack<Integer>();
	
	public void push(int x) {
		coreStack.push(x);
		if(MinStack.isEmpty() || x<=MinStack.peek())
			MinStack.push(x);
	}

	public void pop() {
		int val=coreStack.pop();
		if(val<=MinStack.peek())
			MinStack.pop();
	}

	public int top() {
		return coreStack.peek();
	}

	public int getMin() {
		if(!MinStack.isEmpty())
			return MinStack.peek();
		return 0;
	}
}
