package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1260_DFS와BFS {
	static int N;

	static int[][] map;
	static boolean[] visited;

	static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for (int i = 0; i < N + 1; i++) {
			if (map[start][i] != 0 && !visited[i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			start = q.poll();
			System.out.print(start + " ");
			for (int i = 0; i < N + 1; i++) {
				if (map[start][i] != 0 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			map[c][r] = 1;
			map[r][c] = 1;
		}
		dfs(V);
		visited = new boolean[N + 1];
		System.out.println();
		bfs(V);
	}

}
