package boj.boj_17140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int columns = 3; // 행의 개수
	static int rows = 3; // 열의 개수

	public static void main(String[] args) {
		int[][] inputArr = new int[100][100];

		Scanner sc = new Scanner(System.in);
		// 입력 세팅
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				inputArr[i][j] = sc.nextInt();
			}
		}

		// 연산 시작
		int time;
		for (time = 0; time < 101; time++) {
			// 1행 1열부터 시작하니 -1 해주기
			if (inputArr[r - 1][c - 1] == k) {
				System.out.println(time);
				break;
			} else {
				if (rows >= columns) {
					Rfnc(inputArr);
				} else {
					Cfnc(inputArr);
				}
			}

		}
		// 100초 넘어가면 -1출력
		if (time > 100) {
			System.out.println(-1);
		}

	}

	// 행 정렬
	private static void Rfnc(int[][] arr) {
		int columnMax = 0; // columndl 가장 긴 부분
		for (int i = 0; i < rows; i++) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			List<Integer> sortedArr = new ArrayList<>(); // 정렬된거 넣을 리스트

			// 해시맵에 넣기
			for (int j = 0; j < columns; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				if (map.containsKey(arr[i][j])) {
					map.put(arr[i][j], map.get(arr[i][j]) + 1);
				} else {
					map.put(arr[i][j], 1);
				}
			}
			// value를 기준으로 해시맵 정렬
			List<Integer> keySetList = new ArrayList<>(map.keySet());
			// 정렬 함수
			Collections.sort(keySetList, (o1, o2) -> {
				if (map.get(o1) > map.get(o2)) {
					return 1;
				} else if (map.get(o1) == map.get(o2)) {
					if (o1 > o2) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			});

			for (int key : keySetList) {
				sortedArr.add(key);
				sortedArr.add(map.get(key));
			}

			// 정렬된 해시맵의 요소를 원본 리스트에 대입
			for (int j = 0; j < sortedArr.size(); j++) {
				arr[i][j] = sortedArr.get(j);
			}
			// 최대 열 개수 세기
			if (sortedArr.size() > columnMax) {
				columnMax = sortedArr.size();
			}
			// 이전 값이 남아있는 경우 0으로 바꿔주기
			for (int j = sortedArr.size(); j < 100; j++) {
				arr[i][j] = 0;
			}

		}
		// 최대 열 개수 갱신
		columns = columnMax;
	}

	// 열 정렬
	private static void Cfnc(int[][] arr) {

		int rowMax = 0;
		for (int i = 0; i < columns; i++) {
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			List<Integer> sortedArr = new ArrayList<>();

			// 해시맵에 넣기
			for (int j = 0; j < rows; j++) {
				if (arr[j][i] == 0) {
					continue;
				}
				if (map.containsKey(arr[j][i])) {
					map.put(arr[j][i], map.get(arr[j][i]) + 1);
				} else {
					map.put(arr[j][i], 1);
				}
			}
			// value를 기준으로 해시맵 정렬
			List<Integer> keySetList = new ArrayList<>(map.keySet());
			Collections.sort(keySetList, (o1, o2) -> {
				if (map.get(o1) > map.get(o2)) {
					return 1;
				} else if (map.get(o1) == map.get(o2)) {
					if (o1 > o2) {
						return 1;
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			});
			for (int key : keySetList) {
				sortedArr.add(key);
				sortedArr.add(map.get(key));
			}

			// 정렬된 해시맵의 요소를 원본 리스트에 대입
			for (int j = 0; j < sortedArr.size(); j++) {
				arr[j][i] = sortedArr.get(j);
			}
			// 최대 열 개수 세기
			if (sortedArr.size() > rowMax) {
				rowMax = sortedArr.size();
			}
			// 이전 값이 남아있는 경우 0으로 바꿔주기
			for (int j = sortedArr.size(); j < 100; j++) {
				arr[j][i] = 0;
			}

		}
		// 최대 열 개수 갱신
		rows = rowMax;
	}
}
