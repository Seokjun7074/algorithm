package SWE;

import java.io.*;
import java.util.*;

public class Solution_D3_flatten {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언

		for (int test_case = 1; test_case <= 10; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			int[] arr = new int[100];
			int result = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			while (dump > 0) {
				arr[0] += 1;
				arr[99] -= 1;
				Arrays.sort(arr);
				if (arr[99] - arr[0] <= 1) {
					result = arr[99] - arr[0];
					break;
				}
				if (dump == 1) {
					result = arr[99] - arr[0];
				}
				dump--;
			}
			System.out.printf("#%d %d\n", test_case, result);
		}
	}
}