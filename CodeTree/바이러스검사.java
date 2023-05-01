import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] customer = new int[N];

		for (int i = 0; i < customer.length; i++) {
			customer[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int lSize = Integer.parseInt(st.nextToken());
		int mSize = Integer.parseInt(st.nextToken());

		int tL = N;
		int tM = 0;

		for (int i = 0; i < customer.length; i++) {
			if (lSize >= customer[i]) {
				continue;
			} else {
				customer[i] -= lSize;
				if (customer[i] % mSize != 0) {
					tM++;
				}
				tM += customer[i] / mSize;
			}
		}
		System.out.println(tL + tM);
	}
}
