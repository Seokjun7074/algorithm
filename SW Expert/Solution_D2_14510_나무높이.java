package SWE;

import java.io.*;
import java.util.*;

public class Solution_D2_14510_나무높이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			int[] trees = new int[N];
			int maxHeight = 0;
			int grow = 0;
			int result = 0;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, trees[i]);
			}
			//
			int first = 0, second = 0;
			for (int i = 0; i < N; i++) {
				int diff = maxHeight - trees[i];
				if (trees[i] == maxHeight)
					continue;
				first += diff % 2;
				second += diff / 2;
			}

			if (first < second) {
				while (Math.abs(first - second) > 1) {
					second -= 1;
					first += 2;
				}
			}
			// 홀짝0짝
			if (first > second)
				result = first * 2 - 1;
			else if (second > first)
				result = second * 2;
			else
				result = second * 2;
			sb.append("#").append(test).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
