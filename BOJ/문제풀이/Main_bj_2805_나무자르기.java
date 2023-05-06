package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2805_나무자르기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		st = new StringTokenizer(br.readLine());
		long max = 0;
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}

		long start = 0;
		long end = max;

		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;

			for (int t : tree) {
				if (t > mid)
					sum += t - mid;
			}
			if (sum >= M)
				start = mid + 1;
			else
				end = mid - 1;
		}
		System.out.println(end);
	}

}
