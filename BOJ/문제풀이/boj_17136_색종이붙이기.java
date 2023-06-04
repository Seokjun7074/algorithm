package BOJ;

import java.io.*;
import java.util.*;

public class Main_17136_색종이붙이기 {
	static final int[] di = new int[] {};
	static int[] paper = new int[] { 0, 5, 5, 5, 5, 5 }; // 남은 종이 개수
	static int[][] map = new int[10][10];
	static int min = Integer.MAX_VALUE;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				int input = Integer.parseInt(st.nextToken());
				map[i][j] = input;
				if (input == 1)
					list.add(new Node(i, j));
			}
		}
		//
		find(0, 0);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	static void find(int idx, int cnt) {
		if (idx == list.size()) {
			if (isClear()) {
				min = Math.min(cnt, min);
//				min = Math.min(25 - sum, min);
			}
			return;
		}
		if (cnt >= min)
			return;
		Node cur = list.get(idx);

		if (map[cur.r][cur.c] == 1) {
			for (int num = 5; num >= 1; num--) {
				if (checkSize(cur.r, cur.c, num) && paper[num] > 0) {
					changeVisited(cur.r, cur.c, num, 0);
					paper[num]--;
					find(idx + 1, cnt + 1);
					changeVisited(cur.r, cur.c, num, 1);
					paper[num]++;
				}
			}
		} else {
			find(idx + 1, cnt);
		}
	}

	private static void changeVisited(int i, int j, int size, int change) {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				int ni = i + y;
				int nj = j + x;
				map[ni][nj] = change;
			}
		}
	}

	static boolean checkSize(int i, int j, int size) {
		for (int y = 0; y < size; y++) {
			for (int x = 0; x < size; x++) {
				int ni = i + y;
				int nj = j + x;
				if (ni < 0 || ni >= 10 || nj < 0 || nj >= 10 || map[ni][nj] == 0)
					return false;
			}
		}
		return true;
	}

	static boolean isClear() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}
		return true;
	}
}
