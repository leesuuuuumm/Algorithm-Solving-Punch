package com.programmers;

public class Solution_같은숫자는싫어 {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 3, 0, 1, 1 };
		solution(arr);
	}

	public static int[] solution(int[] arr) {
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]); 
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1]==arr[i]) continue;
			else if(arr[i-1]!=arr[i]) sb.append(arr[i]);
		}
		//System.out.println(sb.toString());
		String s = sb.toString();
		int[] answer = new int[s.length()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = s.charAt(i)-'0';
		}
		return answer;
	}
}
/*
 * 참고!
 * for(int num : arr) {
      if(preNum != num)
          tempList.add(num);
      preNum = num;
        }       
 * 
 * */
