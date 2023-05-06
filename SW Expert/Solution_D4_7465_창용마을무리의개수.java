package SWE;

import java.util.*;

public class Solution_D4_7465_창용마을무리의개수 {
	static int N, M;
	static int[] g;
	static int[] check;

	private static int find(int a) {
		if (g[a] == a)
			return a;
		return g[a] = find(g[a]);
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB)
			return false;
		if (rootA < rootB) {
			g[rootB] = rootA;
		} else {
			g[rootA] = rootB;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			g = new int[N + 1];
			HashSet<Integer> set = new HashSet<>();
			// set
			for (int i = 0; i < N + 1; i++)
				g[i] = i;
			//
			for (int t = 0; t < M; t++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				union(a, b);
			}
			for (int i = 1; i <= N; i++)
				set.add(find(i));

			System.out.printf("#%d %d\n", test_case, set.size());
		}
	}
}
