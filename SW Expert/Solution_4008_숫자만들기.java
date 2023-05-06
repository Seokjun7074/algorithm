package SWE;

import java.io.*;
import java.util.*;

public class Solution_4008_숫자만들기 {
	static int N; // 주어지는 숫자
	static int[] input; // 입력받은 수
	static int[] sign = new int[4]; // +:0 -:1 *:2 /:3
	static int max;
	static int min;

	static void permutation(int cnt, int cal) {
		if (cnt == N - 1) {
			System.out.println(cal);
			max = Math.max(max, cal);
			min = Math.min(min, cal);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (sign[i] == 0)
				continue;

			sign[i]--;

			if (i == 0) {
				permutation(cnt + 1, cal + input[cnt + 1]);
			} else if (i == 1) {
				permutation(cnt + 1, cal - input[cnt + 1]);
			} else if (i == 2) {
				permutation(cnt + 1, cal * input[cnt + 1]);
			} else if (i == 3) {
				permutation(cnt + 1, cal / input[cnt + 1]);
			}
			sign[i]++;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				sign[i] = Integer.parseInt(st.nextToken());

			input = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				input[i] = Integer.parseInt(st.nextToken());
			// 입력 끝
			permutation(0, input[0]);
			sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
	}

}
