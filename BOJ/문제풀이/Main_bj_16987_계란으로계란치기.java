package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_16987_계란으로계란치기 {

	static int N;
	static int[][] eggs;
	static int[] dura;
	static int[] weight;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		eggs = new int[N][2];
		dura = new int[N];
		weight = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++)
				eggs[i][j] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0); // 0번째 계란부터 시작 , 이 땐 깨진 계란 0개
		System.out.println(max);
	}

	static void dfs(int idx, int cnt) {
		// 마지막 계란까지 다 들어봤으면 종료
		// 현재 계란 말고 계란이 다 깨져있으면 종료
		if (idx == N || cnt == N - 1) {
			// 최댓값 갱신
			max = Math.max(max, cnt);
			return;
		}
		// 손으로 든 계란이 이미 깨져있으면 다음꺼 잡기
		if (eggs[idx][0] <= 0) {
			// 다음 계란을 들어 봄
			dfs(idx + 1, cnt);
			return;
		}
		// 다른 계란들과 모두 부딪혀봄
		int tmpCount = cnt;
		for (int i = 0; i < N; i++) {
			// 손으로 들고 있는 계란과 부딪히려고 하는 계란이 같은 계란이라면 통과
			// 부딪혀 보려고 하는 계란이 이미 깨져있다면 통과
			if (i == idx || eggs[i][0] <= 0)
				continue;
			// 계란끼리 부딪혀봄 (현재 손에 들고 있는 계란의 인덱스, 부딪혀보려는 타겟 계란 인덱스)
			eggs[idx][0] -= eggs[i][1];
			eggs[i][0] -= eggs[idx][1];
			// 부딪혀 봤는데 손에 든 계란이 깨지면 cnt++
			if (eggs[idx][0] <= 0) {
				cnt++;
			}
			// 부딪혀 봤는데 타겟이 된 계란이 깨지면 cnt++
			if (eggs[i][0] <= 0) {
				cnt++;
			}
			// 재귀 호출 -> 다음 계란 들어 봄
			dfs(idx + 1, cnt);
			// for문의 다음 i를 위해 값을 원상복구 해 줌
			eggs[idx][0] += eggs[i][1];
			eggs[i][0] += eggs[idx][1];
			cnt = tmpCount;
		}
	}

}
