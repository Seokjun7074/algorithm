package BOJ;

import java.util.Scanner;

public class Main_bj_17478 {
	static int N;
	static String underBar = "____";
	static String intro = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";

	static String q1 = "\"재귀함수가 뭔가요?\"";

	static String q2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String q3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String q4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";

	static String a1 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String a2 = "라고 답변하였지.";

	static void recur(int num) {
		String indent = "";
		for (int i = 0; i < num; i++) {
			indent += underBar;
		}

		System.out.println(indent+q1);
		if (num == N) {
			System.out.println(indent+a1);
			System.out.println(indent+a2);
			return;
		} else {
			System.out.println(indent+q2);
			System.out.println(indent+q3);
			System.out.println(indent+q4);
			recur(++num);
			System.out.println(indent+a2);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println(intro);
		recur(0);

	}
}
