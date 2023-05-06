package SWE;

import java.io.*;
import java.util.*;

public class Solution_D3_5215_햄버거다이어트 {
	static int N;
	static int L;
	static int[][] burger;
	static int max;

	static void subs(int cnt, int like, int sum) {
		if (sum > L) {
			return;
		} else {
			max = Math.max(max, like);
		}
		if (cnt == N)
			return;

		subs(cnt + 1, like + burger[cnt][0], sum + burger[cnt][1]);
		subs(cnt + 1, like, sum);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료수
			L = Integer.parseInt(st.nextToken()); // 칼로리 제한
			burger = new int[N][2];
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				burger[i][0] = Integer.parseInt(st.nextToken());
				burger[i][1] = Integer.parseInt(st.nextToken());
			}
			subs(0, 0, 0); // 시작, 선호도, 칼로리

			System.out.printf("#%d %d\n", test_case, max);
		}

	}

}
