package SWE;

import java.io.*;
import java.util.*;

public class Solution_D3_9229_한빈이와SpotMart {

	static int N;
	static int M;
	static int[] snack;
	static int[] combination = new int[2];
	static int max = -1;

	static void combi(int cnt, int start) {
		if (cnt == 2) {
			int sum = combination[0] + combination[1];
			if (sum >= max & sum <= M) {
				max = sum;
			}
			return;
		}
		for (int i = start; i < N; i++) {
			combination[cnt] = snack[i];
			combi(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}

			combi(0, 0);
			System.out.printf("#%d %d\n",test_case,max);
		}
	}

}
