package s14;
import java.io.*;
import java.util.*;

public class G16933 {
    static class Node {
        int x, y, n, day;
        Node(int x, int y, int n, int day) {
            this.x = x; this.y = y; this.n = n; this.day = day;
        }
    }

    static int N, M, K;
    static int[][] map;
    static int[][][][] dist; // [x][y][n][day], n: 벽 부순 횟수(0<=n<=K), day: 0(낮)/1(밤)
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M][K+1][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
//                for (int k = 0; k <= K; k++) Arrays.fill(dist[i][j][k], -1); // 시간 초과 -> 삭제
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        ArrayDeque<Node> q = new ArrayDeque<>();
        dist[0][0][0][0] = 1; // 낮(0)에서 시작
        q.offer(new Node(0, 0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x, y = cur.y, n = cur.n, day = cur.day;

            if (x == N - 1 && y == M - 1) return dist[x][y][n][day];

            // 이동
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0) { // 빈 칸
                    if (dist[nx][ny][n][1-day] != 0) continue;
                    dist[nx][ny][n][1-day] = dist[x][y][n][day] + 1;
                    q.offer(new Node(nx, ny, n, 1-day));
                }
                else if (map[nx][ny] == 1) { // 벽
                    if (day != 0 || n >= K) continue; // 낮 + 아직 가능할 때만
                    if (dist[nx][ny][n+1][1-day] != 0) continue;
                    dist[nx][ny][n+1][1-day] = dist[x][y][n][day] + 1;
                    q.offer(new Node(nx, ny, n+1, 1-day));
                }
            }

            // 기다리기(밤일 때만)
            if (day == 1 && dist[x][y][n][0] == 0) {
                dist[x][y][n][0] = dist[x][y][n][1] + 1;
                q.offer(new Node(x, y, n, 0));
            }
        }
        return -1;
    }
}
/**
 * 낮(0)
 * - 이동
 *  ㄴ 빈 칸(0) 이동 가능, 벽(1) 부수고 이동 가능
 * - 기다리기 가능 <- 안함
 * - 다음 상태 : 밤(1)
 *
 * 밤(1)
 * - 이동
 *  ㄴ 빈 칸(0) 이동 가능, 벽(1) 부수고 이동 불가능
 * - 기다리기 가능
 * - 다음 상태 : 낮(0)
 *
 * 4차원으로 관리
 * [x][y][n][day]
 * n - 벽 부순 횟수
 * day - 0(낮)/밤(1)
 *
 *
 * 구현
 * 다음이 빈 칸
 * -> 낮, 밤 둘 다 이동 가능
 * -> 방문 체크
 * -> 이동 후 day만 전환
 *
 * 다음이 벽
 * -> 낮에만 이동 가능, n <= K-1일 때만 이동 가능
 * -> 방문 체크
 * -> 이동 후 day 전환, n++
 */

/**
 * BFS 큐에 넣고 빼는 용도로 Node 클래스 도입함
 */