package SWE;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1974_스도쿠검증 {

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("res/input_D2_1974.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int sudoku[][] = new int[9][9];
			boolean check = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			// 가로
			for (int i = 0; i < 9; i++) {
				int checkArr[] = new int[9];
				for (int j = 0; j < 9; j++) {
					checkArr[sudoku[i][j] - 1] = 1;
				}
				for (int k = 0; k < 9; k++) {
					if (checkArr[k] == 0) {
						check = false;
						break;
					}
				}

			}
			// 세로
			for (int i = 0; i < 9; i++) {
				int checkArr[] = new int[9];
				for (int j = 0; j < 9; j++) {
					checkArr[sudoku[j][i] - 1] = 1;
				}
				for (int k = 0; k < 9; k++) {
					if (checkArr[k] == 0) {
						check = false;
						break;
					}
				}

			}
			// 격자
			for (int i = 0; i < 9; i += 3) {
				int checkArr[] = new int[9];
				for (int j = 0; j < 9; j += 3) {
					for (int x = i; x < i + 3; x++) {
						for (int y = j; y < j + 3; y++) {
							checkArr[sudoku[x][y] - 1] = 1;
						}
					}
					for (int z = 0; z < 9; z++) {
						if (checkArr[z] == 0) {
							check = false;
							break;
						}
					}
				}

			}
			
			// 결과
			if(check) {
				System.out.println("#"+test_case+" "+1);
			}else {
				System.out.println("#"+test_case+" "+0);
			}
			
		}
	}
}
