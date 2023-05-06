package SWE;

import java.io.*;
import java.util.*;

public class Solution_D3_3282_Knapsack {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int TC = 1; TC <= T; TC++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 물건 개수
			K = Integer.parseInt(st.nextToken()); // 가방 최대 무게
			int[] weight = new int[N + 1];
			int[] value = new int[K + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				weight[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}

			int[][] map = new int[N + 1][K + 1];

			for (int i = 1; i < N + 1; i++) { // 물건 번호
				for (int w = 1; w < K + 1; w++) { // 무게
					if (weight[i] > w)
						map[i][w] = map[i - 1][w];
					else
						map[i][w] = Math.max(map[i - 1][w], value[i] + map[i - 1][w - weight[i]]);
				}
			}
			System.out.print("#" + TC + " " + map[N][K] + "\n");
		}
	}

}
