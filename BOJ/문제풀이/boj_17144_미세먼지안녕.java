package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_17144_미세먼지안녕 {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static int R, C, T;
	static int[][] dust;
	static int[] aircon = new int[2];

	static void moveUp() {
		int airPosition = aircon[0];
		int tmp = dust[airPosition][0];

		for (int j = airPosition; j > 0; j--)// 6시
			dust[j][0] = dust[j - 1][0];
		for (int i = 0; i < C - 1; i++)// 9시
			dust[0][i] = dust[0][i + 1];
		for (int j = 0; j < airPosition; j++) // 12시
			dust[j][C - 1] = dust[j + 1][C - 1];
		for (int i = C - 1; i > 0; i--) // 3시
			dust[airPosition][i] = dust[airPosition][i - 1];
		dust[airPosition][0] = tmp;
		dust[airPosition][1] = 0; // 정화된 공기
	}

	static void moveDown() {
		int airPosition = aircon[1];
		int tmp = dust[airPosition][0];

		for (int j = airPosition; j < R - 1; j++) // 12시
			dust[j][0] = dust[j + 1][0];
		for (int i = 0; i < C - 1; i++)// 9시
			dust[R - 1][i] = dust[R - 1][i + 1];
		for (int j = R - 1; j > airPosition; j--)// 6시
			dust[j][C - 1] = dust[j - 1][C - 1];
		for (int i = C - 1; i > 0; i--) // 3시
			dust[airPosition][i] = dust[airPosition][i - 1];
		dust[airPosition][0] = tmp;
		dust[airPosition][1] = 0; // 정화된 공기

	}

	// 전체 배열 돌며 확산 시키기
	static void spread() {
		int[][] copy = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (dust[i][j] > 4)
					spreadCalc(i, j, copy);
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				dust[i][j] += copy[i][j];
			}
		}
	}

	// 확산 계산
	static void spreadCalc(int i, int j, int copy[][]) {
		int spreadedDust = dust[i][j] / 5; // 확산되는 먼지
		int count = 0; // 방향 수
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < R && nj >= 0 && nj < C && dust[ni][nj] != -1) {
				copy[ni][nj] += spreadedDust;
				count += 1;
			}
		}
		dust[i][j] -= (spreadedDust * count);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		dust = new int[R][C];
		int airconCnt = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == -1)
					aircon[airconCnt++] = i;
				dust[i][j] = tmp;
			}
		}
		//
		while (T-- > 0) {
			spread();
			moveUp();
			moveDown();
		}
		int res = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (dust[i][j] == -1)
					continue;
				res += dust[i][j];
			}
		}
		System.out.println(res);
	}

}

//사방으로 미세먼지 확산
//공기청정기 만나는 경우, 범위 밖 X 
//확산된 먼지 = 원래먼지/5
//남은 미세먼지 양 = 원래먼지 - 확산된 먼지*방향

// true 기준으로 확산
// 바람타고 돌리기
