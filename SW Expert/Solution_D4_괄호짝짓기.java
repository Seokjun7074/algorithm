package SWE;

import java.io.*;
import java.util.*;

public class Solution_D4_괄호짝짓기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = 10;
		for (int test_case = 1; test_case <= TC; test_case++) {
			int length = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split("");
			Stack<String> stack = new Stack<>();

			int flag = 0;

			for (int i = 0; i < length; i++) {
				if (arr[i].equals("(") || arr[i].equals("{") || arr[i].equals("<") || arr[i].equals("[")) {
					stack.push(arr[i]);
				} else {
					if (arr[i].equals(")") && stack.peek().equals("(")) {
						stack.pop();
					} else if (arr[i].equals("}") && stack.peek().equals("{")) {
						stack.pop();
					} else if (arr[i].equals(">") && stack.peek().equals("<")) {
						stack.pop();
					} else if (arr[i].equals("]") && stack.peek().equals("[")) {
						stack.pop();
					} else {
						stack.push(arr[i]);
						break;
					}
				}
			}

			if (stack.isEmpty()) {
				flag = 1;
			}
			System.out.printf("#%d %d\n", test_case, flag);

		}
	}

}

//  ( ( ] ] ) [ ) [
