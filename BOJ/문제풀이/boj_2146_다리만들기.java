package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2146_다리만들기 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };
	static int N;
	static int[][] map;
	static int[][] islandMap;
	static boolean[][] v;

	static int island = 1;
	static int min = Integer.MAX_VALUE;

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		islandMap[i][j] = island;
		q.offer(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int ci = ij[0];
			int cj = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = ci + di[d];
				int nj = cj + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					if (map[ni][nj] == 1 && islandMap[ni][nj] == 0) {
						islandMap[ni][nj] = island;
						q.offer(new int[] { ni, nj });
					}
				}
			}
		}

	}

	static void makeBridge(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[N][N];
		int startIsland = islandMap[i][j]; // 현재 섬 번호
		v[i][j] = true;

		int count = 0;
		q.offer(new int[] { i, j, count });

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int ci = ij[0];
			int cj = ij[1];
			int cd = ij[2];

			for (int d = 0; d < 4; d++) {
				int ni = ci + di[d];
				int nj = cj + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					if (islandMap[ni][nj] != 0 && islandMap[ni][nj] != startIsland) {// 섬인데 현재 섬이랑 다른 경우
						min = Math.min(cd, min);
						return;
					}
					if (!v[ni][nj]) {
						v[ni][nj] = true;
						q.offer(new int[] { ni, nj, cd + 1 });
					}

				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		islandMap = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
			}
		}
		// 섬 다르게 표시
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0 || islandMap[i][j] > 0)
					continue;
				bfs(i, j);
				island += 1;
			}
		}
		// 다리 놓기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					// 탐색
					makeBridge(i, j);
				}
			}
		}
		System.out.println(min);
	}
}