package s15;

import java.io.*;

public class S10844 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][10];

        // 초기값: 길이 1에서 0은 시작 불가
        d[1][0] = 0;
        for (int j = 1; j <= 9; j++) d[1][j] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) d[i][j] = d[i - 1][1];
                else if (j == 9) d[i][j] = d[i - 1][8];
                else d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]);

                d[i][j] = d[i][j] % MOD;
            }
        }

        long ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans = (ans + d[N][j]) % MOD;
        }
        System.out.println(ans);
    }
}

/**
 * 1. dp
 * d[i][j] = i자리에 j가 들어가는 경우의 수. i는 수의 마지막 자리, j는 0~9
 *
 * 2. 점화식
 * j = 0 -> d[i][j] = d[i-1][1]
 * j = 9 -> d[i][j] = d[i-1][8]
 * j = 1 ~ 8 -> d[i][j] = d[i-1][j-1] + d[i-1][j+1]
 *
 * 3. 초기값
 * d[1][0] = 0
 * d[1][1~9] = 1
 */