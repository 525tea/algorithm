package s15;

import java.io.*;

public class S2193V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] d = new long[91][2]; // [i][0] = 0으로 끝나는 i자리 이친수, [i][1] = 1로 끝나는 i자리 이친수

        // 1. 초기값 정의
        d[1][1] = 1;

        // 2. 점화식 적용
        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][0] + d[i - 1][1]; // i번째가 0이면, i-1번째는 0 또는 1 모두 가능
            d[i][1] = d[i - 1][0];               // i번째가 1이면, i-1번째는 반드시 0
        }

        // 3. 결과 출력
        System.out.println(d[n][0] + d[n][1]);
    }
}

/**
 * 1. dp 테이블
 *    d[i][k] = i자리 이친수 중 마지막 자리가 k(0 또는 1)인 이친수의 개수
 *
 * 2. 점화식
 *    - 맨끝자리(i번째)가 0이면, i-1번째는 0 또는 1 모두 가능 → d[i][0] = d[i-1][0] + d[i-1][1]
 *    - 맨끝자리(i번째)가 1이면, i-1번째는 0으로 끝나는 것만 가능 → d[i][1] = d[i-1][0]
 *
 * 3. 초기값
 *    - d[1][0] = 0 (1자리 이친수는 1뿐 -> 0으로 끝나는 건 없음)
 *    - d[1][1] = 1 (1)
 *
 * 시간복잡도: O(N) (N ≤ 90 → 사실상 O(1))
 * 공간복잡도: O(N)
 */