package BOJ;

import java.io.*;
import java.util.*;

public class Main_bj_17406_배열돌리기 {
	static int N, M, K;
	static int[][] arr;
	static int[][] originArr;
	static boolean[] v;
	static HashMap<Integer, int[]> map = new HashMap<>(); // {1 : [3, 4, 2] , ....}
	static int[] keyArr;
	static int[] permArr;
	static ArrayList<int[]> permList = new ArrayList<>();
	static int totalMin = Integer.MAX_VALUE;

	static int[][] rotate(int colLength, int rowLength, int[][] arr) {
		int rotateCount = Math.min(colLength, rowLength) / 2;
		for (int r = 0; r < rotateCount; r++) {
			int maxN = colLength - r - 1; // 세로길이
			int maxM = rowLength - r - 1; // 가로길이
			int tmp = arr[maxN][r];

			for (int j = r; j < maxM; j++)
				arr[maxN][j] = arr[maxN][j + 1];
			for (int i = maxN; i >= r + 1; i--)
				arr[i][maxM] = arr[i - 1][maxM];
			for (int j = maxM; j >= r + 1; j--)
				arr[r][j] = arr[r][j - 1];
			for (int i = r; i < maxN; i++)
				arr[i][r] = arr[i + 1][r];

			arr[maxN - 1][r] = tmp;
		}
		return arr;

	}

	static void perm(int cnt) { // cnt는 B배열의 인덱스
		if (cnt == K) {
			// COPY
			arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = originArr[i][j];
				}
			}

			int min = Integer.MAX_VALUE;

			for (int i = 0; i < K; i++) {
				calc(permArr[i]);
			}
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += arr[i][j];
				}
				if (min > sum)
					min = sum;
			}
			totalMin = Math.min(totalMin, min);
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if (v[i])
				continue;
			v[i] = true;
			permArr[cnt] = keyArr[i];
			perm(cnt + 1);
			v[i] = false;

		}
	}

	static void calc(int num) {
		int[] rcs = map.get(num);
		int r = rcs[0];
		int c = rcs[1];
		int s = rcs[2];
		int[] start = { r - s - 1, c - s - 1 }; // 0,1
		int[] end = { r + s - 1, c + s - 1 }; // 4,5

		int colLength = end[0] - start[0] + 1;
		int rowLength = end[1] - start[1] + 1;

		int[][] newArr = new int[colLength][rowLength]; // 배열 구간 쪼갠거

		for (int i = 0; i < colLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				newArr[i][j] = arr[i + start[0]][j + start[1]];
			}
		}
		newArr = rotate(colLength, rowLength, newArr);
		for (int i = 0; i < colLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				arr[start[0] + i][start[1] + j] = newArr[i][j];
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[K];
		keyArr = new int[K];
		permArr = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(st.nextToken());
				arr[i][j] = num;
			}
		}

		// COPY
		originArr = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				originArr[i][j] = arr[i][j];
			}
		}

		// kPk
		for (int test_case = 1; test_case <= K; test_case++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			map.put(test_case, new int[] { r, c, s });
			keyArr[test_case - 1] = test_case;
		}
		perm(0);
		System.out.println(totalMin);
	}
}
