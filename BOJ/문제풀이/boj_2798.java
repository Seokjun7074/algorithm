package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_2798 {
	static int N = 0;
	static int M = 0;
	static int[] card = new int[N];
	static int[] pick = new int[3];
	static int max = 0;

	static void combination(int cnt, int start) {
		if (cnt == 3) {
			int sum = Arrays.stream(pick).sum();
			if (sum <= M && sum >= max) {
				max = sum;
			}

			return;
		}
		for (int i = start; i < N; i++) {
			pick[cnt] = card[i];
			combination(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		// 로직
		combination(0, 0);
		System.out.println(max);
		br.close();
	}

}
