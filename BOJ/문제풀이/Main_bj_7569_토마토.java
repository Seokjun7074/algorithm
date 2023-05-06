package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_7569_토마토 {
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int N, M, H;
	static int[][][] tomato;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	static int checkTomato() {
		int max = Integer.MIN_VALUE;

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (tomato[h][n][m] == 0)
						return -1;
					max = Math.max(max, tomato[h][n][m]);
				}
			}
		}

		if (max == 1)
			return 0;
		return max-1;
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int z = cur[0];
			int y = cur[1];
			int x = cur[2];
			for (int d = 0; d < 6; d++) {
				int nz = z + dz[d];
				int ny = y + dy[d];
				int nx = x + dx[d];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && tomato[nz][ny][nx] == 0) {
					q.offer(new int[] { nz, ny, nx });
					tomato[nz][ny][nx] = tomato[z][y][x] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomato = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
					if (tomato[h][n][m] == 1)
						q.offer(new int[] { h, n, m });
				}
			}
		}
		bfs();
		System.out.println(checkTomato());
	}
}
