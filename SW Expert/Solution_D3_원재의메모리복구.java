package SWE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_D3_원재의메모리복구 {
	static int count = 0;

	static void fix(int[] correct, int[] wrong, int idx) {
		for (int i = idx; i < correct.length; i++) {
			if (correct[i] != wrong[i]) {
				count++;
				if(wrong[i] ==0) {
					for(int j = i;j<wrong.length;j++) {
						wrong[j] = 1;
					}
				}else {
					for(int j = i;j<wrong.length;j++) {
						wrong[j] = 0;
					}
				}
				
				fix(correct,wrong,i+1);
			} 

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
//		 System.setIn(new FileInputStream("../res/input.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			String str = sc.next();
			int[] correct = new int[str.length()];
			int[] wrong = new int[str.length()];
			for (int i = 0; i < str.length(); i++) {
				correct[i] = str.charAt(i) - '0';
			}
			fix(correct, wrong, 0);
			System.out.printf("#%d %d \n",t,count);
			count = 0;
		}

	}

}
/*
 * // #1 0000 0011 // #2 000 111 100 100
 */

// 원본과 현재 상태(원본과 같은 길이) 비교
// 0번 인덱스부터 시작해서 달라지는 부분 찾기 tc1에서는 2번 인덱스
// 해당 인덱스부터 고치고 리턴
// 다 같을 때까지 반복