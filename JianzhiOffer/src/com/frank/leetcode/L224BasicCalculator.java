package com.frank.leetcode;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class L224BasicCalculator {
	public int calculate(String s) throws Exception {
		char[] chars = s.trim().toCharArray();
		if (chars.length == 0)
			return 0;
		int res=0;
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ')
				continue;
			if (chars[i] == ')') {
				String tmp = "";
				while (!stack.isEmpty() && !stack.peek().equals("(")) {
					tmp = stack.pop() + tmp;
				}
				stack.pop();
				stack.push(toval(tmp) + "");
			} else {
				stack.push(chars[i] + "");
			}

		}
		String tmp = "";
		while (!stack.isEmpty() && !stack.peek().equals("(")) {
			tmp = stack.pop() + tmp;
		}
		res=toval(tmp);
		return res;
	}

	int toval(String s) throws ScriptException {
		if (s == null || s.trim().length() == 0)
			return 0;
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");
		return (int) se.eval(s);
	}

	public static void main(String[] args) throws Exception {
		int n=new L224BasicCalculator().calculate("(1+1)-(1-1)+(1+(2+5))");
		System.out.println(n);
	}

}
