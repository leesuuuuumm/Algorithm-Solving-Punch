package net.acmicpc;

import java.util.Scanner;

public class Solution_10845_큐 {
	static class MyQueue {
		int queue[] = new int[10001];
		int tail = -1;
		int head = 0;

		public void push(int X) {
			queue[++tail] = X;
		}
	

		public int pop() {
			if (tail >= 0) {
				if (queue[tail] == 0) {
					return -1;
				}
				int store = queue[head];
				queue[head] = 0;
				++head;
				
				return store;

			}
			return -1;
		}

		public int size() {
			return (tail - head) + 1;
		}

		public int empty() {
			if (queue[head] == 0) {
				return 1;
			}
			return 0;
		}

		public int front() {
			if (queue[head] == 0) {
				return -1;
			}
			return queue[head];
		}

		public int back() {
			if (queue[head] == 0) {
				return -1;
			}
			return queue[tail];
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = Integer.parseInt(scan.nextLine());
		MyQueue myqueue = new MyQueue();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String line = scan.nextLine();
			String str[] = line.split(" ");
			String operation = str[0];
			switch (operation) {
			case "push":
				myqueue.push(Integer.parseInt(str[1]));
				break;
			case "pop":
				sb.append(myqueue.pop()).append('\n');
				break;
			case "size":
				sb.append(myqueue.size()).append('\n');
				break;
			case "empty":
				sb.append(myqueue.empty()).append('\n');
				break;
			case "front":
				sb.append(myqueue.front()).append('\n');
				break;
			case "back":
				sb.append(myqueue.back()).append('\n');
				break;

			}
		}
		System.out.println(sb);
	}
}
