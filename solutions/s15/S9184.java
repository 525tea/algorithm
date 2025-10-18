package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S9184 {
    static int[][][] d = new int[21][21][21]; // 0 이하와 20 초과는 동값처리 -> 0 ~ 20

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
              .append(") = ").append(w(a, b, c)).append('\n');
        }
        System.out.println(sb);
    }

    static int w (int a, int b, int c) {
        // 범위 밖
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20 ){
            return w(20, 20, 20);
        }

        // 범위 내 -> dp 반환
        if(d[a][b][c] != 0){
            return d[a][b][c];
        }

        // 재귀
        if (a < b && b < c) {
            return d[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            return d[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

    }
}
