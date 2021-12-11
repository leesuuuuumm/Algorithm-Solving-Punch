package com.programmers2;

import java.util.*;

public class Solution_오픈채팅방 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		Solution(record);
	}

	private static String[] Solution(String[] record) {
		ArrayList<String> aList = new ArrayList<String>(); // 채팅방 누가 들어왔는지 log 기록
		HashMap<String, String> map = new HashMap<String, String>(); // key:uid value:uname

		for (int i = 0; i < record.length; i++) {
			String[] command = record[i].split(" ");

			switch (command[0]) {
			case "Enter":
				aList.add(command[1] + "님이 들어왔습니다.");
				map.put(command[1], command[2]);
				break;
			case "Leave":
				aList.add(command[1] + "님이 나갔습니다.");
				break;
			case "Change":
				map.put(command[1], command[2]);
				break;
			}
		}

		String[] answer = new String[aList.size()];

		for (int i = 0; i < aList.size(); i++) {
			int idx = aList.get(i).indexOf("님");
			String sub = aList.get(i).substring(0, idx); // uid만 남음
			String[] hideCommand = aList.get(i).split(" ");
			answer[i] = map.get(sub) + "님이" + " " + hideCommand[1];
			System.out.println(answer[i]);

		}

		return answer;
	}
}
