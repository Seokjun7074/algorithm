package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_14503_로봇청소기 {
	// 북동남서
	static final int[] di = new int[] { -1, 0, 1, 0 };
	static final int[] dj = new int[] { 0, 1, 0, -1 };

	static int N, M, count;
	static int[][] map;
	static boolean[][] v;

	static class Robot {
		int y, x, d;

		public Robot(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		count = 0;
		map = new int[N][M];
		v = new boolean[N][M];

		st = new StringTokenizer(br.readLine());
		Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		//
		bfs(robot);
		System.out.println(count);
	}

	private static void bfs(Robot r) {
		ArrayDeque<Robot> q = new ArrayDeque<>();
		q.offer(r);

		while (!q.isEmpty()) {
			Robot current = q.poll();
			if (map[current.y][current.x] == 0) {
				map[current.y][current.x] = 4;
				count += 1;
			}
			boolean isDirty = false;
			// 4방탐색
			for (int d = 0; d < 4; d++) {
				int nextDir = (current.d + 3) % 4;
				int ny = current.y + di[nextDir];
				int nx = current.x + dj[nextDir];
				if (ny < 0 || ny >= N || nx < 0 || nx >= M)
					continue;
				if (map[ny][nx] == 0) {
					isDirty = true; // 청소
//					System.out.println(nextDir);
					q.offer(new Robot(ny, nx, nextDir)); // 이동하고 방향 변경
					break;
				}
				current.d = nextDir;
			}
			if (!isDirty) {
				int ny = current.y - di[current.d];
				int nx = current.x - dj[current.d];
				if (map[ny][nx] == 1)
					return;
				q.offer(new Robot(ny, nx, current.d)); // 후진하고 방향 유지
			}
		}
	}
}

// 4방탐색 -> 청소할게 있는지 확인
// 없으면 현재 방향 기준으로 후진 (후진 못하면 종료)
// 있으면 반시계회전 -> 회전한 방향 기준 앞칸이 더러우면 청소
//				-> 앞칸이 깨끗하면 다시 반시계 회전

// 현재 방향
// 1 2 3 0
// 북 동 남 서
// 0 1 2 3
