package SWE;

import java.io.*;
import java.util.*;

public class Solution_D2_파리퇴치 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			int max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 로직
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int sum = 0;
					for (int x = i; x < i + M; x++) {
						for (int y = j; y < j + M; y++) {
							sum += arr[x][y];
						}
					}
					if (sum > max)
						max = sum;
				}
			}

			System.out.printf("#%d %d\n",test_case,max);

		}
	}

}
