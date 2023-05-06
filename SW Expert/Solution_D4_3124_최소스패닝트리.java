package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_3124_최소스패닝트리 {
	static int V, E;
//  static List<Integer>[] list;
	static int[][] edges;
	static boolean[] v;
	static int[] p;

	static void makeSet() {
		for (int i = 1; i < V + 1; i++)
			p[i] = i;
	}

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;
		p[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			p = new int[V + 1];
//          list = new List[V];
			edges = new int[E][3];

//          for (int i = 0; i < E; i++)
//              list[i] = new ArrayList<>();
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new int[] { from, to, weight };
//              list[i].add(Integer.parseInt(st.nextToken()));
//              list[i].add(Integer.parseInt(st.nextToken()));
//              list[i].add(Integer.parseInt(st.nextToken()));
			}
			//
			Arrays.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));
//          Arrays.sort(list, (o1, o2) -> Integer.compare(o1.get(2), o2.get(2)));
			makeSet();
			long W = 0L;
			long cnt = 0L;
//          for (List<Integer> s : list) {
			for (int[] s : edges) {
				int from = s[0];
				int to = s[1];
				long weight = s[2];
//              int from = s.get(0);
//              int to = s.get(1);
//              long weight = s.get(2);
				if (union(from, to)) {
					W += weight;
					if (++cnt == V - 1)
						break;
				}
			}
			System.out.printf("#%d %d\n", test, W);
			//
		}
	}

}