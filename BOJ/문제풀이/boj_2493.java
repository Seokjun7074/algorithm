package BOJ;

import java.util.*;
import java.io.*;

public class Main_bj_2493 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		ArrayDeque<int[]> stack = new ArrayDeque();
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				if (stack.peek()[1] >= top) {
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				sb.append(0).append(" ");
			}
			stack.push(new int[] { i, top });
		}
		System.out.println(sb);

	}

}
//5
//6 9 5 7 4
