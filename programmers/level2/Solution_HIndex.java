package com.programmers2;

import java.util.*;

public class Solution_HIndex {
	 public int solution(int[] citations) {

	        Arrays.sort(citations);

	        // a번 이상 인용된 논문의 수가 b개라면, h = a,b중 작은 값 
	        // h중 최대값 출력
	        int[] hCnt = new int[citations.length];
	        for(int i=0;i<citations.length;i++){
	            int cnt = 0;
	           for(int j=0;j<citations.length;j++){
	               if(citations[i]<=citations[j]){
	                hCnt[i] = ++cnt;
	            } 
	           }
	        }
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;
	        for(int j=0;j<citations.length;j++){
	            if(hCnt[j]<citations[j]){
	                min = hCnt[j];
	            }else{
	                min = citations[j];
	            }
	            max = Math.max(min,max);
	          
	        }
	        return max;
	    }

}
