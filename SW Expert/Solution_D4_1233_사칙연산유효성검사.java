package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_1233_사칙연산유효성검사 {
	static final int TC = 10;
	static int N;
	static int result = 1;

	static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = Integer.parseInt(br.readLine());
			result = 1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int length = st.countTokens();
				if (length == 2) {
					String trash = st.nextToken();
					String tmp = st.nextToken();
					if (!isInteger(tmp)) {
						result = 0;
					}
				} else if (length == 4) {
					String trash = st.nextToken();
					String tmp = st.nextToken();
					if (isInteger(tmp)) {
						result = 0;
					}

				}
			}
			System.out.printf("#%d %d\n", test_case, result);
		}

	}

}
