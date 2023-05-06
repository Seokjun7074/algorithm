package SWE;

import java.util.*;
import java.io.*;

public class Solution_D3_1873_상호의배틀필드 {
	static final char[] tank = { '^', 'v', '<', '>' }; // 상하좌우 => 0,1,2,3
	static final int[] di = { -1, 1, 0, 0 }; // 상하좌우 => 0,1,2,3
	static final int[] dj = { 0, 0, -1, 1 }; // 상하좌우 => 0,1,2,3
	static int[] tankPosition = new int[2]; // 탱크 위치
	static int tankHead; // 탱크가 바라보는 방향

	static char[][] map;
	static int H;
	static int W;

	static void movetank(int i, int j, int idx) {
		int ni = i + di[idx];
		int nj = j + dj[idx];
		map[i][j] = tank[idx];
		// 맵에서 벗어나지 않고 다음 칸이 평지인 경우에 탱크 위치 갱신
		if (ni >= 0 && ni < H && nj >= 0 && nj < W && map[ni][nj] == '.') {
			tankPosition[0] = ni;
			tankPosition[1] = nj;
			// 맵 갱신
			map[i][j] = '.';
			map[ni][nj] = tank[idx];
		}
	}

	static void fire(int direction) {
		if (direction == 0) { // 위로 쏴
			for (int i = tankPosition[0]; i >= 0; i--) {
				char nextStep = map[i][tankPosition[1]];
				if (nextStep == '#')
					return;
				else if (nextStep == '*') {
					map[i][tankPosition[1]] = '.';
					return;
				}

			}
		} else if (direction == 1) { // 아래로 쏴
			for (int i = tankPosition[0]; i < H; i++) {
				char nextStep = map[i][tankPosition[1]];
				if (nextStep == '#')
					return;
				else if (nextStep == '*') {
					map[i][tankPosition[1]] = '.';
					return;
				}
			}
		} else if (direction == 2) { // 좌로 쏴
			for (int i = tankPosition[1]; i >= 0; i--) {
				char nextStep = map[tankPosition[0]][i];
				if (nextStep == '#')
					return;
				else if (nextStep == '*') {
					map[tankPosition[0]][i] = '.';
					return;
				}
			}
		} else if (direction == 3) { // 우로 쏴
			for (int i = tankPosition[1]; i < W; i++) {
				char nextStep = map[tankPosition[0]][i];
				if (nextStep == '#')
					return;
				else if (nextStep == '*') {
					map[tankPosition[0]][i] = '.';
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		// 테스트 케이스마다 초기화
		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String tmp = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp.charAt(j);
					// 탱크 위치 저장
					for (int k = 0; k < 4; k++) {
						if (tank[k] == map[i][j]) {
							tankPosition[0] = i;
							tankPosition[1] = j;
							tankHead = k;
						}
					}
				}
			}
			int N = sc.nextInt();
			char[] input = sc.next().toCharArray();

			// 구현부
			int cnt = 0;
			while (cnt < N) {
				char command = input[cnt];

				if (command == 'U') {
					tankHead = 0;
					movetank(tankPosition[0], tankPosition[1], tankHead);
				} else if (command == 'D') {
					tankHead = 1;
					movetank(tankPosition[0], tankPosition[1], tankHead);
				} else if (command == 'L') {
					tankHead = 2;
					movetank(tankPosition[0], tankPosition[1], tankHead);
				} else if (command == 'R') {
					tankHead = 3;
					movetank(tankPosition[0], tankPosition[1], tankHead);
				} else if (command == 'S') {
					fire(tankHead);
				}
				cnt++;
			}
			System.out.printf("#%d ", test_case);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
// 이동하는 경우
//1. 탱크 방향 변경
//	1-1. 맵에 표시된 방향도 수정
//2. 다음 블럭 확인
//3. 평지이고 맵 내부면 이동 || 아니면 이동X
//4. 이동했으면 맵에 표시 수정

// 쏘는 경우
//1. 해당 방향으로 발사
//2. 벽만나면?
//	2-1. 벽돌이면 부수고 평지로 바꾸기
//	2-2. 강철이면 리턴
