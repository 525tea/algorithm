package s15;

import java.io.*;

public class S11057V3 { // 중복 조합
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] comb = new int[n + 10][10]; // C(n+9, 9)까지 구함

        // 기본 조합 초기화
        for (int i = 1; i <= 9; i++) {
            comb[i][i] = 1; // C(i, i) = 1
        }

        for (int i = 1; i <= n + 9; i++) {
            comb[i][0] = 1; // C(i, 0) = 1
            for (int j = 1; j < Math.min(i, 10); j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        System.out.println(comb[n + 9][9]);
    }
}

/**
 * 조합론 풀이
 *    오르막 수는 "0~9 사이의 숫자 중 중복을 허용하여 N개를 비내림차순으로 선택하는 경우"와 동일하다.
 *    → 즉, '중복조합(H)' 문제로 변환된다.
 *      H(10, N) = C(N + 10 - 1, 10 - 1) = C(N + 9, 9)
 *
 * 1. DP 정의 (조합 테이블)
 *    comb[i][j] = i개 중 j개를 선택하는 조합 (C(i, j))
 *
 * 2. 점화식
 *    comb[i][j] = comb[i-1][j-1] + comb[i-1][j]
 *      (파스칼의 삼각형 성질)
 *
 * 3. 초기값
 *    comb[i][0] = 1
 *    comb[i][i] = 1
 */