package s15;

import java.io.*;

public class S1788 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int abs = Math.abs(N);

        int[] fibo = new int[abs + 2]; // 초기값 0, 1 자리 안배
        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= abs; i++) { // 양수의 피보나치 저장
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % MOD;
        }

        int sign; // 부호
        if (N == 0) sign = 0;
        else if (N > 0) sign = 1;
        else {
            sign = (abs % 2 == 0) ? -1 : 1;
        }
        System.out.println(sign);
        System.out.println(fibo[abs]);
    }
}

/**
 * 피보나치의 음수 대칭
 *
 * 1. dp
 * fibo[i] = fibo[i-1] + fibo[i-2]
 *
 * f(1) = 1
 * f(2) = 1
 * f(3) = 2
 * f(4) = 3
 *
 * f(-1) = 1
 * f(-2) = -1 짝수일 때 부호 음수
 * f(-3) = 2
 * f(-4) = -3
 */