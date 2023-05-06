package SWE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_1959_두개의숫자열 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input_D2_1959.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int max = 0;
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] A = new int[N];
			int[] B = new int[M];

			for (int i = 0; i < N; i++)
				A[i] = sc.nextInt();
			for (int i = 0; i < M; i++)
				B[i] = sc.nextInt();

			if (N < M) {
				for (int i = 0; i <= M - N; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += A[j] * B[i + j];
					};
					max = Math.max(max, sum);
				}
			} else if (N > M) {
				for (int i = 0; i <= N - M; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += A[i + j] * B[j];
					}
					max = Math.max(max, sum);
				}
			} else {
				int sum = 0;
				for (int i = 0; i < N; i++) {
					sum+=A[i]*B[i];
				}
				max = Math.max(max, sum);
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
}