package BOJ;

import java.util.*;

public class Main_bj_1759_암호만들기 {
	static int N, C;
	static char[] input, output;
	static char[] check = { 'a', 'e', 'i', 'o', 'u' };
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		input = new char[C];
		output = new char[N];
		v = new boolean[C];

		for (int i = 0; i < C; i++)
			input[i] = sc.next().charAt(0);
		Arrays.sort(input);
		//
		perm(0, 0);
	}

	private static void perm(int cnt, int start) {
		if (cnt == N) {
			int count1 = 0; // 자음
			int count2 = 0; // 모음
			for (int i = 0; i < N; i++) {
				if (output[i] == 'a' || output[i] == 'e' || output[i] == 'o' || output[i] == 'i' || output[i] == 'u')
					count2 += 1;
				else
					count1 += 1;
			}
			if (count1 >= 2 && count2 >= 1) {
				for (int i = 0; i < N; i++) {
					System.out.print(output[i]);
				}
				System.out.println();
			}
			return;
		}

		for (int i = start; i < C; i++) {
			output[cnt] = input[i];
			perm(cnt + 1, i + 1);
		}
	}

}

//모음 1개, 자음 2개, 오름차순
// 6P4
// 14