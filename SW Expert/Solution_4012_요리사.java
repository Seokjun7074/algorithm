package SWE;

import java.io.*;
import java.util.*;

// N개의 식재료가 있다.
// 식재료들을 각각 N / 2개씩 나누어 두 개의 요리를 하려고 한다.
// 맛 = ij +ji
public class Solution_4012_요리사 {
	static int N;
	static int[][] food;
	static boolean[] selected;
	static int result;

	static void combi(int cnt, int start) {
		if (cnt == N / 2) {
			cook();
			return;
		}

		for (int i = start; i < N; i++) {
			selected[i] = true;
			combi(cnt + 1, i + 1);
			selected[i] = false;
		}
	}

	static void cook() {
		int food1 = 0;
		int food2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (food[i][j] == 0)
					continue;
				if (selected[i] && selected[j]) {
					food1 += food[i][j];
				} else if (!selected[i] && !selected[j]) {
					food2 += food[i][j];
				}
			}
		}
		result = Math.min(result, Math.abs(food1 - food2));

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			food = new int[N][N];
			selected = new boolean[N];
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//
			combi(0, 0);
			System.out.printf("#%d %d\n",test_case,result);
		}
	}
}

// 123456    =>6C3
// 123, 456     => 3C2
// 