package com.programmers2;

import java.util.*;

public class Solution_다리를지나는트럭 {
	public static void main(String[] args) {
		System.out.println(solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }));
	}
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int second = 1; // 초
        int sum = 0; // 다리에 올라간 트럭무게 합
        Queue<Integer> queTruck = new LinkedList<>();
        Queue<Integer> queBridge = new LinkedList<>();
        
        for(int i = 0;i<truck_weights.length;i++){
            queTruck.offer(truck_weights[i]); // 트럭큐에 넣기
        }
        
        queBridge.offer(queTruck.peek()); // 첫 트럭을 다리에 올리기
        sum +=queTruck.poll();

        while(true){
            if(queBridge.peek()==-1) break; // 마지막 트럭이 나갔다면
            if(queBridge.size()==bridge_length){ // 트럭이 다리에 꽉 차면
                     sum-=queBridge.poll();
                 }
            if(!queTruck.isEmpty()){ // 다리에 놓을 수 있는 트럭이 있다면
                if(sum+queTruck.peek()<=weight){     
                     queBridge.offer(queTruck.peek()); // 트럭을 다리에 올리기
                     sum+=queTruck.poll();
                      
                 }else{
                     queBridge.offer(0);
                 }
            }else{ // 더이상 트럭이 없다면 
                queBridge.offer(-1);
            }
                 second ++; // 초 증가
                 
        }
             
        return second;
        
    }
}