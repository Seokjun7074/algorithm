package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_bj_3040_백설공주와일곱난쟁이 {
	static int[] arr = new int[9];
	static int[] real = new int[7];

	static void combi(int cnt, int start) {
		if (cnt == 7) {
			int sum = Arrays.stream(real).sum();
			if (sum == 100) {
				for (int x : real)
					System.out.println(x);
			}
			return;
		}
		for (int i = start; i < 9; i++) {
			real[cnt] = arr[i];
			combi(cnt + 1, i + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		combi(0, 0);
	}

}
