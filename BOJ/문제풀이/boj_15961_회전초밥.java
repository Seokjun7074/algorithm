package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_15961_회전초밥 {
	static int N, d, k, c;
	static int[] belt;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		belt = new int[N];
		int[] sushiList = new int[d + 1];

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		// 입력 끝
		sushiList[c] = 1; // 결국 쿠폰 초밥은 먹으니까 미리 초기화
		int eat = 1; // 이번 턴에 먹은 개수

		// 벨트의 맨 처음 k접시 먹기
		for (int i = 0; i < k; i++) {
			if (sushiList[belt[i]] == 0) // 아직 먹지 않은 초밥이면 eat 증가
				eat += 1;
			sushiList[belt[i]] += 1; // belt[i]번 초밥을 먹은 수
		}
		result = eat;

		for (int i = 1; i < N; i++) {
			//
			result = Math.max(eat, result);

			// 맨 앞에서 먹은 접시 빼주는 과정
			sushiList[belt[i - 1]] -= 1;
			if (sushiList[belt[i - 1]] == 0)
				eat -= 1;

			// 다음 접시 더해주는 과정
			if (sushiList[belt[(i + k - 1) % N]] == 0)
				eat += 1;
			sushiList[belt[(i + k - 1) % N]] += 1;
		}

		System.out.println(result);

	}

}
