import java.io.*;
import java.util.*;

public class G14442 {
    static int N, M, K;
    static int[][] map;
    static int[][][] dist; // x, y, n -> (x, y) 좌표, 지금까지 n개 부숨. (0 <= n <= K)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][K+1];

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
        dist[0][0][0] = 1;
        q.offer(new int[]{0, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], n = cur[2];

            if (x == N - 1 && y == M - 1) return dist[x][y][n];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0) { // 빈 칸
                    if (dist[nx][ny][n] != -1) continue; // 같은 상태의 방문 체크
                    dist[nx][ny][n] = dist[x][y][n] + 1;
                    q.offer(new int[]{nx, ny, n});
                } else if (map[nx][ny] == 1 && n <= K-1) { // 벽이고 아직 안 부쉈을 때만 부수기 가능
                    if (dist[nx][ny][n+1] != -1) continue; // 상태 변경시의 방문 체크 b=0 -> b=1
                    dist[nx][ny][n+1] = dist[x][y][n] + 1;
                    q.offer(new int[]{nx, ny, n+1});
                }
            }
        }

        return -1;
    }
}

/**
 * nxt가 빈 칸 = 0
 * - b(부순지 안부순지의 여부) 갖고 그대로 이동
 *
 * nxt가 벽 = 1
 * - n <= K-1일 때만 이동
 * - n을 1 증가
 */
