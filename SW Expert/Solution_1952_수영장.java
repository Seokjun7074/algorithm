package SWE;

import java.io.*;
import java.util.*;

public class Solution_1952_수영장 {
	static int[] pay;
	static int[] plan;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			pay = new int[4];
			plan = new int[12];
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++)
				pay[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++)
				plan[i] = Integer.parseInt(st.nextToken());
			//
			// 1년은 따로 계산
			swim(0, 0);
			min = Math.min(min, pay[3]);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}

	static void swim(int month, int sum) {
		if (month > 11) {
			min = Math.min(min, sum);
			return;
		}
		if (plan[month] == 0)
			swim(month + 1, sum);
		// 하루
		swim(month + 1, sum + (plan[month] * pay[0]));
		// 한달
		swim(month + 1, sum + pay[1]);
		// 3달
		swim(month + 3, sum + pay[2]);
	}
}

//1
//10 40 100 300   
//0 0 2 9 1 5 0 0 0 0 0 0
