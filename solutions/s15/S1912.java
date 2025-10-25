package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N + 1]; // 1-indexed
        d[1] = num[1];
        int max = d[1];
        for (int i = 2; i <= N; i++) {
            d[i] = Math.max((d[i-1] + num[i]), num[i]);
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }
}

/**
 * 건너뛰기 없는 연속합
 *
 * 1. dp 테이블
 * d[i] = i번째 수까지 중 최대 연속합
 * 즉, i번째 수까지 고려한(합하기/새로 시작) 연속합의 최댓값
 * i번째 수는 반드시 포함돼야 함
 *
 * 2. 점화식
 * d[i] = Math.max(d[i-1] + num[i], num[i])
 * 즉, 이전의 최댓값 + 현재값 vs 현재값
 *
 * 3. 초기값
 * d[1] = num[1]
 */