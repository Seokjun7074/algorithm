package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_10971_외판원순회2 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	static void find(int start, int nowLocation, int cnt, int sum) {
		if (sum > min)
			return;
		if (cnt == N - 1 && map[nowLocation][start] != 0) {
			sum += map[nowLocation][start];
			min = Math.min(min, sum);
			return;
		}
		for (int k = 0; k < N; k++) {
			if (visited[k] || map[nowLocation][k] == 0)
				continue;
			visited[k] = true;
			find(start, k, cnt + 1, sum + map[nowLocation][k]);
			visited[k] = false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		//
		for (int start = 0; start < N; start++) {
			visited[start] = true;
			find(start, start, 0, 0);
			visited[start] = false;
		}
		System.out.println(min);
	}

}
