package s14;
import java.io.*;
import java.util.*;

public class S2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

//        int cnt = 0; // houses의 size()로 대체
        List<Integer> houses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    houses.add(bfs(i, j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Collections.sort(houses);
        sb.append(houses.size()).append("\n");
        for (int cnt : houses) sb.append(cnt).append("\n");
        System.out.println(sb);
    }

    static int bfs (int sx, int sy) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited[sx][sy] = true;
        q.offer(new int[]{sx, sy});

        int cnt = 1; // 첫번째 집(시작점)도 포함

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
                cnt++;
            }
        }

        return cnt;
    }
}
/**
 * 영역의 개수,
 * 영역의 크기 -> 배열 또는 리스트로(오름차순이니까 리스트에 넣어서 Collections.sort 돌리기)
 */