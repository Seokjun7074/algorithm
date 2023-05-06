package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2178_미로탐색 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };

	static int N;
	static int M;
	static int[][] map;
	static boolean[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		v = new boolean[N][M];
		v[0][0] = true;
		bfs(0, 0);
		System.out.println(map[N - 1][M - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });

		while (!q.isEmpty()) {
			int currnet[] = q.poll();
			int nowX = currnet[0];
			int nowY = currnet[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + di[i];
				int nextY = nowY + dj[i];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
					continue;
				if (v[nextX][nextY] || map[nextX][nextY] == 0)
					continue;

				q.add(new int[] { nextX, nextY });
				map[nextX][nextY] = map[nowX][nowY] + 1;
				v[nextX][nextY] = true;
			}
		}
	}
}