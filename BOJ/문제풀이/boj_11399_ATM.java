package BOJ;

import java.util.*;

public class Main_bj_11399_ATM {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = in.nextInt();
		Arrays.sort(arr);

		int prev = 0, sum = 0;
		for (int i = 0; i < N; i++) {
			sum += prev + arr[i];
			prev += arr[i];
		}
		System.out.println(sum);
	}
}