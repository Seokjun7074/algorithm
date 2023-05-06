package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1992_쿼드트리 {
	static int N;
	static int[][] video;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = tmp.charAt(j) - '0';
			}
		}
		//
		encode(0, 0, N);
		System.out.println(sb);
		sc.close();
	}

	static void encode(int c, int r, int size) {
		int half = size / 2;

		int sum = 0;
		for (int i = c; i < c + size; i++) {
			for (int j = r; j < r + size; j++) {
				sum += video[i][j];
			}
		}
		if (sum == size * size)
			sb.append(1);
		else if (sum == 0)
			sb.append(0);
		else {
			sb.append("(");
			encode(c, r, half);
			encode(c, r + half, half);
			encode(c + half, r, half);
			encode(c + half, r + half, half);
			sb.append(")");
		}

	}

}

// (0000)