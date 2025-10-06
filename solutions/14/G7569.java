import java.io.*;
import java.util.*;

public class G7569V2 {
    static int M, N, H; // z, x, y
    static int[][][] map;
    static int[][][] dist;
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        H = Integer.parseInt(st.nextToken()); // 높이

        map = new int[H][N][M];
        dist = new int[H][N][M];
        Queue<int[]> q = new ArrayDeque<>();
        for (int h = 0; h < H; h++){
            for (int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++){
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) {
                        q.add(new int[]{h, n, m});
                        dist[h][n][m] = 0;
                    } else {
                        dist[h][n][m] = -1;
                    }
                }
            }
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int z = cur[0], x = cur[1], y = cur[2];

            for (int d = 0; d < 6; d++){
                int nz = z + dz[d], nx = x + dx[d], ny = y + dy[d];

                if (nz < 0 || nz >= H || nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (map[nz][nx][ny] != 0 || dist[nz][nx][ny] != -1) continue;

                dist[nz][nx][ny] = dist[z][x][y] + 1;
                q.add(new int[]{nz, nx, ny});
            }
        }

        int ans = 0;

        for (int h = 0; h < H; h++){
            for (int n = 0; n < N; n++){
                for (int m = 0; m < M; m++){
                    if (map[h][n][m] == 0 && dist[h][n][m] == -1) {
                        System.out.println(-1);
                        return;
                    };
                    ans = Math.max(ans, dist[h][n][m]);
                }
            }
        }
        System.out.println(ans);
    }
}
