package s14;
import java.io.*;
import java.util.*;

public class G10026 {
    static int N;
    static char[][] mapNorm;
    static char[][] mapRGB;
    static boolean[][] visited_norm;
    static boolean[][] visited_RGB;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        mapNorm = new char[N][N];
        mapRGB = new char[N][N];

        visited_norm = new boolean[N][N];
        visited_RGB = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                mapNorm[i][j] = ch;
                mapRGB[i][j] = (ch == 'G') ? 'R' : ch; // 적록색약 변환
            }
        }

        int cnt_norm = 0;
        int cnt_RGB = 0;

        // BFS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited_norm[i][j]) {
                    visited_norm[i][j] = true;
                    bfs(i, j, mapNorm, visited_norm);
                    cnt_norm++;
                }
                if (!visited_RGB[i][j]) {
                    visited_RGB[i][j] = true;
                    bfs(i, j, mapRGB, visited_RGB);
                    cnt_RGB++;
                }
            }
        }

        System.out.println(cnt_norm + " " + cnt_RGB);
    }

    static void bfs (int sx, int sy, char[][] map, boolean[][] visited) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir], ny = y + dy[dir];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == map[x][y]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

    }
}
/**
 * 일반, 적록색맹에 따라 BFS 룰이 다름
 *
 * 방법
 * 1) BFS를 각각 정의
 * 2) BFS를 공용으로 쓰되, 플래그를 인자로 넘겨서 서로 다른 흐름 타게 함
 * 3) BFS 메서드가 아니라, 일반과 적록색맹의 맵을 다르게 저장 -> 이걸로 구현해보겠음
 */