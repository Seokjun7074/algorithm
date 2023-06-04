package BOJ;

import java.util.*;

public class Main_bj_1927_최소힙 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int input = sc.nextInt();
			if (input > 0)
				pq.add(input);
			else {
				if (pq.isEmpty()) {
					System.out.println(0);
				} else {
					int output = pq.poll();
					System.out.println(output);
				}
			}
		}
	}
}
