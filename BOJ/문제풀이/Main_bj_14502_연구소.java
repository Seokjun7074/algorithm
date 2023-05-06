package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_14502_연구소 {
	static final int[] di = new int[] { -1, 0, 1, 0 };
	static final int[] dj = new int[] { 0, 1, 0, -1 };

	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<int[]> virus;
	static ArrayList<int[]> blank;
	static int[][] selected = new int[3][2];
	static int[][] copy;
	static int max = -1;
	static ArrayDeque<int[]> q = new ArrayDeque<>();

	static void copyArr() {
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				copy[i][j] = map[i][j];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		virus = new ArrayList<>();
		blank = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virus.add(new int[] { i, j });
				if (map[i][j] == 0)
					blank.add(new int[] { i, j });
			}
		}
		combi(0, 0);
		System.out.println(max);

	}

	private static void combi(int cnt, int start) {
		if (cnt == 3) {
			q = new ArrayDeque<>();
			copyArr();
			for (int[] a : selected) {
				copy[a[0]][a[1]] = 1;
			}
			for (int[] a : virus) {
				q.offer(new int[] { a[0], a[1] });
			}
			bfs();
			return;
		}
		for (int i = start; i < blank.size(); i++) {
			int bi = blank.get(i)[0];
			int bj = blank.get(i)[1];
			selected[cnt] = new int[] { bi, bj };
			combi(cnt + 1, i + 1);
		}
	}

	static void bfs() {
		visited = new boolean[N][M];
		int count = 0;
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int curI = ij[0];
			int curJ = ij[1];
			for (int d = 0; d < 4; d++) {
				int ni = curI + di[d];
				int nj = curJ + dj[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M || copy[ni][nj] == 1 || visited[ni][nj])
					continue;
				visited[ni][nj] = true;
				copy[ni][nj] = 2;
				q.offer(new int[] { ni, nj });
			}
		}
		for (int[] a : copy)
			for (int safe : a) {
				if (safe == 0)
					count += 1;
			}
		max = Math.max(count, max);
	}
}
