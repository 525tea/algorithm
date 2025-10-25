package s15;

import java.io.*;

public class G12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] d = new int[n + 1];      // 최소 연산 횟수 저장
        int[] pre = new int[n + 1];    // 이전 값 저장 (경로 추적용)

        d[1] = 0; // 초기값 정의

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;   // 1 빼기 (디폴트)
            pre[i] = i - 1;

            if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
                d[i] = d[i / 2] + 1;
                pre[i] = i / 2;
            }

            if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
                d[i] = d[i / 3] + 1;
                pre[i] = i / 3;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d[n]).append('\n');

        int cur = n;
        while (true) {
            sb.append(cur).append(' ');
            if (cur == 1) break;
            cur = pre[cur];
        }

        System.out.println(sb);
    }
}