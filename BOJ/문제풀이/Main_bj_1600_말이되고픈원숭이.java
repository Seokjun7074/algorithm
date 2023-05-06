package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1600_말이되고픈원숭이 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visited;

	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int[] hi = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] hj = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int min = Integer.MAX_VALUE;

	static int bfs(int i, int j, int K, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j, K, cnt }); // 0이면 말 따라하기 불가능 1이면 가능

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int curI = ij[0];
			int curJ = ij[1];
			int curK = ij[2];
			int count = ij[3];
			if (curI == H - 1 && curJ == W - 1) {
				System.out.println(count);
				return count;
			}

			for (int d = 0; d < 4; d++) {
				int ni = curI + di[d];
				int nj = curJ + dj[d];
				if (ni >= H || ni < 0 || nj >= W || nj < 0 || map[ni][nj] != 0 || visited[ni][nj][curK])
					continue;
				visited[ni][nj][curK] = true;
				q.offer(new int[] { ni, nj, curK, count + 1 });
			}
			if (curK > 0) { // 말 행동 가능한 경우
				for (int d = 0; d < 8; d++) {
					int ni = curI + hi[d];
					int nj = curJ + hj[d];
					if (ni >= H || ni < 0 || nj >= W || nj < 0 || map[ni][nj] != 0 || visited[ni][nj][curK - 1])
						continue;
					visited[ni][nj][curK - 1] = true;
					q.offer(new int[] { ni, nj, curK - 1, count + 1 });
				}
			}
		}
		return min;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new boolean[H][W][31];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		//
		min = bfs(0, 0, K, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
	}
}