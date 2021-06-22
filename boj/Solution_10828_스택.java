package net.acmicpc;

import java.util.Scanner;

public class Solution_10828_스택 {
	static class MyStack{		
		int store[]=new int[100001];
		int top = -1; //스택의 상태
		public void push(int X) {
			store[++top] = X;	
		}
		public int pop() {
			if(top>=0) {
				int value = store[top];
				store[top--] = 0;
				return value;
			}
			return -1;
		}
		public int size() {
			return top+1;
		}
		public int empty() {
			if(top==-1) {
				return 1;
			}
			return 0;
		}
		public int top() {
			if(empty()==1) {
				return -1;
			}
			return store[top];
		}
	}
	static int N;
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		N = Integer.parseInt(scan.nextLine());
		MyStack stack =new MyStack();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String line = scan.nextLine();
			String str[] =line.split(" ");
			String operation = str[0];
			//System.out.println("operation"+" "+operation);
			switch (operation) {
			case "push":
				int value = Integer.parseInt(str[1]);
				stack.push(value);
				break;
			case "top":
				sb.append(stack.top()).append('\n');
				break;
			case "size":
				sb.append(stack.size()).append('\n');
				break;
			case "pop":
				sb.append(stack.pop()).append('\n');
				break;
			case "empty":
				sb.append(stack.empty()).append('\n');
				break;
			}			
		}
		System.out.println(sb);
	}

}
