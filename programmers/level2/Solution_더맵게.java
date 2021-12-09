package com.programmers2;
import java. util.*;

public class Solution_더맵게 {

	public static void main(String[] args) {
		int[] scoville = {1,2,3}; //이 Test Case 때문에 30분은 삽질
		solution(scoville,3);
	}
	public static int solution(int[] scoville, int K) {
	
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0;i<scoville.length;i++){
            pq.add(scoville[i]);
        }
        int count = 0;
        int newScoville = 0;
       while(!pq.isEmpty()){
           if(pq.size()==1&&pq.peek()<K) return -1; //이 조건문이 없으면 1, 3, 8, 14 런타임에러! 
           int point1 = pq.poll();
           if(point1 > K) break;
           
           int point2 = pq.poll();
           
           newScoville = point1+(point2*2); //스코필 계산
           pq.add(newScoville);
           count++;
       }
        if(count==0) return -1;
        
        System.out.println(count);
        return count;
	}
}
