package BOJ;

import java.util.*;

public class Main_bj_1463_1로만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayDeque<int[]> q = new ArrayDeque<>();
		int min = Integer.MAX_VALUE;
		boolean[] v = new boolean[1_000_001];

		int N = sc.nextInt();
		v[N] = true;
		q.offer(new int[] { N, 0 });

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int n = cur[0];
			int cnt = cur[1];
			if (n == 1) {
				min = Math.min(min, cnt);
			}

			if (n > 1 && !v[n - 1]) {
				v[n - 1] = true;
				q.offer(new int[] { n - 1, cnt + 1 });
			}
			if (n > 1 && !v[n / 3] && n % 3 == 0) {
				v[n / 3] = true;
				q.offer(new int[] { n / 3, cnt + 1 });
			}
			if (n > 1 && !v[n / 2] && n % 2 == 0) {
				v[n / 2] = true;
				q.offer(new int[] { n / 2, cnt + 1 });
			}
		}
		System.out.println(min);
	}
}
