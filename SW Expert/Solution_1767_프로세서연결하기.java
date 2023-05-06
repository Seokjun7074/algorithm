package SWE;

import java.io.*;
import java.util.*;

public class Solution_1767_프로세서연결하기 {
	static class Node {
		int y, x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			String str = "[" + y + "," + x + "]";
			return str;
		}
	}

	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };
	static int N;
	static int map[][];
	static int copy[][];
	static int coreSize; // 코어 개수
	static ArrayList<Node> core; // 코어들의 좌표 list
	static Node[] tmpCore;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			coreSize = 0;
			min = Integer.MAX_VALUE;
			core = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						coreSize += 1;
						core.add(new Node(i, j));
					}
				}
			}
			//
			for (int R = coreSize; R > 0; R--) {
				tmpCore = new Node[R];
				combi(0, 0, R);
				if (min < Integer.MAX_VALUE)
					break;
			}
			sb.append("#").append(test).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void combi(int cnt, int start, int R) {
		if (cnt == R) {
			dfs(0, 0);
			return;
		}
		for (int i = start; i < coreSize; i++) {
			tmpCore[cnt] = core.get(i);
			combi(cnt + 1, i + 1, R);
		}
	}

	static void dfs(int idx, int sum) {
		if (idx == tmpCore.length) {
			min = Math.min(min, sum);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int y = tmpCore[idx].y;
			int x = tmpCore[idx].x;
			int count = 0;
			boolean success = false;

			while (true) {
				y += di[d];
				x += dj[d];
				if (y < 0 || y >= N || x < 0 || x >= N) { // 벽에 닿는 경우
					success = true;
					break;
				}
				if (map[y][x] != 0) {// 다른 노드나 선 만나느 경우
					break;
				}
				map[y][x] = 2; // 전선
				count += 1;
			}
			//
			if (success)
				dfs(idx + 1, sum + count);
			while (true) {
				y -= di[d];
				x -= dj[d];
				if (x == tmpCore[idx].x && y == tmpCore[idx].y)
					break;
				map[y][x] = 0;
			}
		}
	}

}
