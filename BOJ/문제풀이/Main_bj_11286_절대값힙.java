package BOJ;

import java.util.*;
import java.io.*;

public class Main_bj_11286_절대값힙 {

	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				if (Math.abs(x) < Math.abs(y)) {
					return -1;
				} else if (Math.abs(x) == Math.abs(y)) {
					return x - y;
				} else {
					return 1;
				}
			}
		});
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				if (pq.isEmpty()) {
					System.out.println(input);
				} else {
					System.out.println(pq.poll());
				}
			} else {
				pq.offer(input);
			}
		}
	}

}
