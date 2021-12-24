package com.programmers2;

public class Solution_멀쩡한사각형 {

	// 1차함수 기울기로 풀면 된다.
	// y = ax+b b는 어쩌피 0부터 시작해서 필요없다.
	// a(기울기)는 y증가량/x증가량
	// 기울기 구한 뒤 x에 0 ~ w-1까지 대입을 하면 기울기에 포함하지 않은 사각형들의 값을 구할 수 있다.
	// 규칙 찾다가 시간 다감.. 기울기로 푸니깐 금방 품...ㅠㅠ
	// w h 다 범위가 1억이 최대값이라 w,h를 long으로 안해주면 12~17까지 틀림
	public static void main(String[] args) {

		solution(8, 12);
	}

	public static int solution(int w, int h) {

		int answer = 0;
		for (int i = 0; i < w; i++) {
			answer+=(((long)h*i)/(long)w);
		}
		System.out.println(answer*2);

		return answer*2; //한 쪽만 구해주니깐 나머지 반대쪽도 같으니깐 곱하기 2!
	}

}
