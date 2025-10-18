package s15;

import java.io.*;

public class S11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 10007;

        int[] d = new int[N + 1];
        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i <= N; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % mod;
        }

        System.out.println(d[N]);
    }
}

/**
 * 1. dp 테이블 정의
 * d[i] = 2 x i 테이블을 채우는 방법의 수
 *
 * 2. 점화식
 * d[i] = d[i-1] + d[i-2] * 2
 * 2 * (i-1) 직사각형의 맨끝에 2*1 1개를 붙이는 경우 -> d[i-1] * 1
 * 2 * (i-2) 직사각형의 맨끝에 2*2 1개 또는 2*1 2개를 붙이는 경우 -> d[i-2] * 2
 *
 * 3. 초기값 정의
 * d[1] = 1 / 1*2
 * d[2] = 3 / 2*1*2, 1*2*2, 2*2*1
 */