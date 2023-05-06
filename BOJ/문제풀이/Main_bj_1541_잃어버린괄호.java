package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_1541_잃어버린괄호 {
	static int result = 0;
	static String[] s;

	static boolean checkNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (tmp == '+')
				return false;
		}
		return true;
	}

	static boolean checkMinus(String s) {
		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (tmp == '-')
				return true;
		}
		return false;
	}

	// +만 있는 경우
	static int sumPlus(String s) {
		String[] splitS = s.split("\\+");
		int sum = 0;
		for (int i = 0; i < splitS.length; i++) {
			sum += Integer.parseInt(splitS[i]);
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		if (checkMinus(str)) { // 마이너스가 있나?
			s = str.split("-");
			int[] newS = new int[s.length];
			for (int i = 0; i < s.length; i++) {
				if (checkNumber(s[i])) // 숫자면
					newS[i] = Integer.parseInt(s[i]);
				else // +가 있으면
					newS[i] = sumPlus(s[i]);
			}
			result = newS[0];
			for (int i = 1; i < newS.length; i++)
				result -= newS[i];

		} else {
			result = sumPlus(str);
		}
		System.out.println(result);
	}

}