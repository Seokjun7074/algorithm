package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_16234_인구이동 {
	static final int[] di = { -1, 0, 1, 0 };
	static final int[] dj = { 0, 1, 0, -1 };
	static int N, L, R;
	static int[][] countries;
	static boolean[][] v;

	static ArrayList<int[]> changeList;
	static int cnt;
	static int sum;

	static void dfs(int i, int j) {
		v[i][j] = true;
		changeList.add(new int[] { i, j });
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (ni >= 0 && ni < N && nj >= 0 && nj < N && !v[ni][nj]) {
				int gap = Math.abs(countries[i][j] - countries[ni][nj]);
				if (gap >= L && gap <= R) { // 국경 열리는 조건
					sum += countries[ni][nj];
					cnt++;
					v[ni][nj] = true;
					changeList.add(new int[] { ni, nj });
					dfs(ni, nj);
				}
			}
		}
	}

	static void updateCountries(int avg) {
		for (int i = 0; i < changeList.size(); i++) {
			int x = changeList.get(i)[0];
			int y = changeList.get(i)[1];
			countries[x][y] = avg;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		countries = new int[N][N];
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				countries[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 반복 시작??
		int check = 0;
		while (true) {
			Boolean flag = false;
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j])
						continue;
					changeList = new ArrayList<>();
					sum = countries[i][j];
					cnt = 1;
					dfs(i, j);
					if (cnt > 1) {
						updateCountries(sum / cnt);
						flag = true;
					}
				}
			}
			if (!flag)
				break;
			check++;
		}
		System.out.println(check);
	}

}

// 국경선 열리는 조건 L<= 인구차이 <=R
// 상하좌우 체크해서 국경 열린 값들 리스트에 저장
// dfs돌면서 하루에 true인 값 싹 더해서 나누고 배열 갱신
// 더이상 국경이 열리지 않을 때까지 반복