package net.acmicpc;

import java.util.Scanner;

// class는 필드  - 상태 , 메서드 - 행위
//class 첫문자는 대문자 변수는 소문자 
public class Solution_10828_스택 {
	static class MyStack {
		int stack[] = new int[10001];
		int top = -1;

		public void push(int X) {
			stack[++top] = X;
		}

		public int pop() {			
			if (top >= 0) {
				int store = stack[top];
				stack[top--] = 0;
				return store;
			}
			return -1;
		}

		public int size() {
			return top + 1;
		}

		public int empty() {
			if (top ==-1) {
				return 1;
			}
			return 0;
		}

		public int top() {
			if (empty()==1) {
				return -1;
			}
			return stack[top];
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		MyStack mystack = new MyStack();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i <N; i++) {
			String line = scan.nextLine();
			String str[] = line.split(" "); //공백 기준으로 자른다. 
			String operation = str[0];
			
			switch (operation) {
			case "push":
				mystack.push(Integer.parseInt(str[1]));
				break;
			case "top":
				sb.append(mystack.top()).append('\n');
				break;
			case "size":
				sb.append(mystack.size()).append('\n');
				break;
			case "empty":
				sb.append(mystack.empty()).append('\n');
				break;
			case "pop":
				sb.append(mystack.pop()).append('\n');
				break;
			}
			
		}
		System.out.println(sb);

	}

}
