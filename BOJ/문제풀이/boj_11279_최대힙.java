package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_11279_최대힙 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				sb.append(q.size() == 0 ? 0 : q.poll()).append('\n');
			else
				q.add(num);
		}
		System.out.println(sb.toString());
	}
}