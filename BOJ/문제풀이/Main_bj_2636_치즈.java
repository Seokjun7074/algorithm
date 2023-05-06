package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2636_치즈 {
	static final int[] di = new int[] { -1, 0, 1, 0 };
	static final int[] dj = new int[] { 0, 1, 0, -1 };

	static int H, W;
	static int[][] map;
	static int[][] visited;
	static ArrayList<Integer> deletedCheese = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visited = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		int cnt = 1;
		int day = 0;
		while (cnt != 0) {
			visited = new int[H][W];
			cnt = bfs(0, 0, 0);
			deletedCheese.add(cnt);
			day += 1;
		}
		System.out.println(day - 1);
		System.out.println(deletedCheese.get(deletedCheese.size() - 2));
	}

	// 방문체크: 2
	// 테두리 부분: -1
	private static int bfs(int i, int j, int count) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j, count });
		visited[i][j] = 2;
		int cheeseCount = 0; // 없앨 치즈 수

		while (!q.isEmpty()) {
			int[] ij = q.poll();
			int curI = ij[0];
			int curJ = ij[1];
			int curCount = ij[2];

			for (int d = 0; d < 4; d++) {
				int ni = curI + di[d];
				int nj = curJ + dj[d];

				if (ni < 0 || ni >= H || nj < 0 || nj >= W || visited[ni][nj] == 2)
					continue;
				visited[ni][nj] = 2;
				if (map[ni][nj] == 1) { // 테두리 부분이면
					cheeseCount += 1;
					map[ni][nj] = -1; // 없어질 부분 처리
				} else {
					q.offer(new int[] { ni, nj, curCount + 1 });
				}
			}
		}
		kill();
		return cheeseCount;
	}

	static void kill() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == -1)
					map[i][j] = 0;
			}
		}
	}

}
