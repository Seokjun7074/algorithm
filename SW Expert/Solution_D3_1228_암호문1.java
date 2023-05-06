package SWE;

import java.io.*;
import java.util.*;

public class Solution_D3_1228_암호문1 {

	public static void main(String[] args) throws IOException {
		int TC = 10;
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= TC; test_case++) {
			int originalLength = sc.nextInt();

			LinkedList<Integer> originalArray = new LinkedList<>();
			for (int i = 0; i < originalLength; i++) {
				originalArray.add(sc.nextInt());
			}

			int commandLength = sc.nextInt();

			for (int i = 0; i < commandLength; i++) {
				String tmp = sc.next();
				int position = sc.nextInt();
				int count = sc.nextInt();
				for (int j = 0; j < count; j++) {
					originalArray.add(position + j, sc.nextInt());
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case);
			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(originalArray.get(i));
			}
			System.out.println(sb);
		}
	}

}