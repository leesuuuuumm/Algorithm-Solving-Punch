package net.acmicpc;

import java.io.*;
import java.util.*;

public class Solution_2477_참외밭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] melonField = new int[6][2];
		int maxRow = Integer.MIN_VALUE;
		int maxCol = Integer.MIN_VALUE;
		int maxRowIdx = 0;
		int maxColIdx = 0;
		int sRow = 0;
		int sCol = 0;
		for(int i=0; i<6;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				melonField[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<6;i++) {
			if(melonField[i][0]==1|| melonField[i][0]==2) {
				if(maxRow<melonField[i][1]) {
					maxRow= melonField[i][1];
					maxRowIdx = i;
				}
			}
			if(melonField[i][0]==3||melonField[i][0]==4) {
				if(maxCol<melonField[i][1]) {
					maxCol= melonField[i][1];
					maxColIdx = i;
				}
			}
		}
		
		//작은 사각형 세로길이
		if(maxRowIdx==0) {
			sCol = Math.abs(melonField[5][1]-melonField[1][1]);
		}else {
		
			sCol = Math.abs(melonField[(maxRowIdx-1)%6][1]-melonField[(maxRowIdx+1)%6][1]);
		}
		
		//작은 사각형 가로길이
		if(maxColIdx ==0) {
			sRow = Math.abs(melonField[5][1]-melonField[1][1]);
		}else {
		sRow = Math.abs(melonField[(maxColIdx-1)%6][1]-melonField[(maxColIdx+1)%6][1]);

		}
		int answer = ((maxRow*maxCol)-(sRow*sCol))*N;
		System.out.println(answer);
	}

}
