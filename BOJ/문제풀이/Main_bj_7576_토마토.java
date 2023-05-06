package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_7576_토마토 {
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map;
	static ArrayDeque<int[]> q = new ArrayDeque<>();
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.offer(new int[] { i, j, 0 });
			}
		}
		bfs();
		System.out.println(check());
	}

	private static int check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					return -1;
			}
		}
		return max;
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			max = Math.max(max, ij[2]);
			for (int d = 0; d < 4; d++) {
				int ni = ij[0] + di[d];
				int nj = ij[1] + dj[d];
				int curDay = ij[2];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) {
					map[ni][nj] = 1;
					q.offer(new int[] { ni, nj, curDay + 1 });
				}
			}
		}
	}

}
