package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1620_포켓몬 {

	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Map<String, String> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String pocketmon = br.readLine();
			String number = Integer.toString(i + 1);
			map.put(pocketmon, number);
			map.put(number, pocketmon);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine()) + "\n");
		}
		System.out.print(sb);
	}
}
