package s15;

import java.io.*;
import java.util.*;

public class S14501V1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] t = new int[N + 1]; // 상담 기간
        int[] p = new int[N + 1]; // 상담 금액
        int[] d = new int[N + 1]; // i번째 날부터 얻을 수 있는 최대 수익

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (i + t[i] - 1 <= N) { // 상담 가능할 경우
                d[i] = Math.max(d[i + t[i]] + p[i], d[i + 1]);
            } else {
                d[i] = d[i + 1]; // 상담 불가능하면 다음 날 이익 그대로
            }
        }

        System.out.println(d[1]);
    }
}

/**
 * 1. dp 테이블 정의
 *    d[i] = i번째 날부터 퇴사일까지 얻을 수 있는 최대 수익
 *
 * 2. 점화식
 *    if) i번째 상담을 할 수 있을 경우 (i + t[i] - 1) ≤ n  i번째 상담이 끝나는 날 ≤ 마지막 근무일
 *        -> i번째 상담을 함(오늘 상담의 수익 + 이번 상담 끝난 후 부터의 수익) p[i] + d[i + t[i]]
 *           or 안하고 다음날부터의 수익을 상속 d[i + 1]
 *        ->  d[i] = max(p[i] + d[i + t[i]], d[i + 1])
 *    else) 상담을 할 수 없을 경우
 *        -> d[i] = d[i + 1] 다음날 부터의 수익을 상속
 *
 *    점화식이 미래값을 참조하므로 반복문도 역순으로 돌려야 함
 *    -> 뒤에서부터 계산 dp (for (i = n; i >= 1; i--))
 *
 * 3. 초기값
 *    d[n+1] = 0 (퇴사 이후는 수익 없음)
 *    마찬가지로 점화식이 미래값을 참조하므로 최외각의 미래부터 초기값 차단
 *
 * 시간복잡도: O(N)
 * 공간복잡도: O(N)
 *
 * d[i]는 “i일부터 시작했을 때 얻을 수 있는 최대 이익”
 * max((오늘 일을 할 수 있으면 오늘 상담 + 끝난 다음날 부터의 이익) vs 오늘 안 하고 넘김)
 */