package s15;

import java.io.*;
import java.util.*;

public class S11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N + 1];
        int[] d = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            d[i] = 1; // 초기화 - 자신만 포함
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (num[j] < num[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }

        int max = Arrays.stream(d).max().getAsInt();
        System.out.println(max);
    }
}

/**
 * LIS : 최장 증가 부분 수열
 *
 * 1. dp 테이블
 * d[i] = num[i]를 마지막 원소로 갖는 LIS의 원소 수
 *
 * 2. 점화식
 * 앞쪽의 LIS에 현재 원소를 붙일 수 있을 때 (i < j, num[j] < num[i])
 * d[i] = max(d[i], d[j] + num[i]) -> 1 4 2 30(i) 의 수열에서 1+2 보다 4가 크므로 i에 마지막 근접한 순서가 아닌 max로 친다
 *
 * 3. 초기값
 * d[i] = num[i] 자기 자신만 선택했을 때
 *
 * 시간복잡도: O(N^2)
 * 공간복잡도: O(N)
 */