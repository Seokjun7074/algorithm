package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_13023_ABCDE {
	static int N, M;
	static List<Integer>[] friends;
	static boolean[] v;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		friends = new List[N];
		v = new boolean[N];

		for (int i = 0; i < N; i++)
			friends[i] = new ArrayList<Integer>();

		for (int f = 0; f < M; f++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			friends[i].add(j);
			friends[j].add(i);
		}
		for (int i = 0; i < N; i++) {
			if (result == 1)
				break;
			v = new boolean[N];
			dfs(i, 1);
		}
		System.out.println(result);
	}

	private static void dfs(int current, int count) {
		if (count == 5) {
			result = 1;
			return;
		}
		v[current] = true;
		for (int i : friends[current]) {
			if (!v[i])
				dfs(i, count + 1);
		}
		v[current] = false;
	}

}