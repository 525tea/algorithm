package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S11052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N + 1];
        int[] p = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) { // dp 배열
            for (int j = 1; j <= i; j++) { // 마지막에 선택할 부분의 크기 (Knapsack)
                d[i] = Math.max(d[i], d[i-j] + p[j]);
            }
        }

        System.out.println(d[N]);
    }
}

/**
 * Knapsack
 *
 * 카드 i개를 살 때의 최대 금액
 * -> i개를 이루는 마지막 분할 부분의 크기 j를 기준으로 나눈다
 * -> (i-j)를 산 상태 + j개짜리를 선택
 *
 * 1. dp
 * d[i] = i개를 샀을 때의 최대 금액
 * p[k] = 카드 k개의 값 (k = 1 ~ N)
 *
 * 2. 점화식
 * N = 4
 * 3 + 1 -> d[3] + p[1]
 * 2 + 2 -> d[2] + p[2]
 * 1 + 3 -> d[1] + p[3]
 * 0 + 4 -> d[0] + p[4]
 * d[4] = max((d[3] + p[1]), (d[2] + p[2]), (d[1] + p[3]), (d[0] + p[4]))
 *
 * => d[i] = max(d[i-j] + p[j]) (1 <= j <= i) 반복문 돌리기
 *
 * 3. 초기값
 * d[0] = 0
 */