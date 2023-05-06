package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_1227_미로2 {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };

	static int[][] arr = new int[100][100];
	static int[] start = new int[2];
	static int[] end = new int[2];
	static boolean[][] v;
	static int result = 0;

	static void dfs(int i, int j) {
		v[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];


			if (ni >= 0 && ni < 100 && nj >= 0 && nj < 100 && arr[ni][nj] != 1 && !v[ni][nj]) {
				if (arr[ni][nj] == 3) {
					result = 1;
					return;
				}
				dfs(ni, nj);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = 10;

		for (int testcase = 0; testcase < TC; testcase++) {
			int testCase = Integer.parseInt(br.readLine());
			v = new boolean[100][100];
			result = 0;

			for (int i = 0; i < 100; i++) {
				String[] charArray = br.readLine().split("");
				for (int j = 0; j < 100; j++) {
					int input = Integer.parseInt(charArray[j]);
					if (input == 2) {
						start[0] = i;
						start[1] = j;
					} else if (input == 3) {
						end[0] = i;
						end[1] = j;
					}
					arr[i][j] = input;
				}
			}

			dfs(start[0], start[1]);

			System.out.printf("#%d %d\n",testCase,result);

		}
	}

}
