package SWE;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_1961_숫자배열회전 {

	private static int[][] rotate(int arr[][]) {
		int[][] rotatedArr = new int[arr.length][arr.length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				rotatedArr[i][j] = arr[arr.length - 1 - j][i];
			}
		}
		return rotatedArr;
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input_D2_1961.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[][] rotate_90 = rotate(arr);
			int[][] rotate_180 = rotate(rotate_90);
			int[][] rotate_270 = rotate(rotate_180);

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(rotate_90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(rotate_180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(rotate_270[i][j]);
				}
				System.out.print("\n");
			}
		}
	}

}
