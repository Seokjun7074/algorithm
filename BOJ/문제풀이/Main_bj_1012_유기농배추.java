package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1012_유기농배추 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, 1, -1 };
	static int M, N, K;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int test = 0; test < T; test++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !v[i][j]) {
						bfs(i, j);
						count += 1;
					}
				}
			}
			System.out.println(count);
		}
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		v[i][j] = true;
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M || v[ni][nj] || map[ni][nj] == 0)
					continue;
				v[ni][nj] = true;
				q.offer(new int[] { ni, nj });
			}
		}

	}

}
