package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_1861_정사각형방 {
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int N = 0;
	static int C;
	static int max = 0;
	static int result;
	static int[][] arr;
	static boolean[][] v;

	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int k = 0; k < 4; k++) {
				int ni = i + di[k];
				int nj = j + dj[k];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] - 1 == arr[i][j]) {
					C++;
					q.offer(new int[] { ni, nj });
				}
			}
		}
	}

	static void dfs(int i, int j) {

		for (int k = 0; k < 4; k++) {
			int ni = i + di[k];
			int nj = j + dj[k];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && arr[ni][nj] - 1 == arr[i][j]) {
				C++;
				dfs(ni, nj);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			max = 0;
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					C = 1;
//					dfs(i, j);
					bfs(i, j);
					if (C > max) {
						max = C;
						result = arr[i][j];
					} else if (C == max) {
						if (result > arr[i][j])
							result = arr[i][j];
					}
				}
			}
			System.out.printf("#%d %d %d\n", test_case, result, max);
		}
	}

}
