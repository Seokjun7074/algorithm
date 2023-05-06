package SWE;

import java.io.*;
import java.util.*;

public class Solution_1953_탈주범검거 {
	// 상우하좌
	static final int[] di = new int[] { -1, 0, 1, 0 };
	static final int[] dj = new int[] { 0, 1, 0, -1 };

	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] v;

	static class Pipe {
		int y, x, time, num;

		public Pipe(int y, int x, int time, int num) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.num = num;
		}

		@Override
		public String toString() {
			String str = y + " " + x;
			return str;
		}
	}

	static int[][] setPipe(int pipeNum) {
		switch (pipeNum) {
		case 1: // 4방향
			return new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		case 2: // 상하
			return new int[][] { { -1, 0 }, { 1, 0 } };
		case 3: // 좌우
			return new int[][] { { 0, -1 }, { 0, 1 } };
		case 4: // 상우
			return new int[][] { { -1, 0 }, { 0, 1 } };
		case 5: // 하우
			return new int[][] { { 1, 0 }, { 0, 1 } };
		case 6: // 하좌
			return new int[][] { { 1, 0 }, { 0, -1 } };
		case 7: // 상좌
			return new int[][] { { -1, 0 }, { 0, -1 } };
		default:
			break;
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			v = new boolean[N][M];

			int startPipeNum = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int pipeNum = Integer.parseInt(st.nextToken());
					map[i][j] = pipeNum;
					if (i == R && j == C)
						startPipeNum = pipeNum;
				}
			}
			//

			bfs(new Pipe(R, C, 1, startPipeNum));
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (v[i][j])
						result += 1;
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}

	private static void bfs(Pipe start) {
		ArrayDeque<Pipe> q = new ArrayDeque<>();
		q.offer(start);
		v[start.y][start.x] = true;
		while (!q.isEmpty()) {
			Pipe cur = q.poll();
			int[][] move = setPipe(cur.num);

			for (int[] yx : move) {
				int ny = cur.y + yx[0];
				int nx = cur.x + yx[1];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M || map[ny][nx] <= 0 || v[ny][nx])
					continue;
				boolean flag = false;
				for (int[] a : setPipe(map[ny][nx])) {
					int checkI = ny + a[0];
					int checkJ = nx + a[1];
					if (cur.y == checkI && cur.x == checkJ) {
						flag = true;
						break;
					}
				}
				if (cur.time + 1 <= L && flag) {
					v[ny][nx] = true;
					q.offer(new Pipe(ny, nx, cur.time + 1, map[ny][nx]));
				}
			}

		}

	}

}

//1
//5 6 2 1 3      
//0 0 5 3 6 0
//0 0 2 0 2 0
//3 3 1 3 7 0
//0 0 0 0 0 0
//0 0 0 0 0 0
