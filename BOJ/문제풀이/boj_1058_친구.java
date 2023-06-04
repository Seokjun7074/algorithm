package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1058_친구 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int seleb = 0;
		int max = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = 50 * 50;
				if (str.charAt(j) == 'Y')
					map[i][j] = 1;
				if (i == j)
					map[i][j] = 0;
			}
		}
		//
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		//
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				if (map[i][j] > 0 && map[i][j] <= 2)
					sum += 1;
			}
			if (max <= sum) {
				max = sum;
				seleb = i;
			}
		}
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (map[seleb][i] != 2500 && map[seleb][i] > 0 && map[seleb][i] <= 2) {
				result += 1;
			}
		}
		System.out.println(result);

	}

}
