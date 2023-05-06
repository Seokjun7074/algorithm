package SWE;

import java.io.*;
import java.util.*;

public class Solution_D3_Ladder1 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			int start = 0;

			for (int i = 0; i < arr.length; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 로직
			for (int i = 0; i < arr.length; i++) {
				if (arr[99][i] == 2) {
					start = i;
				}
			}

			int height = 99;
			int result;

			while (height > 0) {
				if (height == 0) {
					result = start;
				}
				if (start < 99 && arr[height][start + 1] == 1) {
					while ((start + 1) < 100) {
						start++;
						if (arr[height - 1][start] == 1)
							break;
					}
					height--;
					continue;
				}
				if (start > 0 && arr[height][start - 1] == 1) {
					while ((start - 1) >= 0) {
						start--;
						if (arr[height - 1][start] == 1)
							break;
					}
					height--;
					continue;
				}
				height--;
			}
			sb.append("#").append(test_case).append(" ").append(start).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}