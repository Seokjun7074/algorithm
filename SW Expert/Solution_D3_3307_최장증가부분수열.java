package SWE;

import java.io.*;
import java.util.*;

public class Solution_D3_3307_최장증가부분수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] lis = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			//
			int max = 0;
			for (int i = 0; i < N; i++) {
				lis[i] = 1;
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) {
						lis[i] = Math.max(lis[i], lis[j] + 1);
					}
				}
				max = Math.max(max, lis[i]);
			}
			System.out.println("#" + tc + " " + max);
		}
	}

}
