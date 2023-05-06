package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기 {
	static int n;
	static int[][] store;
	static boolean[] v;

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			flag = false;
			n = Integer.parseInt(br.readLine());
			store = new int[n + 2][2];
			v = new boolean[n + 2];
			v[0] = true;

			for (int i = 0; i < n + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
//			for (int[] a : store)
//				System.out.println(Arrays.toString(a));
//			
			bfs(store[0]);

			if (flag)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}

	private static void bfs(int[] start) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int[] current = q.poll();
			if ((Math.abs(store[n + 1][0] - current[0]) + Math.abs(store[n + 1][1] - current[1])) <= 1000) {
				flag = true;
				return;
			}

			for (int d = 0; d < n + 2; d++) {
				int[] nextStore = store[d];
				int distance = Math.abs(nextStore[0] - current[0]) + Math.abs(nextStore[1] - current[1]);
				if (distance <= 1000 && !v[d]) {
					v[d] = true;
					q.offer(new int[] { nextStore[0], nextStore[1] });
				}
			}

		}

	}

}
