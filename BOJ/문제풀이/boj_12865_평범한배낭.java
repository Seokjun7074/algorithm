package BOJ;

import java.util.*;

public class Main_bj_12865_평범한배낭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int[] weight = new int[N + 1];
		int[] value = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}

		int[][] map = new int[N + 1][K + 1];

		for (int i = 1; i < N + 1; i++) { // 물건 번호
			for (int w = 1; w < K + 1; w++) { // 무게
				if (weight[i] > w)
					map[i][w] = map[i - 1][w];
				else
					map[i][w] = Math.max(map[i - 1][w], value[i] + map[i - 1][w - weight[i]]);
			}
		}
		System.out.println(map[N][K]);
	}
}
