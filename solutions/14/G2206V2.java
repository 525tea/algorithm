import java.io.*;
import java.util.*;

public class G2206V2 {
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

                /**
                 * nxt가 빈 칸
                 * - b(부순지 안부순지의 여부) 갖고 그대로 이동
                 *
                 * nxt가 벽
                 * - b = 0(부순적 x)일 때만 이동
                 */
                if (map[nx][ny] == 0) { // 빈 칸
                    if (dist[nx][ny][b] != -1) continue; // 같은 상태의 방문 체크
                    dist[nx][ny][b] = dist[x][y][b] + 1;
                    q.offer(new int[]{nx, ny, b});
                } else if (map[nx][ny] == 1 && b == 0) { // 벽이고 아직 안 부쉈을 때만 부수기 가능
                    if (dist[nx][ny][1] != -1) continue; // 상태 변경시의 방문 체크 b=0 -> b=1
                    dist[nx][ny][1] = dist[x][y][b] + 1;
                    q.offer(new int[]{nx, ny, 1});
                }
            }
        }
        return -1; // 도달 실패
    }
}
