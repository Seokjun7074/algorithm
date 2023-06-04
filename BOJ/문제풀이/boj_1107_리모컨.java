package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1107_리모컨 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		ArrayList<Integer> trouble = new ArrayList<>();
		int ch = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		if (M > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++)
				trouble.add(Integer.parseInt(st.nextToken()));
		}
		//
		int result = Math.abs(ch - 100); // 버튼만 조진경우
		if (result == 0) {
			System.out.println(result);
			return;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 1_000_000; i++) {
			boolean flag = true;
			String str = String.valueOf(i);
			// 고장난 버튼이 있는지 확인
			for (int j = 0; j < str.length(); j++) {
				int num = str.charAt(j) - '0';
				if (trouble.contains(num)) {
					flag = false;
					break;
				}
			}
			if (!flag)
				continue;
			int count = str.length() + Math.abs(i - ch);
			min = Math.min(min, count);
		}

		result = Math.min(result, min);
		System.out.println(result);

	}

}
