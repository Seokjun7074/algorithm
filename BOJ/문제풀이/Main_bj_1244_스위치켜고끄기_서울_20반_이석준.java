package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1244_스위치켜고끄기_서울_20반_이석준 {
	static int s;
	static int[] arr;
	static int people;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		StringBuilder sb = new StringBuilder();
		s = Integer.parseInt(br.readLine());
		arr = new int[s];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < s; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		people = Integer.parseInt(br.readLine());
		int student[][] = new int[people][2];

		for (int i = 0; i < people; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				student[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < people; i++) {
			int gender = student[i][0];
			int num = student[i][1];
			if (gender == 1) {
				for (int x = num - 1; x < s; x++) {
					if ((x + 1) % num == 0) {
						arr[x] = Math.abs(arr[x] - 1);
					}
				}
			} else {
				arr[num - 1] = Math.abs(arr[num - 1] - 1);
				for (int x = 1; x < s; x++) {
					int left = num - 1 - x;
					int right = num - 1 + x;
					if (left < 0 | right >= s) {
						break;
					}
					if (arr[left] == arr[right]) {
						arr[left] = Math.abs(arr[left] - 1);
						arr[right] = Math.abs(arr[right] - 1);
					} else {
						break;
					}
				}
			}
		}
		for (int i = 1; i <= arr.length; i++) {
			System.out.printf("%d ", arr[i-1]);
			if ( i % 20 == 0) {
				System.out.print("\n");
			}
		}
		br.close();
	}

}

//남자 스위치번호가 받은 수의 배수 n k*n 2k*n ....
//여자 받은 번호 기준으로 좌우 대칭이 같은 경우 n-k n+k가 같은경우
// 

//8 스위치 수
//0 1 0 1 0 0 0 1
//2 학생 수
//1 3 남자 3
//2 3 여자 3