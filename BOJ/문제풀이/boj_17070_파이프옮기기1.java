package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int count = 0;

	static String checkShape(int x1, int y1, int x2, int y2) {
		if (x1 == x2)
			return "세로";
		else if (y1 == y2)
			return "가로";
		else if (x1 < x2 && y1 < y2)
			return "대각선";
		return null;
	}

	static void dfs(int x1, int y1, int x2, int y2) {
		if (y2 == N && x2 == N) {
			count += 1;
			return;
		}
		String action = checkShape(x1, y1, x2, y2);
		switch (action) {
		case "가로":
			// 가로로 움직이는 경우
			if (x2 + 1 <= N && map[y2][x2 + 1] == 0) {
				dfs(x1 + 1, y1, x2 + 1, y2);
				// 대각으로 움직이는 경우
				if (y2 + 1 <= N && map[y2 + 1][x2] == 0 && map[y2 + 1][x2 + 1] == 0)
					dfs(x1 + 1, y1, x2 + 1, y2 + 1);
			}
			break;
		case "세로":
			// 세로로 움직이는 경우
			if (y2 + 1 <= N && map[y2 + 1][x2] == 0) {
				dfs(x1, y1 + 1, x2, y2 + 1);
				// 대각으로 움직이는 경우
				if (x2 + 1 <= N && map[y2][x2 + 1] == 0 && map[y2 + 1][x2 + 1] == 0)
					dfs(x1, y1 + 1, x2 + 1, y2 + 1);
			}
			break;
		case "대각선":
			// 가로로 움직이는 경우
			if (x2 + 1 <= N && map[y2][x2 + 1] == 0)
				dfs(x1 + 1, y1 + 1, x2 + 1, y2);
			// 세로로 움직이는 경우
			if (y2 + 1 <= N && map[y2 + 1][x2] == 0) {
				dfs(x1 + 1, y1 + 1, x2, y2 + 1);
				// 대각으로 움직이는 경우
				if (x2 + 1 <= N && map[y2][x2 + 1] == 0 && map[y2 + 1][x2 + 1] == 0)
					dfs(x1 + 1, y1 + 1, x2 + 1, y2 + 1);
			}
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				if ((i == 1 && j == 1) || (i == 1 && j == 2))
					map[i][j] = Integer.parseInt(st.nextToken()) + 2;
				else
					map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		dfs(1, 1, 2, 1);
		System.out.println(count);
	}

}