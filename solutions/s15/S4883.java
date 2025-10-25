package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S4883 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = 1; // 테스트 케이스 번호

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] d = new int[N][3];
            // 초기값
            d[0][0] = INF; // 접근 불가. 시작점이 arr[0][1]
            d[0][1] = arr[0][1];
            d[0][2] = arr[0][1] + arr[0][2];

            for (int i = 1; i < N; i++) {
                d[i][0] = arr[i][0] + Math.min(d[i - 1][0], d[i - 1][1]);
                d[i][1] = arr[i][1] + Math.min(
                        Math.min(d[i - 1][0], d[i - 1][1]),
                        Math.min(d[i - 1][2], d[i][0])
                );
                d[i][2] = arr[i][2] + Math.min(
                        Math.min(d[i - 1][1], d[i - 1][2]),
                        d[i][1]
                );
            }
            sb.append(tc++).append(". ").append(d[N - 1][1]).append("\n");
        }

        System.out.print(sb);
    }
}

/**
 * 1. dp 정의
 *    dp[i][j] = (i,j)에 도착했을 때 최소 누적 비용
 *
 * 2. 점화식
 *    dp[i][0] = arr[i][0] + min(dp[i-1][0], dp[i-1][1])
 *    dp[i][1] = arr[i][1] + min(dp[i-1][0], dp[i-1][1], dp[i-1][2], dp[i][0])
 *    dp[i][2] = arr[i][2] + min(dp[i-1][1], dp[i-1][2], dp[i][1])
 *
 * 3. 초기값
 *    dp[0][0] = INF
 *    dp[0][1] = arr[0][1]
 *    dp[0][2] = arr[0][1] + arr[0][2]
 */