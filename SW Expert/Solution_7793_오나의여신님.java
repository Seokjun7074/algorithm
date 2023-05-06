package SWE;

import java.io.*;
import java.util.*;

public class Solution_7793_오나의여신님 {
	static final int[] di = new int[] { -1, 0, 1, 0 };
	static final int[] dj = new int[] { 0, 1, 0, -1 };
	static ArrayDeque<Position> q;
	static ArrayDeque<Position> devilQ;

	static int N, M, result;
	static char[][] map;

	static class Position {
		int y, x, cnt;

		public Position(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			q = new ArrayDeque<>();
			devilQ = new ArrayDeque<>();

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					char input = str.charAt(j);
					map[i][j] = input;
					if (input == '*')
						devilQ.offer(new Position(i, j));
					else if (input == 'S')
						q.offer(new Position(i, j, 0));
				}
			}
			// 입력끝
			result = 0;
			bfs();

			if (result != 0)
				System.out.println("#" + tc + " " + result);
			else
				System.out.println("#" + tc + " " + "GAME OVER");
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			// 악마 이동
			int devilSize = devilQ.size();
			for (int k = 0; k < devilSize; k++) {
				Position cur = devilQ.poll();
				for (int d = 0; d < 4; d++) {
					int ni = cur.y + di[d];
					int nj = cur.x + dj[d];

					if (ni < 0 || ni >= N || nj < 0 || nj >= M)
						continue;
					if (map[ni][nj] == '.' || map[ni][nj] == 'S') {
						map[ni][nj] = '*';
						devilQ.offer(new Position(ni, nj));
					}
				}
			}

			int qSize = q.size();
			for (int k = 0; k < qSize; k++) {
				Position cur = q.poll();

				for (int d = 0; d < 4; d++) {
					int ni = cur.y + di[d];
					int nj = cur.x + dj[d];
					if (ni < 0 || ni >= N || nj < 0 || nj >= M)
						continue;
					if (map[ni][nj] == 'D') {
						result = cur.cnt + 1;
						return;
					}
					if (map[ni][nj] == '.') {
						map[ni][nj] = 'S';
						q.offer(new Position(ni, nj, cur.cnt + 1));
					}
				}
			}
		}
	}

}
