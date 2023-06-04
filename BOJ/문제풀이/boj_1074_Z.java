package BOJ;

import java.util.*;
import java.io.*;

public class Main_bj_1074_Z {
	static final int di[] = { 0, 0, 1, 1 };
	static final int dj[] = { 0, 1, 0, 1 };

	static int N, x, y;
	static int[][] arr;

	static int C = 0;

	static void zFunction(int r, int c, int size) {
//		System.out.println(r + " " + c + " " + size);
//		System.out.println(x + " " + y);
		if (size == 2) {
			for (int d = 0; d < 4; d++) {
				int ni = r + di[d];
				int nj = c + dj[d];
				if (ni >= r && ni < r + size && nj >= c && nj < c + size) {
					if (ni == x && nj == y) {
						System.out.println(C);
						return;
					}
					C++;
				}

			}
		} else {
			int half = size / 2;
			int num = size * size;
			if (x >= r && x < r + half && y >= c && y < c + half) {
				C = C;
				zFunction(r, c, half);
			} else if (x >= r && x < r + half && y >= c + half && y < c + size) {
				C += num / 4;
				zFunction(r, c + half, half);
			} else if (x >= r + half && x < r + size && y >= c && y < c + half) {
				C += num / 4 * 2;
				zFunction(r + half, c, half);
			} else if (x >= r + half && x < r + size && y >= c + half && y < c + size) {
				C += num / 4 * 3;
				zFunction(r + half, c + half, half);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();

		int pow = (int) Math.pow(2, N); // 한 변의 길이
//		arr = new int[pow][pow];

		zFunction(0, 0, pow);

//		for (int[] ia : arr) {
//			System.out.println(Arrays.toString(ia));
//		}
	}

}
// N 수행
// 1 1번
// 2 4번
// 3 16번
// 4 64번
