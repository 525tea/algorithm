import java.io.*;
import java.util.*;

public class G4179 {
    static int R, C; // R행 C열
    static char[][] map;
    static int[][] fire;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static final int INF = (int) 1e9; // 불 방문 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fire = new int[R][C];
        dist = new int[R][C];

        ArrayDeque<int[]> fireQ = new ArrayDeque<>();
        ArrayDeque<int[]> jihoonQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = line.charAt(j);
                map[i][j] = ch;
                fire[i][j] = INF;   // 불 초기화(기본: 불 아님)
                dist[i][j] = -1;    // 지훈 미방문

                if (ch == 'F') {
                    fire[i][j] = 0; // 불 시작점
                    fireQ.offer(new int[]{i, j});
                }
                if (ch == 'J') { // 지훈 시작점
                    dist[i][j] = 0;
                    jihoonQ.offer(new int[]{i, j});
                }
            }
        }

        // 불 BFS
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#') continue;
                if (fire[nx][ny] != INF) continue; // 이미 불 방문

                fire[nx][ny] = fire[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }

        // 지훈 BFS
        while (!jihoonQ.isEmpty()) {
            int[] cur = jihoonQ.poll();
            int x = cur[0], y = cur[1];

            // 탈출 조건: 가장자리에서 한 칸 더 나가면 됨
            if (x == 0 || y == 0 || x == R-1 || y == C-1) {
                System.out.println(dist[x][y] + 1);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#') continue; // 벽
                if (dist[nx][ny] != -1) continue; // 이미 방문

                // 불보다 먼저 도착해야 이동 가능
                if (dist[x][y] + 1 >= fire[nx][ny]) continue; // 늦거나 동시 도착

                dist[nx][ny] = dist[x][y] + 1;
                jihoonQ.offer(new int[]{nx, ny});
            }
        }

        // 탈출 못 함
        System.out.println("IMPOSSIBLE");
    }
}
/**
 * 불의 전파 시간을 BFS로 계산
 * 지훈이 BFS 돌리면서 불의 속도보다 늦으면 못 가는거
 *
 * 불 -> 여러 시작점 BFS(멀티소스 BFS)
 * 지훈 -> 시작점 하나에서 시작, 불의 속도 배열로 조건 체크
 */