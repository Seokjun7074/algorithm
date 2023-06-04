package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_16919_봄버맨2 {

	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int R, C, N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				if (s.charAt(j) == '.') {
					map[i][j] = 0;
				} else {
					map[i][j] = 3;
				}
			}
		}

		if (N % 2 == 0) {
			set(N);
		} else {
			// n 초에 터지게 값 저장
			for (int n = 2; n <= N; n++) {
				N = N % 4 + 4;
				// 폭탄 설치
				if (n % 2 == 0) {
					set(n);
				} else {
					bomb(n);
				}
			}
		}
		printArray();
	}

	private static void set(int n) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 0)
					map[i][j] = n + 3;
			}
		}
	}

	private static void bomb(int n) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == n) {
					map[r][c] = 0;
					for (int i = 0; i < 4; i++) {
						int nr = r + di[i];
						int nc = c + dj[i];
						if (nr < 0 || nc < 0 || nr >= R || nc >= C)
							continue;
						if (map[nr][nc] == n)
							continue;
						map[nr][nc] = 0;
					}
				}
			}
		}
	}

	private static void printArray() {
		for (int[] ints : map) {
			for (int i : ints) {
				if (i == 0)
					System.out.print(".");
				else
					System.out.print("O");
			}
			System.out.println();
		}
	}

}