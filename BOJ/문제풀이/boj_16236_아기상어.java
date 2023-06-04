package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어 {
	static final int[] di = new int[] { -1, 1, 0, 0 };
	static final int[] dj = new int[] { 0, 0, -1, 1 };

	static int N;
	static int[][] map;
	static boolean[][] v;
	static int[] start = new int[2];
	static int size = 2;
	static int result = 0;
	static int cnt = 0;

	private static int bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v = new boolean[N][N];
		v[i][j] = true;
		q.offer(new int[] { i, j, 0 });

		int c = Integer.MAX_VALUE;
		int r = Integer.MAX_VALUE;
		int time = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curI = cur[0];
			int curJ = cur[1];
			int curTime = cur[2];

			if (curTime > time)
				break;
			// 먹을 수 있는 경우 -> 물고기가 있고 상어 크기보다 작은 경우
			if (map[curI][curJ] > 0 && map[curI][curJ] < size) {
				if (curI < c || (curI == c && curJ < r)) {
					c = curI;
					r = curJ;
					time = curTime;
				}
			}

			for (int d = 0; d < 4; d++) {
				int ni = curI + di[d];
				int nj = curJ + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj] && size >= map[ni][nj]) {
					v[ni][nj] = true;
					q.offer(new int[] { ni, nj, curTime + 1 }); // 이동 가능한 부분만 큐에 넘겨주기
				}
			}
		}
//		System.out.println(c + " " + r + " " + time);
		if (time != Integer.MAX_VALUE) {
			eat(c, r);
			return time;
		}
		return 0;
	}

	static void eat(int ni, int nj) {
		map[ni][nj] = 0; // 빈칸으로 만들어주기
		cnt += 1; // 먹은 개수 증가
		if (cnt == size) {
			size += 1; // 벌크업
			cnt = 0; // 먹은 개수 초기화
		}
		start = new int[] { ni, nj };

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					start[0] = i;
					start[1] = j;
					map[i][j] = 0;
				}
			}
		}
		//
		while (true) {
//			System.out.println("position " + start[0] + " " + start[1]);
			int t = bfs(start[0], start[1]);
			if (t == 0)
				break;
			result += t;
		}
		System.out.println(result);
	}

}

// 아기 상어의 크기는 2
// 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
// 아기 상어보다 큰 물고기한테는 못지나감
// 아기 상어보다 작은 물고기만 먹음
// 같으면 못먹지만 지나감
// 잡아먹으면 빈칸으로 변경
// 자기 크기= 먹은 물고기 개수 -> 1증가
// 더이상 못먹으면 종료
