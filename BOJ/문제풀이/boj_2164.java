package BOJ;

import java.util.*;
import java.io.*;

public class Main_bj_2164 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while (q.size() > 1) {
			q.poll();
			int back = q.poll();
			q.offerLast(back);
		}
		System.out.println(q.poll());
	}
}
//123456
//34562
//5624
//246
//64
//4