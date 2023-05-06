package BOJ;

import java.util.*;

public class Main_bj_1676_팩토리얼0의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int two = 0;
		int five = 0;

		for (int i = 1; i <= N; i++) {
			int tmp = i;
			while (tmp % 2 == 0) {
				tmp /= 2;
				two++;
			}
			while (tmp % 5 == 0) {
				tmp /= 5;
				five++;
			}
		}

		System.out.println(Math.min(two, five));
	}

}
