package s15;

import java.io.*;

public class S11057V1 {
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][10]; // 수의 자리 1 ~ N, 각 자리에 올 수 있는 수 0 ~ 9

        // 초기값
        for (int i = 0; i <= 9; i++) { // 수는 0으로 시작 가능
            d[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= j; k++) {
                    d[i][j] += (d[i - 1][k]) % MOD;
                }
            }
        }

        int ans = 0;
        for (int val : d[N]) { // ans = d[N][0] + d[N][1] + ... + d[N][9]
            ans = (ans + val) % MOD;
        }
        System.out.println(ans);
    }
}

/**
 * 현재 자리수 -> i (1 ~ N)
 * 현재 자리의 숫자 -> j (0 ~ 9)
 * 오르막수 조건 -> "이전 자리의 숫자 <= 현재 자리의 숫자"
 *
 * 상태 전이의 단위 : 자리수 -> 현재 자리
 * 상태 전이에 필요한 요소 : 이전 자리의 숫자
 *
 * 1. dp
 * d[i][j] = 현재 자리가 i번째 자리, 현재 자리의 숫자가 j일 때의 오르막수 개수
 * i 자리 오르막 수 중 마지막 숫자가 j인 경우의 수
 *
 * 2. 점화식
 * d[i][j] = d[i-1][0] + d[i-1][1] + ... + d[i-1][j]
 * 이전 자리의 오르막수의 마지막 자리 + 1
 *
 *
 * 3. 초기값
 * d[1][0] = 1
 * d[1][1] = 1
 * ...
 * d[1][9] = 1
 */