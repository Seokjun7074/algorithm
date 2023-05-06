package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2961 {
	static int N;
	static int arr[][];
	static boolean[] v;
	static int min = Integer.MAX_VALUE;

	static void subs(int cnt) {
		if (cnt == N) {
			int s = 1, b = 0;
			boolean check = false;
			for (int i = 0; i < N; i++) {
				if (v[i]) {
					s *= arr[i][0];
					b += arr[i][1];
					check = true;
				}
			}
			if (!check)
				return;
			if (Math.abs(s - b) < min)
				min = Math.abs(s - b);
			return;
		}
		v[cnt] = true;
		subs(cnt + 1);
		v[cnt] = false;
		subs(cnt + 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		v = new boolean[N];
		arr = new int[N][2]; // 입력받은 재료들

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//
		subs(0);
		System.out.println(min);
	}

}

//신맛끼리의 곱
//쓴맛은 합
//신맛과 쓴맛의 차이가 가장 작은 요리