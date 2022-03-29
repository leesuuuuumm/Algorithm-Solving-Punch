package net.acmicpc;

import java.io.*;
import java.util.*;

public class Solution_1966_프린터큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서배열의 개수
			int M = Integer.parseInt(st.nextToken()); // 몇 번째에 놓여 있는지를 나타내는 정수
			int arr[] = new int[N];
			
			st = new StringTokenizer(br.readLine());
			Queue<Integer> doc = new LinkedList<Integer>(); // 중요도 문서
			Queue<Integer> idx = new LinkedList<Integer>(); // 중요도 인덱스
			
			for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				doc.offer(arr[i]);
				idx.offer(i);
			}
			boolean[] v = new boolean[N]; //  매번 바뀌는 max값 체크(빠진 애는 out)
			
			int[] answer = new int[N];
			int k = 0;
			// 큐에 값이 있을 때
			while(!doc.isEmpty()) {
				//1. max값 구하기
				int max = Integer.MIN_VALUE;
				int m = 0 ;
				for (int i = 0; i < v.length; i++) {
					if(!v[i]&&arr[i]>=max) {
						max = arr[i];
						m = i;
					}
				}
				
				if(doc.peek()==max) {
					doc.poll(); // 문서 중요도 순으로 빼주기
					answer[k++] = idx.poll(); // 문서 위치는 넣어주고
					v[m] = true;
				}else {
					
					doc.offer(doc.poll());
					idx.offer(idx.poll());
				}

			}
			
			for (int i = 0; i < answer.length; i++) {
				if(answer[i]==M) {
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}
