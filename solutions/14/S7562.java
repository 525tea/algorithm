import java.io.*;
import java.util.*;

public class S7562V2 {
    static int[][] dist;
    static int n;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            dist = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1);

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tx = Integer.parseInt(st.nextToken());
            int ty = Integer.parseInt(st.nextToken());

            sb.append(bfs(sx, sy, tx, ty)).append('\n');
        }

        System.out.println(sb);
    }

    static int bfs (int sx, int sy, int tx, int ty) {
        Queue<int[]> q = new ArrayDeque<>();
        dist[sx][sy] = 0;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == tx && y == ty) return dist[x][y]; // 탈출 조건

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
        return -1; // 도달 불가 (이 문제에서는 사실상 나오지 않음)
    }
}