package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main_bj_10026_적록색약 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };

	static int N;
	static char map[][];
	static boolean v[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int normalCount = 0;
		int unNormalCount = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					bfs1(i, j);
					normalCount += 1;
				}
			}
		}
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					bfs2(i, j);
					unNormalCount += 1;
				}
			}
		}
		System.out.print(normalCount+" "+unNormalCount);

	}

	// Normal
	private static void bfs1(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		v[i][j] = true;

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj] && map[i][j] == map[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] { ni, nj });
				}
			}

		}
	}

	// UnNormal
	private static void bfs2(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		v[i][j] = true;

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
					if (map[i][j] == 'B') {
						if (map[i][j] == map[ni][nj]) {
							v[ni][nj] = true;
							q.offer(new int[] { ni, nj });
						}
					} else if (map[i][j] == 'G' || map[i][j] == 'R') {
						if (map[ni][nj] != 'B') {
							v[ni][nj] = true;
							q.offer(new int[] { ni, nj });
						}
					}
				}
			}

		}
	}

}
