import java.io.*;
import java.util.*;

public class S2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int max = 0; // 지역 높이의 최댓값, 0 이상

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); // 지역의 높이
                max = Math.max(max, map[i][j]);
            }
        }

        int answer = 0;

        // BFS
        // h = 비의 높이에 따라 탐색
        for (int h = 0; h <= max; h++) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h && !visited[i][j]) {
                        bfs(i, j, h);
                        cnt++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }

    static void bfs (int sx, int sy, int h) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (map[nx][ny] <= h || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
/**
 * 비의 양: 0(비x) ~ 지역의 높이 중 최댓값
 * -> 이때 비의 양에 따른 안전 지역의 값 -> list에 저장
 * list에서 최댓값 뽑기
 * 그니까 비의 양을 다 달리해서 카운트를 한 다음 그거의 최댓값을 구하는거야?
 */