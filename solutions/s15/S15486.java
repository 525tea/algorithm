package s15;

import java.io.*;
import java.util.*;

public class S15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] t = new int[N + 2];
        int[] p = new int[N + 2];
        long[] d = new long[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // 디폴트 - 일에 상담을 하지 않더라도 전날까지의 최대 수익을 이어받음
            d[i] = Math.max(d[i], d[i - 1]);

            // i번째 날 상담을 진행할 수 있을 경우
            if (i + t[i] - 1 <= N) { // 상담이 퇴사일 전 종료될 때
                d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
            }
        }

        System.out.println(Math.max(d[N], d[N + 1])); // 상담이 n일 시작 & n일 종료되는 경우를 오류 보정. d[N+1] = 퇴사날 아침
    }
}

/**
 * 1. dp 테이블 정의
 *    d[i] = i번째 날까지 얻을 수 있는 최대 수익
 *
 * 2. 점화식
 *    - 오늘 상담을 하지 않는 경우
 *      d[i] = max(d[i], d[i-1])
 *    - 오늘 상담을 하는 경우 (i + t[i] ≤ N + 1)
 *      d[i + t[i]] = max(d[i + t[i]], d[i] + p[i])
 *
 * 3. 초기값
 *    d[0] = 0
 *
 * 시간복잡도: O(N)
 * 공간복잡도: O(N)
 *
 * #14501(퇴사1)은 N<=15라서 O(N), O(NlogN)도 가능했지만
 * 이 문제는 N<=1,5000,000이라서 O(N)으로 무조건 내려야 한다
 */