package SWE;

import java.io.*;
import java.util.*;

public class Solution_2115_벌꿀채취 {
	private static int N, M, C, result;
	private static int cost1, cost2;
	private static int[][] map;
	private static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			v = new boolean[M];
			result = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			getWorker();
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	private static void getWorker() {
		boolean[][] check = new boolean[N][N];
		// 1번 일꾼
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				for (int k = j; k < j + M; k++) {
					check[i][k] = true;
				}

				// 2번 일꾼
				for (int y = 0; y < N; y++) {
					label: for (int x = 0; x <= N - M; x++) {
						for (int k = 0; k < M; k++) {
							if (check[y][x + k]) {
								break label;
							}
						}
						cost1 = 0;
						cost2 = 0;
						subs(0, i, j, y, x);
						result = Math.max(result, cost1 + cost2);
					}
				}
			}
		}
	}

	private static void subs(int cnt, int i, int j, int y, int x) {
		if (cnt == M) {
			int sum1 = 0, sum2 = 0, sqrtSum1 = 0, sqrtSum2 = 0;
			for (int k = 0; k < M; k++) {
				if (v[k]) {
					int worker1 = map[i][j + k];
					int worker2 = map[y][x + k];
					sum1 += worker1;
					sqrtSum1 += worker1 * worker1;
					sum2 += worker2;
					sqrtSum2 += worker2 * worker2;
				}
			}
			if (sum1 <= C)
				cost1 = Math.max(cost1, sqrtSum1);
			if (sum2 <= C)
				cost2 = Math.max(cost2, sqrtSum2);
			return;
		}

		v[cnt] = true;
		subs(cnt + 1, i, j, y, x);
		v[cnt] = false;
		subs(cnt + 1, i, j, y, x);
	}
}