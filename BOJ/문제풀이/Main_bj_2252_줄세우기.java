package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2252_줄세우기 {
	static class Node {
		int vertex;
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int N, M;
	static Node[] adjList; // 예시) [0, Node(3,link_1)]
	static int[] inDegree; // 진입차수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adjList = new Node[N + 1];
		inDegree = new int[N + 1];
		int front, back;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			front = Integer.parseInt(st.nextToken());
			back = Integer.parseInt(st.nextToken());
			adjList[front] = new Node(back, adjList[front]);
			inDegree[back]++; // 뒤에 있는 애는 앞에 있는 노드랑 연결되어있으니까 진입차수 +1
		}
		ArrayList<Integer> list = topologySort();
		for (Integer vertex : list)
			System.out.print(vertex + " ");

	}

	static ArrayList<Integer> topologySort() {
		ArrayList<Integer> orderList = new ArrayList<>();

		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0)
				q.offer(i);
		} // 진입차수가 0인 정점 큐에 넣기

		while (!q.isEmpty()) {
			int cur = q.poll();
			orderList.add(cur);
			// 현재 정점 기준으로 인접정점 처리
			for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
				inDegree[temp.vertex] -= 1;
				if (inDegree[temp.vertex] == 0) {
					q.offer(temp.vertex);
				}
			}
		}
		return orderList;
	}

}