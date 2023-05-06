package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_16938_캠프준비 {
	static int N, L, R, X, result;
	static int[] problem;
	static ArrayList<Integer> selected = new ArrayList<>();
	static boolean[] v;

	static void subs(int cnt) {
		if (cnt == N) {
			int sum = 0;
			int min = Integer.MAX_VALUE;
			int max = 0;
			selected = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (v[i]) {
					selected.add(problem[i]);
					sum += problem[i];
					min = Math.min(min, problem[i]);
					max = Math.max(max, problem[i]);
				}
			}
			if (sum >= L && sum <= R && max - min >= X)
				result += 1;
			return;
		}
		v[cnt] = true;
		subs(cnt + 1);
		v[cnt] = false;
		subs(cnt + 1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		problem = new int[N];
		v = new boolean[N];
		for (int i = 0; i < N; i++)
			problem[i] = Integer.parseInt(st.nextToken());
		//
		result = 0;
		subs(0);
		System.out.println(result);
	}

}
