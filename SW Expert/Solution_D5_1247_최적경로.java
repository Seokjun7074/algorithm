package SWE;

import java.io.*;
import java.util.*;

public class Solution_D5_1247_최적경로 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };

	static int result = Integer.MAX_VALUE;
	static int sum = 0;

	static int N;
	static int[] office = new int[2];
	static int[] home = new int[2]; // 현재 좌표
	static int[][] service;
	static int[] permArr;
	static boolean[] v;

	static void perm(int cnt, int sum) {
		if (sum > result)
			return;
		if (cnt == N) {
			sum += Math.abs(office[0] - service[permArr[0]][0]) + Math.abs(office[1] - service[permArr[0]][1]);
			for (int i = 1; i < N; i++) {
				sum += Math.abs(service[permArr[i]][0] - service[permArr[i - 1]][0])
						+ Math.abs(service[permArr[i]][1] - service[permArr[i - 1]][1]);
			}
			sum += Math.abs(home[0] - service[permArr[N - 1]][0]) + Math.abs(home[1] - service[permArr[N - 1]][1]);
			if (sum < result)
				result = sum;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i])
				continue;
			v[i] = true;
			permArr[cnt] = i;
			perm(cnt + 1, sum);
			v[i] = false;

		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			service = new int[N][2];
			permArr = new int[N];
			sum = 0;
			v = new boolean[N];
			result = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			office[0] = Integer.parseInt(st.nextToken());
			office[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				service[i] = new int[] { x, y };
			}
			//
			perm(0, 0);
			System.out.printf("#%d %d\n", test_case, result);
		}
	}

}
