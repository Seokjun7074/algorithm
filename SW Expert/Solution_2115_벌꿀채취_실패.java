package SWE;

import java.io.*;
import java.util.*;

public class Solution_2115_벌꿀채취_실패 {
	static int N, M, C;
	static int[][] map;
	static boolean[][] v;

	static int[] workerA;
	static int[] workerB;

	static int tmpMax = 0;
	static int calc1 = 0;
	static int calc2 = 0;
	static int result = 0;

	static void combi(int y, int x, int cnt) {
		if (cnt == 2) {
//			calc1 = 0;
			calc2 = 0;
			tmpMax = 0;
//			System.out.println(Arrays.toString(workerA));
			makeMaxSubs(0, workerA, 1, new boolean[M]);
			tmpMax = 0;
//			System.out.println(Arrays.toString(workerB));
			makeMaxSubs(0, workerB, 2, new boolean[M]);
			return;
		}
		for (int i = y; i < N; i++) {
			label: for (int j = 0; j <= N - M; j++) {
				if (v[i][j])
					continue;
				workerB = new int[M];
				for (int k = 0; k < M; k++) {
					if (v[i][j + k])
						break label;
					workerB[k] = map[i][j + k];
				}
				combi(i, j, cnt + 1);
			}
		}
	}

	static void makeMaxSubs(int cnt, int[] honey, int workerNum, boolean[] visited) {
		if (cnt == M) {
			int sum = 0;
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < M; i++) {
				if (visited[i]) {
					sum += honey[i];
					list.add(honey[i]);
				}

			}
			if (list.size() > 0 && sum <= C) {
				tmpMax = Math.max(tmpMax, sum);
//				System.out.println(list);
				check(list, sum, workerNum);
			}
			return;
		}
		visited[cnt] = true;
		makeMaxSubs(cnt + 1, honey, workerNum, visited);
		visited[cnt] = false;
		makeMaxSubs(cnt + 1, honey, workerNum, visited);

	}

	private static void check(ArrayList<Integer> list, int sum, int workerNum) {
		if (sum < tmpMax)
			return;
//		System.out.println(tmpMax + "worker" + workerNum);
		int total = 0;
		for (int a : list) {
			total += a * a;
		}
		if (workerNum == 1) {
			calc1 = Math.max(total, calc1);
		} else {
			calc2 = Math.max(total, calc2);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken()); // 선택할 수 있는 벌통의 개수
			C = Integer.parseInt(st.nextToken()); // 꿀채취 상한선
			map = new int[N][N];
			v = new boolean[N][N];
			workerA = new int[M];
			workerB = new int[M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//
//			makeMaxSubs(0, new int[] { 5, 5, 2, 8 }, 1, new boolean[M]);

			calc1 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					for (int k = 0; k < M; k++) {
						workerA[k] = map[i][j + k];
						v[i][j + k] = true;
					}
					combi(i, j, 1);
				}
			}
//			System.out.println(calc1);
//			System.out.println(calc2);
			System.out.println(calc1 + calc2);
		}
	}
}