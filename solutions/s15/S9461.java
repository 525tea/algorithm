package s15;

import java.io.*;

public class S9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] d = new long[101];
        d[1] = d[2] = d[3] = 1;
        for (int i = 4; i <= 100; i++) {
            d[i] = d[i - 2] + d[i - 3];
        }
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(d[N]).append("\n");
        }
        System.out.println(sb);
    }
}

/**
 * P[N] = 파도반 수열의 N번째 숫자
 * 1 1 1 2 2 3 4 5 7 9 12
 *
 * d[i] = d[i-2] + d[i-3]
 *
 * 초기값
 * d[1] = d[2] = d[3] = 1
 */