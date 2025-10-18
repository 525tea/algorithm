package s15;

import java.io.*;

public class S1904 {
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d = new int[N + 1];
        d[1] = 1;
        d[2] = 2;
        for (int i = 3; i <= N; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % 15746;
        }

        System.out.println(d[N]);
    }
}

/**
 * 1. dp 테이블 정의
 * D[i] = 길이가 i인 이진 수열의 개수
 *
 * 2. 점화식
 * D[4] = 2 + 2 /00 00
 *      = 1 + 1 + 2 /1 1 00
 *      = 1 + 2 + 1 /1 00 1
 *      = 2 + 1 + 1/ 00 1 1
 *      = 1 + 1 + 1 + 1 /1 1 1 1
 *      = D[3] + D[2] = 5
 *
 * D[3] = 1 + 2 /1 00 -> D[3-2]. (3-2) + 2
 *      = 2 + 1 /00 1
 *      = 1 + 1 + 1 /1 1 1 -> D[3-1]. (3-1) + 1
 *      = D[2] + D[1] = 3
 *
 * D[2] = 1 + 1/ 1 1
 *      = 2 /00
 *      = 2
 *
 * D[1] = 1/ 1
 *
 * 3. 초기값 정의
 * D[1] = 1, D[2] = 2
 */