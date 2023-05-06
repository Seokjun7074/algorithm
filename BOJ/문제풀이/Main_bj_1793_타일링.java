package BOJ;

import java.math.*;
import java.util.*;

public class Main_bj_1793_타일링 {
	static BigInteger[] dp;

	static BigInteger calc(int n) {
		if (dp[n] == null)
			dp[n] = calc(n - 1).add(calc(n - 2).multiply(new BigInteger("2")));
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		while (sc.hasNextInt()) {
			n = sc.nextInt();
			dp = new BigInteger[251];
			dp[0] = new BigInteger("1");
			dp[1] = new BigInteger("1");
			if (n >= 2)
				calc(n);
			System.out.println(dp[n]);
		}
		sc.close();
	}
}
