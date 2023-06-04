package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1926_그림 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };
	static int N, M;
	static int[][] map;
	static boolean[][] v;

	static int max;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		v = new boolean[N][M];
		max = 0;
		count = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!v[i][j] && map[i][j] == 1) {
					bfs(i, j);
					count += 1;
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
	}

	private static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		v[i][j] = true;
		int size = 1;

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = ij[0] + di[d];
				int nj = ij[1] + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && !v[ni][nj] && map[ni][nj] == 1) {
					v[ni][nj] = true;
					size += 1;
					q.offer(new int[] { ni, nj });
				}
			}
		}
		max = Math.max(max, size);
	}
}
