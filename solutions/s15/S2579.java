package s15;

import java.io.*;

public class S2579 { // 2차원 dp 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] score = new int[N+1]; // 0-indexed 주의
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        // N == 1 예외 처리
        if (N == 1) {
            System.out.println(score[1]);
            return;
        }

        int[][] d = new int[N+1][3]; // D[k][1], D[k][2], 0-indexed 주의
        d[1][1] = score[1]; // 초기값 정의
        d[1][2] = 0;
        d[2][1] = score[2];
        d[2][2] = score[1] + score[2];

        for (int i = 3; i <= N; i++) {
            d[i][1] = Math.max(d[i-2][1], d[i-2][2]) + score[i];
            d[i][2] = d[i-1][1] + score[i];
        }

        System.out.println(Math.max(d[N][1], d[N][2]));
    }
}
