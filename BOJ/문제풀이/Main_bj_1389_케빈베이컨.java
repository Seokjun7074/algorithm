package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1389_케빈베이컨 {
	static int N, M;
	static int[][] arr;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][N + 1];
		int[] check = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}
		for (int i = 1; i <= N; i++) {
			int result = bfs(i, 0);
			check[i] = result;
		}
		int min = Integer.MAX_VALUE;
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i] < min) {
				min = check[i];
				answer = i;
			}
		}
		System.out.println(answer);
	}

	private static int bfs(int i, int count) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int sum = 0;
		v = new boolean[N + 1];
		v[i] = true;
		q.offer(new int[] { i, 0 });
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curNum = cur[0];
			int curCount = cur[1];
//			System.out.println(curCount);
			sum += curCount;
			for (int d = 1; d <= N; d++) {
				if (!v[d] && arr[curNum][d] == 1) {
					v[d] = true;
					q.offer(new int[] { d, curCount + 1 });
				}
			}
		}
		return sum;
	}

}
