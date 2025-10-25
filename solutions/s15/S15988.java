package s15;

import java.io.*;

public class S15988 {
    static final int MOD = 1_000_000_009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] d = new long[1_000_001];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) {
            d[i] = (d[i - 1] + d[i - 2] + d[i - 3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(d[num]).append("\n");
        }
        System.out.println(sb);
    }
}

/**
 * 1. dp
 * d[i] = i를 만드는 방법의 수
 *
 * 2. 점화식
 * 1 = 1
 * d[1] -> 1
 *
 * 2 = 1 + 1
 *   = 2
 * d[2] -> 2
 *
 * 3 = 1 + 1 + 1
 *   = 1 + 2
 *   = 2 + 1
 *   = 3
 * d[3] -> 4
 *
 * 4 = 1 + 1 + 1 + 1
 *      = 1 + 1 + 2
 *      = 1 + 2 + 1
 *      = 2 + 1 + 1
 *      = 2 + 2
 *      = 1 + 3
 *      = 3 + 1
 * d[4] ->  7
 *
 * 5 = 1 + 1 + 1 + 1 + 1
 *   = 1 + 1 + 1 + 2
 *   = 1 + 1 + 2 + 1
 *   = 1 + 2 + 1 + 1
 *   = 2 + 1 + 1 + 1
 *   = 1 + 2 + 2
 *   = 2 + 1 + 2
 *   = 2 + 2 + 1
 *   = 1 + 1 + 3
 *   = 1 + 3 + 1
 *   = 3 + 1 + 1
 *   = 2 + 3
 *   = 3 + 2
 * d[5] -> 13
 *
 * d[i] = d[i-1] + d[i-2] + d[i-3]
 *
 * 3. 초기값
 * d[1] = 1
 * d[2] = 2
 * d[3] = 4
 */