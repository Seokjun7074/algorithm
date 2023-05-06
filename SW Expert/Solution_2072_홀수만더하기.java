package SWE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution_2072_홀수만더하기 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input_D1_2072.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		System.out.println("T");
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int sum=0;
			for(int j = 0; j<10; j++) {
				int num = sc.nextInt();
				if(num%2 != 0) {
					sum += num;
				}
			}
			System.out.println("#"+test_case+" "+sum);
			sum=0;
			
			
		}
	}

}
