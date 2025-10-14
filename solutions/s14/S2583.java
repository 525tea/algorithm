package s14;
import java.io.*;
import java.util.*;

public class S2583 {
    static int M, N, K; // 행, 열, 사각형 개수
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        // 사각형 채우기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); // 열
            int y1 = Integer.parseInt(st.nextToken()); // 행
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    map[r][c] = 1;
                }
            }
        }

        List<Integer> areas = new ArrayList<>();
        int cnt = 0;

        // BFS 실행
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 0 && !visited[r][c]) {
                    areas.add(bfs(r, c));
                    cnt++;
                }
            }
        }

        // 정렬 및 출력
        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (int a : areas) sb.append(a).append(" ");
        System.out.println(sb);
    }

    static int bfs(int sr, int sc) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d], nc = c + dy[d];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (map[nr][nc] != 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                size++;
            }
        }
        return size;
    }
}
/**
 * 값 : 영역의 개수, 각 영역의 크기
 * M행 N열 사각형 K개
 * (x1, y1) (x2, y2) -> (열, 행)
 *
 * 0에 대해서 탐색, Flood Fill(연결 요소 탐색)
 */