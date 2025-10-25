package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] R = new int[N + 1];
        int[] G = new int[N + 1];
        int[] B = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            R[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[N + 1][3]; // d[i][0], d[i][1], d[i][2]
        d[1][0] = R[1];
        d[1][1] = G[1];
        d[1][2] = B[1];
        for (int i = 1; i <= N; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + R[i]; // i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 빨강
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + G[i]; // i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 초록
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + B[i]; // i번째 집까지 칠할 때 비용의 최솟값, i번째 집은 파랑
        }

        System.out.println(Math.min(d[N][0], Math.min(d[N][1], d[N][2])));
    }
}
