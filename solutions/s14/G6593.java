package s14;
import java.io.*;
import java.util.*;

public class G6593 {
    static int L, R, C;
    static int sx, sy, sz;
    static int tx, ty, tz;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static char[][][] map;
    static int[][][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // 층
            R = Integer.parseInt(st.nextToken()); // 행
            C = Integer.parseInt(st.nextToken()); // 열

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            dist = new int[L][R][C];

            for (int z = 0; z < L; z++) {
                for (int x = 0; x < R; x++) {
                    String line = br.readLine();
                    for (int y = 0; y < C; y++) {
                        map[z][x][y] = line.charAt(y);
                        dist[z][x][y] = -1;

                        if (map[z][x][y] == 'S') {
                            sz = z; sx = x; sy = y;
                        }
                        if (map[z][x][y] == 'E') {
                            tz = z; tx = x; ty = y;
                        }
                    }
                }
                br.readLine(); // 층 사이 빈 줄
            }

            int res = bfs();
            sb.append(res == -1
                    ? "Trapped!"
                    : "Escaped in " + res + " minute(s)."
            ).append('\n');
        }

        System.out.print(sb);
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        dist[sz][sx][sy] = 0;
        q.offer(new int[]{sz, sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int z = cur[0], x = cur[1], y = cur[2];

            if (z == tz && x == tx && y == ty) return dist[z][x][y];

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d], nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L) continue;
                if (map[nz][nx][ny] == '#' || dist[nz][nx][ny] != -1) continue;

                dist[nz][nx][ny] = dist[z][x][y] + 1;
                q.offer(new int[]{nz, nx, ny});
            }
        }

        return -1; // 탈출 실패
    }
}
