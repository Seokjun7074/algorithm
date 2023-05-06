package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_4963_섬의개수 {
	static final int[] di = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static final int[] dj = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int cnt;

	static int H;
	static int W;
	static int[][] map;
	static boolean[][] v;

	private static void dfs(int i, int j) {
		v[i][j] = true;
		for (int d = 0; d < 8; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] == 1 && !v[ni][nj]) {
				dfs(ni, nj);
			}
		}
	}

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j] = true;
		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];

			for (int d = 0; d < 8; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] == 1 && !v[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] { ni, nj });
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0)
				break;
			map = new int[H][W];
			v = new boolean[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//
			cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !v[i][j]) {
//						dfs(i, j);
						bfs(i, j);
						cnt += 1;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
