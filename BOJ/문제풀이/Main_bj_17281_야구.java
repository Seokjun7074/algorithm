package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_17281_야구 {

	static int N; // 이닝 수
	static int[][] map;
	static int[] players; // 타자 순서
	static boolean[] v;
	static int max = 0;

	static void permutation(int cnt) { // 1번 타자를 제외하고 나머지 선수들 순서 정하기
		if (cnt == 9) {
//			System.out.println(Arrays.toString(players));
			play();
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (v[i])
				continue;
			v[i] = true;
			players[i] = cnt;
			permutation(cnt + 1);
			v[i] = false;
		}

	}

	static void play() {
		int score = 0, startPlayer = 0;

		for (int i = 0; i < N; i++) { // 이닝
			int out = 0;
			boolean[] base = new boolean[3]; // 1루 2루 3루

			label: while (true) {
				for (int p = startPlayer; p < 9; p++) { // 선수
					int curPlayer = map[i][players[p]];
					switch (curPlayer) {
					case 0:
						out += 1;
						break;
					case 1:
						for (int k = 2; k >= 0; k--) {
							if (base[k]) {
								if (k == 2) {
									score += 1;
									base[k] = false;
									continue;
								}
								base[k] = false;
								base[k + 1] = true;
							}
						}
						base[0] = true;
						break;
					case 2:
						for (int k = 2; k >= 0; k--) {
							if (base[k]) {
								if (k == 2 || k == 1) {
									score += 1;
									base[k] = false;
									continue;
								}
								base[k + 2] = true;
								base[k] = false;
							}
						}
						base[1] = true;
						break;
					case 3:
						for (int k = 2; k >= 0; k--) {
							if (base[k]) {
								base[k] = false;
								score += 1;
							}
						}
						base[2] = true;
						break;
					case 4:
						score += 1;
						for (int k = 2; k >= 0; k--) {
							if (base[k]) {
								base[k] = false;
								score += 1;
							}
						}
						break;
					}
					if (out == 3) {
						startPlayer = p + 1;
						if (startPlayer == 9)
							startPlayer = 0;
						break label;
					}
				}
				startPlayer = 0;
			} // 게임
		} // 이닝
		max = Math.max(score, max);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][9];
		players = new int[9];
		v = new boolean[9];

		players[3] = 0;
		v[3] = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		permutation(1);
		play();
		System.out.println(max);
	}

}

// 9번 타자까지 돌았는데 3아웃이 아니면 다시 1번타자부터 쳐

// 1~9번까지 선수있음
// 1번선수는 4번 고정

// 타자가 공 치면 주자 갱신

// 1이닝이 끝나는 조건: 3아웃

// 입력 예시
//2
//4 0 0 0 1 1 1 0 0
//0 0 0 0 0 0 0 0 0

// 1이닝: 1번타자 홈런
//		 5번타자 안타
//		 6번타자 안타
//		 7번타자 안타
// 2이닝 : 0점

// 최대 점수
//안타-안타-안타-홈런