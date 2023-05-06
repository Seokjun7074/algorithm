package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2239_스도쿠 {
	static int[][] map = new int[9][9];
	static ArrayList<int[]> blank = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = line.charAt(j) - '0';
				if (map[i][j] == 0)
					blank.add(new int[] { i, j });
			}
		}
		//
		find(0);
	}

	private static void find(int input) {
		if (input == blank.size()) {
			for (int[] arr : map) {
				for (int num : arr) {
					sb.append(num);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		boolean[] number = new boolean[10];
		int[] ij = blank.get(input);
		int curI = ij[0]; // 열
		int curJ = ij[1]; // 행
		// 가로체크
		for (int r = 0; r < 9; r++) {
			if (map[curI][r] != 0) {
				number[map[curI][r]] = true;
			}
		}
		// 세로체크
		for (int c = 0; c < 9; c++) {
			if (map[c][curJ] != 0) {
				number[map[c][curJ]] = true;
			}
		}
		// 네모 구간 체크
		int startI = curI / 3 * 3;
		int startJ = curJ / 3 * 3;
		for (int i = startI; i < startI + 3; i++) {
			for (int j = startJ; j < startJ + 3; j++) {
				if (map[i][j] != 0) {
					number[map[i][j]] = true;
				}
			}
		}
		// 값 넣어보기

		for (int i = 1; i < number.length; i++) {
			if (!number[i]) {
				map[curI][curJ] = i;
				find(input + 1);
				map[curI][curJ] = 0;
			}
		}

	}

}
