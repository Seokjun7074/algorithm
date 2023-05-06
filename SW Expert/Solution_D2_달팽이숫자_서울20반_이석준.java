package SWE;

import java.util.*;

public class Solution_D2_달팽이숫자_서울20반_이석준 {
	static void print(int arr[][],int size) {
		for(int i =0;i<size;i++) {
			System.out.println();
			for(int j =0;j<size;j++) {
				System.out.printf("%d ",arr[i][j]);
			}	
		}
		System.out.println();
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int dal = sc.nextInt();
			int arr[][] = new int[dal][dal];
			int max = dal * dal;
			int num = 1;

			int x = 0, y = 0;
			if(dal==1) {
				System.out.printf("#%d\n1\n" , test_case);
				continue;
			}
			while (num <= max) {
				// 오른쪽
				while (x <= dal - 1) {
					if (arr[y][x] != 0) {
						x--;
						break;
					}
					arr[y][x] = num;
					num++;
					if (x == dal - 1)
						break;
					x++;
				}
				y++;
				// 아래
				while (y <= dal - 1) {
					if (arr[y][x] != 0) {
						y--;
						break;
					}
					arr[y][x] = num;
					num++;
					if (y == dal - 1)
						break;
					y++;
				}
				x--;
				// 왼쪽
				while (x >= 0) {
					if (arr[y][x] != 0) {
						x++;
						break;
					}
					arr[y][x] = num;
					num++;
					if (x == 0)
						break;
					x--;
				}
				y--;
				// 아래
				while (y >= 0) {
					if (arr[y][x] != 0) {
						y++;
						break;
					}
					arr[y][x] = num;
					num++;

					if (y == 0)
						break;
					y--;
				}
				x++;
			}
			System.out.printf("#%d" , test_case);
			print(arr,dal);
		}
	}

}
