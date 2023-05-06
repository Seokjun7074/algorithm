package SWE;

import java.util.*;

public class Solution_D4_3289_서로소집합 {

	static int n, m;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			n = sc.nextInt();
			arr = new int[n + 1];
			// set
			for (int i = 0; i < n + 1; i++) {
				arr[i] = i;
			}

			m = sc.nextInt();
			for (int t = 0; t < m; t++) {
				int cal = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (cal == 0)
					union(a, b);
				else {
					if (find(a) == find(b))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			System.out.println(sb);
		}

	}

	private static int find(int num) {
		if (arr[num] == num)
			return num;
		return arr[num] = find(arr[num]);
	}

	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if (rootA == rootB)
			return false;
		arr[rootB] = rootA;
		return true;
	}

}
