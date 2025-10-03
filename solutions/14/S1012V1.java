import java.io.*;
import java.util.*;

public class S1012V1 { // BFS 버전
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 열
            N = Integer.parseInt(st.nextToken()); // 행
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs (int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nx][ny] != 1 || visited[nx][ny] ) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
