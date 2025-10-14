package s14;
import java.io.*;
import java.util.*;

public class G7576V1 {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0,};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행

        map = new int[N][M];
        dist = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) { // 1 -> 시작점
                    q.offer(new int[]{i, j}); // 시작점 모두 큐에 넣기
                    dist[i][j] = 0; // 시작점은 0일차로 초기화
                } else {
                    dist[i][j] = -1; // 미방문으로 초기화
                }
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 범위 체크
                if (map[nx][ny] != 0 || dist[nx][ny] != - 1) continue; // 0(전파 x), 미방문만 탐색

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }

        // 결과 출력
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && dist[i][j] == - 1) { // 0(전파 x) && 미방문 -> -1
                    System.out.println(-1);
                    return;
                }

                ans = Math.max(ans, dist[i][j]); // 최소(처음부터 다 익었던 상태) = 0 or dist의 최댓값
            }
        }
        System.out.println(ans);
    }
}
