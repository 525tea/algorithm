import java.io.*;
import java.util.*;

public class G2573 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int years = 0;

        while (true) {
            visited = new boolean[N][M]; // 방문 초기화
            int cnt = 0; // 영역의 개수

            // 연도에 따라 탐색: 매번(매해) map 전체를 돌며 빙산(영역의 개수) 세기
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            // 탈출 조건
            if (cnt >= 2) { // 빙산이 두 덩어리 이상으로 분리됨
                System.out.println(years);
                return;
            }
            if (cnt == 0) { // 다 녹을 때까지 분리되지 않음
                System.out.println(0);
                return;
            }

            // 갱신: 빙산 녹이기
            melt();
            years++;
        }
    }

    static void bfs (int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

    static void melt() {
        int[][] meltAmount = new int[N][M]; // 녹일 할당량

        // 각 칸이 주변 바다 때문에 얼마나 녹는지 기록
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int sea = 0; // 인접 바다 카운트
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d], ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (map[nx][ny] == 0) sea++;
                    }
                    meltAmount[i][j] = sea;
                }
            }
        }

        // 한꺼번에 녹이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = Math.max(0, map[i][j] - meltAmount[i][j]);
            }
        }
    }
}
/**
 * 큰 for
 * -> while (true) {
 * 배열 전체에 대해서,
 * 루프 탈출 조건 : 영역 개수 >= 2가 되는 시점
 *
 * BFS() {
 * cnt++ -> 영역의 개수
 * }
 *
 * years++
 *}
 *
 * static BFS() // 탐색
 *
 * static melt() // 갱신
 */