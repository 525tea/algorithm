package s15;

import java.io.*;

public class S9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] d = new int[11];
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        for (int i = 4; i <= 10; i++) {
            d[i] = d[i-1] + d[i - 2] + d[i - 3];
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
 * dp 배열로 값을 모두 구해놓고 테스트 케이스의 입력값에 따라 꺼내주기(매번 계산x)
 */