package BOJ;

import java.math.*;
import java.util.*;

public class Main_bj_11727_2xn타일링 {
	static BigInteger[] dp;

	static BigInteger calc(int n) {
		if (dp[n] == null) {
			dp[n] = calc(n - 1).add(calc(n - 2).multiply(new BigInteger("2")));
		}
		return dp[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new BigInteger[1001];
		dp[0] = dp[1] = new BigInteger("1");
		if (n > 1)
			calc(n);
		System.out.println(dp[n].remainder(new BigInteger("10007")));
	}

}

// a % k = result
// dp[n] = dp[n-1] +(d[n-2]*2)