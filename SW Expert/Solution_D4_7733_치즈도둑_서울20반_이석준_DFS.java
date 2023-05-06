package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_7733_치즈도둑_서울20반_이석준_DFS {
	static final int[] di = { -1, 0, 1, 0 }; // 상우하좌
	static final int[] dj = { 0, 1, 0, -1 };
	static boolean[][] v;

	static int N;
	static int[][] arr;

	static void dfs(int i, int j, int day) {
		v[i][j] = true;
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]&& arr[ni][nj] > day) {
				dfs(ni, nj, day);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int TC = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= TC; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			int result = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int day = 0; day <= 100; day++) {
				v = new boolean[N][N];
				int count = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!v[i][j] && arr[i][j] > day) {
							dfs(i, j, day);
							count++;
						}
					}
				}
				if (count > result)
					result = count;
			}
			System.out.printf("#%d %d\n", test_case, result);
		}
	}

}
