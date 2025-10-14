package s14;
import java.io.*;
import java.util.*;

public class S1926 {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    cnt++;
                    maxArea = Math.max(maxArea, bfs(i, j));
                }
            }
        }

        System.out.println(cnt);
        System.out.println(maxArea);
    }

    static int bfs(int x, int y) { // 시작점 x, y
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        int area = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny] || board[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                area++;
            }
        }
        return area;
    }
}
/**
 * 모든 칸에 대해서 BFS하면서 한 시작점에 대해 탐색이 종료될 때 그림개수 cnt++
 * 한 시작점에 대해 탐색을 하면서 max 저장
 * 모든 점에 대해서 돌림
 */