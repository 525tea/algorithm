package s15;

import java.io.*;

public class S1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] fibo = new int[41][2];

        // 초기값 설정
        fibo[0][0] = 1; // fib(0) 호출 시 0 출력 1회
        fibo[0][1] = 0;	// fib(0) 호출 시 1 출력 0회
        fibo[1][0] = 0;	// fib(1) 호출 시 0 출력 0회
        fibo[1][1] = 1; // fib(1) 호출 시 1 출력 1회

        // 점화식
        for (int i = 2; i <= 40; i++) {
            fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
            fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(fibo[N][0]).append(" ").append(fibo[N][1]).append("\n");
        }

        System.out.print(sb);
    }
}

/**
 * 1. dp 테이블 정의
 *    fibo[i][k] = 숫자 i의 피보나치 호출 중 k(0 or 1)가 출력된 횟수
 *
 * 2. 점화식
 *    fibo[i][k] = fibo[i-1][k] + fibo[i-2][k]
 *
 * 3. 초기값
 *    fibo[0][0] = 1, fibo[0][1] = 0;
 *    fibo[1][0] = 1, fibo[1][1] = 1
 *
 * 시간복잡도: O(40) = O(1)
 * 공간복잡도: O(40)
 */