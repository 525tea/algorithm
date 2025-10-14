package s14;
import java.io.*;
import java.util.*;

public class S2178 {
    static int n, m;
    static int[][] board;
    static int[][] dist;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) Arrays.fill(dist[i], -1); // dist -1로 초기화 (아직 방문 X)

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(dist[n-1][m-1]);
    }

    static void bfs(int sx, int sy) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        dist[sx][sy] = 1; // 시작점 거리 = 1

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (board[nx][ny] == 0) continue; // 진입 불가
                if (dist[nx][ny] != -1) continue; // 이미 방문

                dist[nx][ny] = dist[x][y] + 1;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
/**
 * 시작점은 하나, 도착점도 하나
 * 시작점에서 시작해서 탐색점 넣고, 상하좌우 넣으며
 * offer할 때 거리 1씩 증가
 */