package SWE;

import java.io.*;
import java.util.*;

public class Solution_4014_활주로건설 {
	static int N, X, count;
	static int[][] map1, map2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map1 = new int[N][N];
			map2 = new int[N][N];
			count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int input = Integer.parseInt(st.nextToken());
					map1[i][j] = input;
					map2[j][i] = input;
				}
			}
			//
			for (int i = 0; i < N; i++) {
				count += build(map1[i]);// 가로
				count += build(map2[i]);// 세로
			}
			//
			System.out.println("#" + tc + " " + count);
		}
	}

	private static int build(int[] arr) {
		boolean[] v = new boolean[N];

		for (int i = 0; i < N - 1; i++) {
			int current = arr[i];
			int next = arr[i + 1];

			// 단차가 2 이상이라 글러먹음
			if (Math.abs(current - next) > 1)
				return 0;
			if (current == next)
				continue;

			// 높이가 낮아질 때
			if (current > next) {
				for (int j = i + 1; j <= i + X; j++) {
					// 범위를 벗어나거나 이미 공사한 곳이나 다시 단차가 생기는 경우
					if (j >= N || v[j] || arr[j] != next)
						return 0;
					v[j] = true;
				}
				// 높이가 높아질 떄
			} else {
				for (int j = i; j > i - X; j--) {
					// 범위를 벗어나거나 이미 공사한 곳이나 다시 단차가 생기는 경우
					if (j < 0 || v[j] || arr[j] != current)
						return 0;
					v[j] = true;
				}
			}
		}
		return 1;
	}

}

//i번째 체크 -> 단차가 발생한 경우
//- i가 i-1보다 1만큼 낮은 경우 3322
//	i ~ i+X-1가 i랑 같은 높이인지
//
//판데기 놓으면 방문처리
//
//- i가 i-1보다 높은 경우
//	i-1~ i-X가 i랑 같은 높이인지