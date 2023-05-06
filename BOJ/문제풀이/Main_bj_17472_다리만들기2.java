package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_17472_다리만들기2 {
	// 상하좌우
	static final int[] di = new int[] { -1, 1, 0, 0 };
	static final int[] dj = new int[] { 0, 0, -1, 1 };

	static int N, M;
	static int[][] map, distance;
	static boolean[][] v;

	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
	static int[] parents;

	static class Node {
		int y, x, w;

		public Node(int y, int x, int w) {
			this.y = y;
			this.x = x;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		// 섬 숫자 다르게 표시
		int islandNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0 && !v[i][j]) {
					findIsland(i, j, islandNum);
					islandNum += 1;
				}
			}
		}
		// 인접행렬 만들어주기
		distance = new int[islandNum][islandNum];
		for (int[] a : distance)
			Arrays.fill(a, N * M);
		v = new boolean[N][M];
		// 섬끼리의 다리 모두 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] > 0) {
					makeBridge(i, j, map[i][j]);
				}
			}
		}
		// 다리 정보 우선순위 큐에 넣어주기
		for (int i = 1; i < islandNum; i++) {
			for (int j = i; j < islandNum; j++) {
				if (distance[i][j] != N * M && distance[i][j] != 1)
					pq.offer(new Node(i, j, distance[i][j]));
			}
		}

		// makeSet
		parents = new int[islandNum];
		for (int i = 1; i < parents.length; i++)
			parents[i] = i;
		int result = 0;
		int cnt = 0; // 간선 수 카운트
		int pqSize = pq.size();
		for (int i = 0; i < pqSize; i++) {
			Node cur = pq.poll();
			int parentFrom = find(cur.y);
			int parentTo = find(cur.x);
			if (parentFrom != parentTo) {
				union(parentFrom, parentTo);
				result += cur.w;
				cnt += 1;
				if (cnt == islandNum - 2)
					break;
			}
		}
		// 모든 섬이 연결되었는지 확인
		boolean connected = true;
		int checkParent = find(1);
		for (int i = 2; i < parents.length; i++) {
			if (checkParent != find(i)) {
				connected = false;
				break;
			}
		}

		if (result == 0 || cnt != islandNum - 2 || !connected)
			System.out.println(-1);
		else
			System.out.println(result);

	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static void union(int a, int b) {
		int aRoot = find(a); // a가 속한 대표
		int bRoot = find(b); // b가 속한 대표
		if (aRoot == bRoot)
			return;
		if (aRoot < bRoot)
			parents[bRoot] = aRoot;
		else
			parents[bRoot] = aRoot;
	}

	private static void makeBridge(int i, int j, int islandNum) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] check = new boolean[N][M];
		for (int d = 0; d < 4; d++) {
			q.offer(new int[] { i, j, 0 });
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int ni = cur[0] + di[d];
				int nj = cur[1] + dj[d];
				int length = cur[2];
				if (ni < 0 || nj < 0 || ni >= N || nj >= M || map[ni][nj] == islandNum || check[ni][nj])
					continue;
				if (map[ni][nj] > 0) {
					// distance 배열 갱신
					if (length == 1)
						continue;
					distance[islandNum][map[ni][nj]] = Math.min(length, distance[islandNum][map[ni][nj]]);
					break;
				}
				check[ni][nj] = true;
				q.offer(new int[] { ni, nj, length + 1 });
			}
		}
	}

	private static void findIsland(int i, int j, int islandNum) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { i, j });
		v[i][j] = true;
		map[i][j] = islandNum;
		while (!q.isEmpty()) {
			int[] ij = q.poll();
			for (int d = 0; d < 4; d++) {
				int ni = ij[0] + di[d];
				int nj = ij[1] + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] > 0 && !v[ni][nj]) {
					map[ni][nj] = islandNum;
					v[ni][nj] = true;
					q.offer(new int[] { ni, nj });
				}
			}
		}
	}
}
