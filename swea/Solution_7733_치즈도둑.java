package ssafyAlgo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_7733_치즈도둑 {

	static int map[][], che[][], v[][];
	static int T, N;
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		T = scan.nextInt();
		for (int t = 1; t <= T; t++) {
			N = scan.nextInt();
			map = new int[N][N];
			v = new int[N][N];
			int k=0;
			int m = map[0][0];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = scan.nextInt();
					if (map[r][c] > m) {
						m = map[r][c];
					}
					if (map[r][c] ==m) {
						k++;
					}
				}
			}
			if(k==N*N) {
				System.out.println("#"+t+ " " + 1);
			}
			else {
			int max=Integer.MIN_VALUE;
			Queue<int[]> q = new LinkedList<>();
			a:while (true) {
				che = new int[N][N];
				v = new int[N][N];
				if (m == 0) {
					break a;
				}
				int cnt=0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
					
						if(map[r][c] > m) {
							che[r][c]=1;
						}
					}
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (che[r][c] == 1&&v[r][c]==0) {
							q.offer(new int[] {r,c});
							cnt++;
							while(!q.isEmpty()) {
								int curr[]=q.poll();
								
								for (int d = 0; d < 4; d++) {
									int nr=curr[0]+dr[d];
									int nc=curr[1]+dc[d];
									if (!check(nr,nc)) {
										continue;
									}
									if(che[nr][nc]==1&&v[nr][nc]==0) {
										v[nr][nc]=1;
										q.offer(new int[] {nr,nc});
									}
								}
							}
						}
					}
				}
				max=Math.max(max, cnt);

				m--;
			}
			
			System.out.println("#"+t+ " " + max);
			}
		}

	}

	private static boolean check(int nr, int nc) {
		if(nr>=0&&nr<N&&nc>=0&&nc<N) {
			return true;
		}else
			return false;
	}

}
