package com.programmers2;

import java.util.Stack;

//stack 말고도 count로도 풀어보기!!
public class Solution_올바른괄호 {
	
	public static void main(String[] args) {
		Solution("()()()))))((((");
	}

	public static boolean Solution(String s) {
		Stack<Character> stack = new Stack<Character>();
		if (s.length() == 1)
			return false;
		else {
			for (int i = 0; i < s.length(); i++) {
				if (stack.isEmpty()) {
					if (s.charAt(i) == ')')
						return false;
					else
						stack.push(s.charAt(i));
				} else {
					if (stack.peek() != s.charAt(i)) {
						stack.pop();
					} else {
						stack.push(s.charAt(i));
					}
				}
			}
		}
		if (stack.isEmpty())
			return true;
		return false;
	}
}
