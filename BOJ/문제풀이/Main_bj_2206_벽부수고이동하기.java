package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2206_벽부수고이동하기 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };

	static int N, M;
	static int[][] map;
	static boolean[][][] v;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = str.charAt(j) - '0';
		}
		//
		bfs(0, 0, 0, 1);
		System.out.println(-1);
	}

	private static void bfs(int i, int j, int crash, int cnt) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j, crash, cnt });

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int curI = ij[0];
			int curJ = ij[1];
			int curCrash = ij[2];
			int curCnt = ij[3];

			if (curI == N - 1 && curJ == M - 1) {
				System.out.println(curCnt);
				System.exit(0);
			}

			for (int d = 0; d < 4; d++) {
				int ni = curI + di[d];
				int nj = curJ + dj[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M)
					continue;

				if (map[ni][nj] == 0) {
					// 벽 아직 안부숨
					if (curCrash == 0 && !v[ni][nj][0]) {
						q.offer(new int[] { ni, nj, 0, curCnt + 1 });
						v[ni][nj][0] = true;
					}
					// 벽 부순적 있는 경우
					else if (curCrash == 1 && !v[ni][nj][1]) {
						q.offer(new int[] { ni, nj, 1, curCnt + 1 });
						v[ni][nj][1] = true;
					}
				} else if (map[ni][nj] == 1) {
					// 아직 안부쉈으면 부수기
					if (curCrash == 0) {
						q.offer(new int[] { ni, nj, 1, curCnt + 1 });
						v[ni][nj][1] = true;
					}
				}
			}
		}
	}

}
