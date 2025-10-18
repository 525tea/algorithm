package s15;

import java.io.*;
import java.util.*;

public class S1932 {
    static int N;
    static int[][] arr;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        d = new int[N + 1][N + 1];

        // 입력 (삼각형 형태)
        for (int i = 1; i <= N; i++) { // 1-indexed
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값
        d[1][1] = arr[1][1];

        // DP
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + arr[i][j]; // 양쪽 경계값은 d[][] = 0 이므로 자동 처리됨
            }
        }

        // 마지막 줄 중 최댓값 출력
        int ans = Arrays.stream(d[N], 1, N + 1).max().getAsInt();
        System.out.println(ans);
    }
}

/**
 * 설계 요약
 * 1. dp 테이블 정의
 *     d[i][j] = i층 j번째까지의 경로 중 최대 합
 *
 * 2. 점화식
 *     d[i][j] = max(d[i-1][j-1], d[i-1][j]) + a[i][j]
 *
 * 3. 초기값
 *     d[1][1] = a[1][1]
 *
 * 4. 답
 *     max(d[n][1..n])
 *
 * 시간복잡도: O(n^2)
 * 공간복잡도: O(n^2)
 */