package s15;

import java.io.*;

public class S2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int fix_cnt = Integer.parseInt(br.readLine());

        long[] d = new long[41];
        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= N; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        long ans = 1;
        int prev = 0;
        for (int i = 0; i < fix_cnt; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= d[temp - prev - 1];
            prev = temp;
        }
        ans *= d[N - prev];

        System.out.println(ans);
    }
}

/**
 * 고정석으로 잘린 부분(이동 허용)의 크기를 기준으로 dp 잡기
 * 3, 2, 2 -> d[3] * d[2] * d[2]
 *
 * 1. dp
 * d[i] = 이동 가능 범위가 i일 때 가능한 배치 방법 수
 *
 * 2. 점화식
 * d[1] = 1
 * d[2] = 2
 * d[3] = 3
 * d[4] = 5
 * d[5] = 8
 *
 * d[i] = d[i-1] + d[i-2]
 *
 * 3. 초기값
 * d[1] = 1
 * d[2] = 2
 */