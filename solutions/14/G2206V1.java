import java.io.*;
import java.util.*;

public class G2206V1 {
    static int N, M;
    static int[][] map; // [1~N][1~M]
    static int[][][] dist; // dist[x][y][b] b->boolean(0 = 안 부숨, 1 = 부숨) b 상태로 도달했을 때의 최단거리
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
                Arrays.fill(dist[i][j], -1);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        dist[0][0][0] = 1; // 시작점은 '0', 안 부숨(b = 0)
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], b = cur[2];

            if (x == N - 1 && y == M - 1) return dist[x][y][b]; // 탈출 조건

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (dist[nx][ny][b] != -1) continue; // 같은 상태의 방문 체크

                /**
                 * 현재 정점의 관점
                 * cur가 x,y,0(안부숨)
                 * - nxt가 '0'(빈 칸) -> nx, ny, 0(안부숨)
                 * - nxt가 '1'(벽) -> nx, ny, 1(부숨)
                 * cur가 x, y, 1(부숨)
                 * - nxt가 '0'(빈 칸) -> nx, ny, 0(안부숨)
                 * - nxt가 '1'(벽) -> 진입 불가
                 */
                // 현재 정점이 부순 적 없는 세계
                if (b == 0) {
                    if (map[nx][ny] == 0) { // nxt가 빈 칸
                        dist[nx][ny][0] = dist[x][y][0] + 1;
                        q.offer(new int[]{nx, ny, 0});
                    } else if (map[nx][ny] == 1) { // nxt가 벽 -> 부수고 이동
                        if (dist[nx][ny][1] != -1) continue; // 다른 상태의 방문 체크
                        dist[nx][ny][1] = dist[x][y][0] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                }

                // 현재 정점이 부순 적 있는 세계
                else if (b == 1) {
                    if (map[nx][ny] == 0) {
                        dist[nx][ny][1] = dist[x][y][1] + 1;
                        q.offer(new int[]{nx, ny, 1});
                    }
                }

            }
        }
        return -1; // 도달 실패
    }
}
