package SWE;

import java.io.*;
import java.util.*;

//wPn
// 폭발시키

public class Solution_5656_벽돌깨기 {
	static final int[] di = { -1, 1, 0, 0 };
	static final int[] dj = { 0, 0, -1, 1 };
	static int N, W, H;
	static int[][] map;
	static int[][] copy;

	static int[] set; // 구슬 위치 조합
	static int[] marble; // 구슬 쏠 인덱스
	static boolean[][] v; // map 체크
	static int min = Integer.MAX_VALUE;

	static void copyArr() {
		copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	static void countBlock() {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copy[i][j] > 0) {
					count += 1;
				}
			}
		}
		min = Math.min(count, min);
	}

	static void perm(int cnt) {
		if (cnt == N) {
			copyArr(); // 경우의 수 하나마다 배열 복사
			for (int t = 0; t < N; t++) {// 경우의 수 하나당 계산
				int x = set[t];
				for (int y = 0; y < H; y++) {
					if (copy[y][x] == 0)
						continue;
					v = new boolean[H][W];
					breakBlock(y, x);
					downBlock();
					break;
				}
			}
			countBlock();
			return;
		}
		for (int i = 0; i < W; i++) {
			set[cnt] = marble[i];
			perm(cnt + 1);

		}
	}

	static void breakBlock(int i, int j) {
		v[i][j] = true;
		int range = copy[i][j] - 1;
		for (int d = 0; d < 4; d++) {
			for (int k = 1; k <= range; k++) {
				int ni = i + di[d] * k;
				int nj = j + dj[d] * k;
				if (ni >= 0 && ni < H && nj >= 0 && nj < W && !v[ni][nj] && copy[ni][nj] != 0) {
					breakBlock(ni, nj);
					copy[ni][nj] = 0;
				}
			}
		}
		copy[i][j] = 0;
	}

	static void downBlock() {
		for (int x = 0; x < W; x++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int y = H - 1; y >= 0; y--) {
				if (copy[y][x] > 0) {
					list.add(copy[y][x]);
					copy[y][x] = 0;
				}
			}
			for (int y = H - 1; y >= H - list.size(); y--) {
				copy[y][x] = list.get(H - 1 - y);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			min = Integer.MAX_VALUE;
			v = new boolean[H][W];
			marble = new int[W];
			set = new int[N];
			for (int i = 0; i < W; i++) {
				marble[i] = i;
			}
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			perm(0);
			System.out.printf("#%d %d\n", test_case, min);
		}
		br.close();
	}
}