package s15;

import java.io.*;
import java.util.*;

public class S11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N + 1];
        int[] d = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            d[i] = num[i]; // 초기화 - 자기 자신만 포함한 부분 수열
        }

        int ans = d[1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (num[j] < num[i]) {
                    d[i] = Math.max(d[i], d[j] + num[i]);
                }
            }
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
    }
}

/**
 * LIS : 최장 증가 부분 수열
 *
 * 1. dp 테이블
 * d[i] = num[i]를 마지막 원소로 갖는 LIS의 원소 합
 *
 * 2. 점화식
 * 이전 원소 j가 i보다 앞에 있고(j < i), 증가 조건을 만족할 때(num[j] < num[i])
 * -> 앞 원소 j의 LIS에 현재 원소를 붙일 수 있음
 * -> d[i] = max(d[i], d[j] + num[i])
 *
 * 이때, i에 가장 가까운 j가 아니라, 모든 유효한 j(j < i && num[j] < num[i]) 중 d[j]가 최대인 것을 선택한다
 * ex. 1 4 2 30(i) 의 수열에서 1+2 보다 4가 크므로 i에 마지막 근접한 순서가 아닌 max를 구한다
 *
 * 3. 초기값
 * d[i] = num[i] -> 자기 자신만 선택했을 때
 *
 * 시간복잡도: O(N^2)
 * 공간복잡도: O(N)
 */