package SWE;

import java.io.*;
import java.util.*;

public class Solution_5643_키순서 {
	static int N, M, less, more;
	static int[][] map;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[y - 1][x - 1] = 1;
			}
//			for (int[] a : map)
//				System.out.println(Arrays.toString(a));
			int result = 0;
			for (int i = 0; i < N; i++) {
				less = more = 0;
				findTall(i);
				findShort(i);
//				System.out.println(less + " " + more);
				if (less + more == N - 1)
					result += 1;
			}
			System.out.println("#"+tc+" "+result);
		}
	}

	private static void findShort(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v = new boolean[N];
		q.offer(start);
		v[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < N; j++) {
				if (map[j][cur] == 1 && !v[j]) {
					v[j] = true;
					less++;
					q.offer(j);
				}
			}
		}
	}

	private static void findTall(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		v = new boolean[N];
		q.offer(start);
		v[start] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 0; j < N; j++) {
				if (map[cur][j] == 1 && !v[j]) {
					v[j] = true;
					more++;
					q.offer(j);
				}
			}
		}
	}

}
