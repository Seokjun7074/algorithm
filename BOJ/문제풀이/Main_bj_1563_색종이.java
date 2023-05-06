package BOJ;

import java.util.*;
import java.io.*;

public class Main_bj_1563_색종이 {

	public static void main(String[] args) {
		int result = 0;
		int paperSize = 10;
		boolean[][] paper = new boolean[101][101];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			for (int x = start; x < start + paperSize; x++) {
				for (int y = end; y < end + paperSize; y++) {
					paper[x][y] = true;
				}
			}
		}
		for (int x = 0; x < 101; x++) {
			for (int y = 0; y < 101; y++) {
				if (paper[x][y]) {
					result += 1;
				}
			}
		}
		System.out.println(result);
	}

}
