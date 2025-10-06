import java.io.*;
import java.util.*;

public class G4179V2 {
    static int R, C; // 행, 열
    static char[][] map;
    static int[][] fireDist;
    static int[][] playerDist;
    static final int INF = (int) 1e9; // 불이 도달하지 않은 곳
    static int sx, sy; // 플레이어 시작 좌표
    static Queue<int[]> fireQ;
    static Queue<int[]> playerQ;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireDist = new int[R][C];
        playerDist = new int[R][C];
        fireQ = new ArrayDeque<>();
        playerQ = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireDist[i], INF);
            Arrays.fill(playerDist[i], -1);
        }

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                if (map[r][c] == 'J') {
                    sx = r; sy = c;
                    playerDist[sx][sy] = 0; // 플레이어의 시작점 -> 거리 0으로 초기화
                    playerQ.offer(new int[]{sx, sy});
                } else if (map[r][c] == 'F') { // 불의 시작점
                    fireDist[r][c] = 0; // 불의 시작점 -> 거리 0으로 초기화
                    fireQ.offer(new int[]{r, c});
                }
            }
        }

        fireBFS(); // 선행 BFS

        int result = playerBFS();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }


    static void fireBFS() {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue; // 범위 아웃
                if (map[nx][ny] == '#' || fireDist[nx][ny] != INF) continue; // 벽 or 이미 방문

                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }
    }

    static int playerBFS() {
        while (!playerQ.isEmpty()) {
            int[] cur = playerQ.poll();
            int x = cur[0], y = cur[1];

            // 탈출 조건: 가장자리에서 한 칸 더 나가면 됨
            if (x == 0 || y == 0 || x == R-1 || y == C-1) {
                return(playerDist[x][y] + 1);
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (map[nx][ny] == '#' || playerDist[nx][ny] != -1) continue;
                if (playerDist[x][y] + 1 >= fireDist[nx][ny]) continue; // 이동할 노드가 미래에 불이 전파됨 && 도착 속도가 플레이어보다 빠름

                playerDist[nx][ny] = playerDist[x][y] + 1;
                playerQ.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}