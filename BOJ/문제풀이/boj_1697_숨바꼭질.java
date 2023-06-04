package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1697_숨바꼭질 {
	static int N; // subin
	static int K; // sister
	static boolean v[] = new boolean[100_001];
	static int result = 0;

	static void find(int position) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { position, 0 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int curPosition = tmp[0];
			int time = tmp[1];

			if (curPosition == K) {
				result = time;
				return;
			}
			v[curPosition] = true;

			if (check(curPosition + 1)) {
				q.offer(new int[] { curPosition + 1, time + 1 });
			}
			if (check(curPosition - 1)) {
				q.offer(new int[] { curPosition - 1, time + 1 });
			}
			if (check(curPosition * 2)) {
				q.offer(new int[] { curPosition * 2, time + 1 });
			}

		}
	}

	static boolean check(int position) {
		if (position < 0 || position >= v.length || v[position])
			return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		find(N);
		System.out.println(result);
	}
}