package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_14888_연산자끼워넣기 {
	static ArrayList<String> mark;
	static int max, min;
	static int[] number;
	static String[] arr;
	static String[] permArr;
	static boolean[] v;

	static void perm(int cnt) {
		if (cnt == mark.size()) {
			calc();
			return;
		}
		for (int i = 0; i < mark.size(); i++) {
			if (v[i])
				continue;
			v[i] = true;
			permArr[cnt] = arr[i];
			perm(cnt + 1);
			v[i] = false;

		}
	}

	static void calc() {
		int start = number[0];
		for (int i = 1; i < number.length; i++) {
			if (permArr[i - 1].equals("+")) {
				start += number[i];
			} else if (permArr[i - 1].equals("-")) {
				start -= number[i];
			} else if (permArr[i - 1].equals("*")) {
				start *= number[i];
			} else {
				start /= number[i];
			}
		}
		max = Math.max(start, max);
		min = Math.min(start, min);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		mark = new ArrayList<>();

		int n = Integer.parseInt(br.readLine());
		number = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			number[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (i == 0 && input > 0) {
				for (int j = 0; j < input; j++)
					mark.add("+");
			} else if (i == 1 && input > 0) {
				for (int j = 0; j < input; j++)
					mark.add("-");
			} else if (i == 2 && input > 0) {
				for (int j = 0; j < input; j++)
					mark.add("*");
			} else {
				for (int j = 0; j < input; j++)
					mark.add("/");
			}
		}
		arr = new String[mark.size()];
		permArr = new String[mark.size()];
		v = new boolean[mark.size()];
		for (int i = 0; i < mark.size(); i++)
			arr[i] = mark.get(i);
		//
		perm(0);
		System.out.println(max);
		System.out.println(min);
	}

}
