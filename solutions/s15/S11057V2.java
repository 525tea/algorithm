package s15;

import java.io.*;

public class S11057V2 {
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][10];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1; // 모든 자리에서 0으로 끝나는 수는 항상 1가지 (000...0)
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % MOD;
            }
        }

        int ans = 0;
        for (int j = 0; j < 10; j++) {
            ans = (ans + dp[n][j]) % MOD;
        }

        System.out.println(ans);
    }
}

/**
 *
 * 1. DP 정의
 *    dp[i][j] = i자리 오르막 수 중 마지막 숫자가 j인 경우의 수
 *
 * 2. 점화식
 *    현재 자리가 j일 때,
 *    이전 자리는 0 ~ j 중 하나 가능
 *    → d[i][j] = d[i][j-1] + d[i-1][j]
 *
 *    d[i][j-1] = d[i-1][0] + d[i-1][1] + ... + d[i-1][j-1] : j보다 작은 숫자로 끝나는 오르막 수의 누적합
 *    dp[i-1][j] : 이전 자리에서도 j로 끝난 경우
 *
 *    V1이랑 같은 논리인데 누적합을 재활용한 것
 *
 * 3. 초기값
 *    dp[i][0] = 1 (모든 자리에서 숫자 0만 반복되는 수는 1가지)
 */