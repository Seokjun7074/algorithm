package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_18870_좌표압축 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(arr[i]);
		ArrayList<Integer> list = new ArrayList<>(set); // 중복제거
		list.sort((a, b) -> a - b);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			map.put(list.get(i), i);
		}

		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}

}
