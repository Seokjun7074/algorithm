package SWE;

import java.io.*;
import java.util.*;

public class Solution_D6_1263_사람네트워크 {
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 0)
						map[i][j] = 1000000;
					if (i == j)
						map[i][j] = 0;
				}
			}
			//
			for (int k = 0; k < N; k++) {
				for (int y = 0; y < N; y++) {
					for (int x = 0; x < N; x++) {
						map[y][x] = Math.min(map[y][x], map[y][k] + map[k][x]);
					}
				}
			}
			int min = Integer.MAX_VALUE;
			for (int y = 0; y < N; y++) {
				int sum = 0;
				for (int x = 0; x < N; x++)
					sum += map[y][x];
				min = Math.min(min, sum);
			}
			System.out.println("#" + tc + " " + min);
		}
	}
}