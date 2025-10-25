package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S9465V2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2]; // arr[i][0]=위, arr[i][1]=아래
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[N][2]; // dp[i][0]=i열 위, dp[i][1]=i열 아래

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    int v = 0; // 이전까지의 최대해

                    if (i > 1) {
                        v = Math.max(dp[i - 2][0], dp[i - 2][1]); // i-2열에서 온 경우 (전전 열은 위, 아래 모두 가능)
                    }
                    if (i > 0) {
                        v = Math.max(v, dp[i - 1][1 - j]); // i-1열에서 온 경우 (전 열은 상하가 반대일 때만 가능)
                    }

                    // 이전까지의 최대해 + 현재 열(j행)의 선택
                    dp[i][j] = v + arr[i][j];
                }
            }

            sb.append(Math.max(dp[N - 1][0], dp[N - 1][1])).append("\n");
        }

        System.out.print(sb);
    }
}

/**
 *
 * 1. DP 정의
 *    dp[i][j] = i번째 열까지 고려했을 때, j행(i열)의 스티커를 반드시 선택한 상태일 때의 최대 점수
 *      - j = 0 → 위쪽 스티커
 *      - j = 1 → 아래쪽 스티커
 *
 * 2. 점화식
 *    - (1) i-2열에서 온 경우 (전전 열은 위, 아래의 dp 모두 계승 가능)
 *         v = max(dp[i-2][0], dp[i-2][1])
 *
 *    - (2) i-1열에서 온 경우 (전 열은 상하의 반대쪽 dp만 가능)
 *         v = max(v, dp[i-1][1-j])
 *
 *    - 최종 전이:
 *         dp[i][j] = v + arr[i][j]
 *
 * 3. 초기값
 *    dp[0][0] = arr[0][0]
 *    dp[0][1] = arr[0][1]
 *
 * 4. 결과
 *    max(dp[N-1][0], dp[N-1][1])
 *
 * 5. 복잡도
 *    시간복잡도: O(N)
 *    공간복잡도: O(2N)
 */