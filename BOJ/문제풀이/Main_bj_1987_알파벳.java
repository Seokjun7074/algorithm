package BOJ;

import java.util.*;
import java.io.*;

public class Main_bj_1987_알파벳 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };

	static int R;
	static int C;
	static int[][] map;
	static boolean[] v = new boolean[26];

	static int MAX = 0;

	static void dfs(int i, int j, int sum) {
		v[map[i][j]] = true;
		MAX = Math.max(MAX, sum);
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
				if (v[map[ni][nj]])
					continue;
				dfs(ni, nj, sum + 1);
			}
		}
		v[map[i][j]] = false;
	}

	// A = 0 ~
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j) - 'A';
			}
		}
		dfs(0, 0, 1);
		System.out.println(MAX);
	}

}
