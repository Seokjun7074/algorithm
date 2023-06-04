package BOJ;

import java.util.*;

public class Main_bj_13549_숨바꼭질3 {
	static int N, K, X;
	static int MAX = 100_001;
	static int[] map = new int[MAX]; // n까지 걸린 시간
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		Arrays.fill(map, Integer.MAX_VALUE);
		bfs(N, 0);
		System.out.println(map[K]);
	}

	private static void bfs(int n, int t) {
		map[n] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
		q.offer(new int[] { n, t });
		while (!q.isEmpty()) {
			int[] nt = q.poll();
			n = nt[0]; // 현재 위치
			t = nt[1]; // 현재 걸린 시간
			if (t < map[n])
				map[n] = t;
			if (n + 1 >= 0 && n + 1 < MAX && t + 1 < map[n + 1]) {
				q.offer(new int[] { n + 1, t + 1 });
			}
			if (n - 1 >= 0 && n - 1 < MAX && t + 1 < map[n - 1]) {
				q.offer(new int[] { n - 1, t + 1 });
			}
			if (n * 2 >= 0 && n * 2 < MAX && t < map[n * 2]) {
				q.offer(new int[] { n * 2, t  });
			}
		}
	}
}
