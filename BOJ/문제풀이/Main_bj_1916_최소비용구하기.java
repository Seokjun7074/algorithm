package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1916_최소비용구하기 {
	static class Node {
		int cost, idx;

		Node(int cost, int idx) {
			this.idx = idx;
			this.cost = cost;
		}
	}

	static int N, M;
	static ArrayList<ArrayList<Node>> list;
	static int start, end;
	static boolean[] v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 정점 개수
		M = Integer.parseInt(br.readLine()); // 간선 수개
		list = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(cost, to));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		v = new boolean[N + 1];
		//
		int[] dist = new int[N + 1]; // 최단거리 갱신용 배열
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		for (int i = 0; i < N; i++) {
			int pickedValue = Integer.MAX_VALUE;
			int pickedIdx = 0;
			// dist배열을 돌면서 현재 정점에서 갈 수 있는 최단거리의 가중치와 번호 구하기
			for (int j = 1; j < N + 1; j++) {
				// 방문하지 않는 정점들 중 가장 작은 가중치
				if (!v[j] && dist[j] < pickedValue) {
					pickedValue = dist[j];
					pickedIdx = j;
				}
			}
			if (pickedIdx == 0)
				break;
			
//			System.out.println(pickedIdx + " " + pickedValue);
//			System.out.println(Arrays.toString(dist));
			v[pickedIdx] = true;
			for (int j = 0; j < list.get(pickedIdx).size(); j++) {
				Node adj = list.get(pickedIdx).get(j); // j번 정점에서 출발하는 노드
				int tmp = dist[pickedIdx] + adj.cost; // 현재 노드를 거쳐서 adj정점까지 가는 가중치
				if (tmp < dist[adj.idx]) {
					dist[adj.idx] = tmp;
				}
			}
//			System.out.println(Arrays.toString(dist));
//			System.out.println();
		}
		System.out.println(dist[end]);

	}

}
