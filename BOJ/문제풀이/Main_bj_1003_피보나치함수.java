package BOJ;

import java.util.*;

public class Main_bj_1003_피보나치함수 {
	static int[] zero;
	static int[] one;

	static void fibo(int n) {
		if(n<2)return;
		for (int i = 2; i <= n; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			zero = new int[41];
			one = new int[41];
			zero[0]=1;
			zero[1]=0;
			one[0]=0;
			one[1]=1;
			int input = sc.nextInt();
			
			fibo(input);
			System.out.println(zero[input] + " " + one[input]);
		}
	}

}
