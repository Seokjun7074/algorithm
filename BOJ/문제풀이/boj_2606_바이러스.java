package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2606_바이러스 {
	static int N;
	static int[][] computer;
	static boolean[]v;
	static int count = 0;

	private static void bfs(int i) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(i);
		v[i] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int j = 1; j < N + 1; j++) {
				if (computer[cur][j] == 1 && !v[j]) {
					v[j] = true;
					q.offer(j);
					count+=1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		computer = new int[N + 1][N + 1];
		v = new boolean[N + 1];
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			computer[from][to] = 1;
			computer[to][from] = 1;
		}
		bfs(1);
		System.out.println(count);
	}

}
