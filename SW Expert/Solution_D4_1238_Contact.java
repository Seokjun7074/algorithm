package SWE;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Solution_D4_1238_Contact {
	static int inputLength;
	static int start;
	static List<Integer>[] map;
	static int[] v;
	static int max;

	static void bfs(int s) {
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int depth = 1;
		v[s] = depth;
		q.offer(s);

		while (!q.isEmpty()) {
			int current = q.poll();
			for (int next : map[current]) {
				if (v[next] == 0) {
					v[next] = v[current] + 1;
					q.offer(next);
				}
			}
			depth = Math.max(depth, v[current]);
		}

		for (int i = 100; i >= 0; i--) {
			if (v[i] == depth) {
				max = i;
				return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final int TC = 10;
		//
		for (int test = 1; test <= TC; test++) {
			map = new List[101];
			v = new int[101];
			max = 0;
			for (int i = 0; i < map.length; i++)
				map[i] = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			inputLength = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < inputLength / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from].add(to);
			}
			//
			bfs(start);
			System.out.printf("#%d %d\n", test, max);
		}

	}
}

//24 2
//2 7 11 6 6 2 2 15 15 4 4 2 4 10 7 1 1 7 1 8 1 17 3 22