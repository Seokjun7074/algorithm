package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_bj_15652 {
	static Scanner sc = new Scanner(System.in);
	static int N = sc.nextInt();
	static int M = sc.nextInt();
	static int arr[] = new int[N];
	static int combiArr[] = new int[M];

	static void combi(int cnt, int start) {
		if (cnt == M) {

			for (int i = 0; i < M; i++) {
				System.out.printf("%d ",combiArr[i]);
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			combiArr[cnt] = arr[i];
			combi(cnt + 1, i );
		}
	}

	public static void main(String[] args) {

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		// 3C1
		combi(0, 0);
	}

}
