package s15;

import java.io.*;

public class S2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];
        int[][] d = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        d[1][1] = a[1];
        d[1][2] = 0; // 생략 가능

        for (int i = 2; i <= N; i++) {
            d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
            d[i][1] = d[i-1][0] + a[i];
            d[i][2] = d[i-1][1] + a[i];
        }

        int ans = Math.max(d[N][0], Math.max(d[N][1], d[N][2]));
        System.out.println(ans);
    }
}

/**
 * 현재까지 고려했을 때 연속으로 몇 잔인지(0 or 1 or 2)
 * 계단오르기(boj 2579)와 달리 0도 고려한 이유는 마지막 잔 안 마심도 가능 옵션이기 때문
 *
 * 1. dp 테이블
 *    d[i][j] = i번째 잔까지 고려했을 때, j잔 연속으로 마신 최대 포도주 양
 *       j = 0 → 이번 잔 안 마심
 *       j = 1 → 이번 잔 1잔째
 *       j = 2 → 이번 잔 2잔째
 *
 * 2. 점화식
 *  1) d[i][0] = 현재까지 0잔 연속일 때(i번째 안 마심)
 *     d[i][0] = max(d[i-1][0], d[i-1][1], d[i-1][2])
 *  2) d[i][1] = 현재까지 1잔 연속일 때(i번째 마심)
 *     -> d[i][1] = max(d[i-2][0], d[i-2][1], d[i-2][2]) + a[i]
 *  3) d[i][2] = 현재까지 2잔 연속일 때(i-1, i번째 마심)
 *     -> d[i][2] = d[i-1][1] + a[i]
 *
 * 3. 초기값
 *  d[1][1] = a[1]
 *  d[1][2] = 0
 *  d[2][1] = a[2]
 *  d[2][2] = a[1] + a[2]
 *
 *  4. 답
 *   max(d[N][0], d[N][1], d[N][2])
 *
 *  시간복잡도: O(N)
 *  공간복잡도: O(N)
 */