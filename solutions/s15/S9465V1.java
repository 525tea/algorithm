package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S9465V1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][N + 1]; // [위/아래][열] 열은 1-indexed
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] d = new int[N + 1][3];
            d[1][0] = 0;
            d[1][1] = arr[0][1];
            d[1][2] = arr[1][1];

            for (int i = 2; i <= N; i++) {
                d[i][0] = Math.max(Math.max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
                d[i][1] = Math.max(d[i - 1][0], d[i - 1][2]) + arr[0][i];
                d[i][2] = Math.max(d[i - 1][0], d[i - 1][1]) + arr[1][i];
            }

            sb.append(Math.max(Math.max(d[N][0], d[N][1]), d[N][2])).append('\n');
        }

        System.out.println(sb);
    }
}

/**
 * 부분을 무엇으로 정의하고 dp를 채워나갈까? Z 순서?(X. 복잡함) => 왼->오 열 단위로 확장(O)
 * "열" 단위의 상태 전이. 전이의 단위 i -> 열
 *
 * 1. dp
 * d[i][0] = i번째 열까지 고려, 아무것도 안 뗀 경우
 * d[i][1] = i번째 열에서 위 스티커를 뗀 경우
 * d[i][2] = i번째 열에서 아래 스티커를 뗀 경우
 *
 * 2. 점화식
 * d[i][0] = max(d[i-1][0], d[i-1][1], d[i-1][2])
 * d[i][1] = max(d[i-1][0], d[i-1][2]) + arr[0][i] : max(이전 열에서 안 뗐거나 or 아래 스티커를 뗐을 경우) + 위쪽, 현재 열의 스티커 점수
 * d[i][2] = max(d[i-1][0], d[i-1][1]) + arr[1][i] : max(이전 열에서 안 뗐거나 or 위 스티커를 뗐을 경우) + 아래쪽, 현재 열의 스티커 점수
 *
 * 3. 초기값
 * d[1][0] = 0
 * d[1][1] = arr[0][1]
 * d[1][2] = arr[1][1]
 *
 * 4. 결과
 * max(d[N][0], d[N][1], d[N][2])
 */