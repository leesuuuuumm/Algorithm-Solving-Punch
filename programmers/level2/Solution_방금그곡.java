package com.programmers2;

import java.util.*;

public class Solution_방금그곡 {

	static class MusicInfoC {
		int sub;
		String title;

		public MusicInfoC(int sub, String title) {
			this.sub = sub;
			this.title = title;
		}
	}

	public static void main(String[] args) {
		String[] musicinfos = { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" };
		solution("ABCDEFG", musicinfos);
	}

	public static String solution(String m, String[] musicinfos) {

		String[] noteTrue = { "C#", "D#", "E#", "F#", "G#", "A#", "B#" };
		String[] noteFalse = { "Q", "W", "Z", "X", "V", "N", "M" };

		LinkedList<MusicInfoC> list = new LinkedList<MusicInfoC>();

		// ,로 잘라주고 또 그안에서 :로 잘라줌
		for (int i = 0; i < musicinfos.length; i++) {
			String musicinfo[] = musicinfos[i].split(",");
			String infoFirst[] = musicinfo[0].split(":");
			String infoSecond[] = musicinfo[1].split(":");
			// 앞에 0,1번째 시간 차이 분으로 바꿔서 1번째에서 2번째 빼주고
			int sumFirst = Integer.parseInt(infoFirst[0]) * 60 + Integer.parseInt(infoFirst[1]);
			int sumSecond = Integer.parseInt(infoSecond[0]) * 60 + Integer.parseInt(infoSecond[1]);
			// sub에 저장
			int sub = sumSecond - sumFirst;
			System.out.println(sub);
			// # 이 들어간 음은 악보에 사용되는 음 이외의 다른 알파벳으로 대체
			for (int j = 0; j < noteTrue.length; j++) {
				m = m.replaceAll(noteTrue[j], noteFalse[j]);
				musicinfo[3] = musicinfo[3].replaceAll(noteTrue[j], noteFalse[j]);
			}
			// 반복재생 부분
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < sub; j++) {
				sb.append(musicinfo[3].charAt(j % musicinfo[3].length()));
			}
			System.out.println(sb);
			// 곡이 포함 되면 sub와 제목 객체에 저장
			if (sb.toString().contains(m)) {
				list.add(new MusicInfoC(sub, musicinfo[2]));
			}

		} // comparator로 sub정렬 (내림차순으로)
		Collections.sort(list, new Comparator<MusicInfoC>() {

			@Override
			public int compare(MusicInfoC o1, MusicInfoC o2) {
				return o2.sub - o1.sub;
			}

		});
		if(!list.isEmpty()) {
			return list.get(0).title;
		}

		// return 정렬한거 sub 첫번째 title
		// else return (None)
		return "(None)";
	}
}