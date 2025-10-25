package s15;

import java.io.*;
import java.util.*;

public class G1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 목표 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시 수

        int[] cost = new int[N];
        int[] customer = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        int MAX = C + 100; // 여유분 (초과 유치 가능)
        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = customer[i]; j <= MAX; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer[i]] + cost[i]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int j = C; j <= MAX; j++) {
            ans = Math.min(ans, dp[j]);
        }

        System.out.println(ans);
    }
}

/**
 * “최대 가치”가 아닌 “최소 비용”을 구하는 역Knapsack
 *
 * 1. DP 정의
 *    dp[j] = j명의 고객을 확보하기 위한 최소 비용
 *
 * 2. 점화식
 *    dp[j] = min(dp[j], dp[j - customer[i]] + cost[i])
 *
 *    → i번째 도시를 추가로 선택했을 때 최소비용 갱신
 *
 * 3. 초기값
 *    dp[0] = 0
 *    dp[1..C+100] = INF
 *
 * 4. 결과
 *    min(dp[C], dp[C+1], ..., dp[C+100])
 */