package SWE;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution_D3_농작물수확하기 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			int size = Integer.parseInt(br.readLine());
			int[][] farm = new int[size][size];
			for (int i = 0; i < size; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < size; j++) {
					farm[i][j] = Integer.parseInt(line[j]);
					sum += farm[i][j];
				}
			}
			// 로직
			for (int i = 0; i < size; i++) {
				// 가운데 줄은 날리기
				if (i < size / 2) {
					for (int j = (size / 2) - 1 - i; j >= 0; j--) {
						int reverse = size - 1 - j;
						sum -= (farm[i][j] + farm[i][reverse]);
					}
				} else if (i > size / 2) {
					for (int j = 0; j < i - (size / 2); j++) {
						int reverse = size - 1 - j;
						sum -= (farm[i][j] + farm[i][reverse]);
					}
				}
			}
			System.out.printf("#%d %d\n", test_case, sum);
		}
		br.close();
	}
}
