import java.io.*;

public class Main {

	static String S; // S -> T
	static int ans;
	static boolean flag;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		S = br.readLine();
		sb.append(br.readLine());
		ans = 0;
		flag = false;

		dfs();
		System.out.println(ans);

	}

	private static void dfs() {
		if (flag)
			return;

		if (S.length() == sb.length()) {
			if (S.equals(sb.toString())) {
				ans = 1;
				flag = true;
			}
			return;
		}

		if (sb.substring(sb.length() - 1).equals("A")) {
			sb.deleteCharAt(sb.length() - 1);
			dfs();
			sb.append("A");
		}
		if (sb.substring(0, 1).equals("B")) {
			sb.reverse();
			sb.deleteCharAt(sb.length() - 1);
			dfs();
			sb.append("B");
			sb.reverse();
		}

	}
}
