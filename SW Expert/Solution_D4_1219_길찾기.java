package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_1219_길찾기 {
	static int[][] map;
	static boolean[] visited;
	static int N;
	static int flag = 0;

	static void dfs(int start) {
		visited[start] = true;
		if (start == 99) {
			flag = 1;
			return;
		}
		for (int i = 0; i < 100; i++) {
			if (map[start][i] != 0 && !visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			map = new int[100][100];
			visited = new boolean[100];
			flag = 0;
			st = new StringTokenizer(br.readLine());
			int test_case = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[c][r] = 1;
			}
			dfs(0);
			System.out.printf("#%d %d\n",tc,flag);
		}
	}

}
