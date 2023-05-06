package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_16967_배열복원하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] A = new int[H][W];
		int[][] B = new int[H + X][W + Y];

		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++)
				B[i][j] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (i >= X && j >= Y) {
					A[i][j] = B[i][j] - A[i - X][j - Y];
					continue;
				}
				A[i][j] = B[i][j];
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

}