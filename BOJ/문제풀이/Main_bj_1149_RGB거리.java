package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1149_RGB거리 {
	static int N;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		dp = new int[N][3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			dp[0][i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int[] floor = new int[3];
			for (int j = 0; j < 3; j++) {
				floor[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + floor[j];
				else if (j == 1)
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + floor[j];
				else
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + floor[j];

			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp[N - 1][i]);
		}
		System.out.println(min);
	}
}
