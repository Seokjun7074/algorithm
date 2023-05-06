package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_15685_드래곤커브 {
	// 우상좌하
	static final int[] di = new int[] { 0, -1, 0, 1 };
	static final int[] dj = new int[] { 1, 0, -1, 0 };

	static final int[] bi = new int[] { 0, 1, 1 };
	static final int[] bj = new int[] { 1, 0, 1 };

	static boolean[][] map;
	static ArrayList<Integer> list;
	static int result = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		map = new boolean[101][101];
		for (int tc = 0; tc < N; tc++) {
			st = new StringTokenizer(br.readLine());
			list = new ArrayList<>();

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			list.add(d);
			map[j][i] = true;
			go(0, g);
			for (int k = 0; k < list.size(); k++) {
				int direction = list.get(k);
				i = i + dj[direction];
				j = j + di[direction];
				map[j][i] = true;
			}
		}
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j]) {
					boolean square = true;
					for (int d = 0; d < 3; d++) {
						int ni = i + bi[d];
						int nj = j + bj[d];
						if (!map[ni][nj]) {
							square = false;
							break;
						}
					}
					if (square)
						result++;
				}
			}
		}
		System.out.println(result);
	}

	static void go(int generation, int g) {
		while (generation < g) {
			int size = list.size();
			for (int i = size - 1; i >= 0; i--) {
				int item = changeDirection(list.get(i));
				list.add(item);
			}
			generation += 1;
		}
	}

	static int changeDirection(int d) {
		if (d + 1 == 4)
			return 0;
		return d + 1;
	}

}
