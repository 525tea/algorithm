package s15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] p = new int[T + 1][3]; // t초(1-indexed)에 나무(1 or 2)에서 떨어지는 자두 개수(0 or 1)
        int[][][] d = new int[T + 1][3][W + 1]; // t초, 나무 1 or 2, 이동 횟수(1-indexed)일 때의 자두수 누적합

        for (int i = 1; i <= T; i++) {
            int plum = Integer.parseInt(br.readLine());
            p[i][plum] = 1;
        }

        //초기값
        d[1][1][0] = p[1][1]; // 1초, 1번 나무에서 시작, 이동 0번
        d[1][2][1] = p[1][2]; // 1초, 2번 나무로 이동, 이동 1번

        for (int t = 2; t <= T; t++) {
            for (int move = 0; move <= W; move++) {
                for (int tree = 1; tree <= 2; tree++) { // 나무
                    // 이동하지 않음 - 디폴트
                    d[t][tree][move] = Math.max(d[t][tree][move], d[t - 1][tree][move] + p[t][tree]);

                    // move가 1 이상일 때
                    if (move > 0)
                        d[t][tree][move] = Math.max(d[t][tree][move], d[t - 1][3 - tree][move - 1] + p[t][tree]); // 디폴트 vs 이동
                }
            }
        }

        int ans = 0;
        for (int move = 0; move <= W; move++) {
            ans = Math.max(ans, Math.max(d[T][1][move], d[T][2][move]));
        }

        System.out.println(ans);
    }
}

/**
 * 자두야.. 마트 가서 사먹어라..
 *
 * 0. 왜 dp인가
 * 매 순간의 위치에 따라(과거, 현재) 후의 상태가 달라짐(미래, 현재)
 *
 * 1. dp
 *  d[i][j][k] = i초일 때, j번째 나무(1 or 2) 밑에 있고, 현재까지 k번 이동했을 때, 최대 누적 자두 수
 *  p[i][j] = i초에 나무 j에서 떨어지는 자두. 0 or 1
 *
 * 2. 점화식
 *  for (int i = 1; i <= T; t++)
 *
 *  1) 이동 안 함 : 저장된 값 vs t-1에서 tree 그대로, move 그대로 전이된 값
 *    -> d[t][tree][move] = max(d[t][tree][move], d[t - 1][tree][move] + p[t][tree])
 *  2) 이동 함 : 저장된 값 vs t-1, 반대 나무, 이동 전에서 전이된 값
 *    -> d[t][tree][move] = max(d[t][tree][move], d[t - 1][3 - tree][move - 1] + p[t][tree])
 *
 * 3. 초기값
 *  d[1][1][0] = p[1][1]; // 1초, 1번 나무에서 시작, 이동 0번
 *  d[1][2][1] = p[1][2]; // 1초, 2번 나무로 이동, 이동 1번
 */