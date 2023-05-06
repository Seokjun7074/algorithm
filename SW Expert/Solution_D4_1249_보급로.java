package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_1249_보급로 {
	static final int[] di = new int[] { 1, 0, -1, 0 };
	static final int[] dj = new int[] { 0, 1, 0, -1 };

	static int N;
	static int[][] map;
	static int[][] p;

//	 다음 좌표 가보기
//	 이전 좌표까지의 최소 비용과 비교(위,왼쪽)
//	 이전 좌표의 최소 비용과 현재 좌표의 값이랑 더해주기
//	 해당 좌표에 갑 갱신

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		p[i][j] = 0;
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = cur[0] + di[d];
				int nj = cur[1] + dj[d];
				// 다음좌표 가보기
				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					// 이전좌표의 최소값 비교
					if (p[ni][nj] > p[cur[0]][cur[1]] + map[ni][nj]) {
						p[ni][nj] = p[cur[0]][cur[1]] + map[ni][nj];
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			p = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
					p[i][j] = Integer.MAX_VALUE;
				}
			}
			//
			bfs(0, 0);
			System.out.printf("#%d %d\n", test, p[N - 1][N - 1]);

		}
	}

}
