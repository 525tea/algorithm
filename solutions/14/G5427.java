import java.io.*;
import java.util.*;

public class G5427 {
    static int W, H; // 행, 열
    static char[][] map;
    static int[][] fireDist;
    static int[][] playerDist;
    static int sx, sy; // 플레이어 시작 좌표
    static Queue<int[]> fireQ;
    static Queue<int[]> playerQ;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new char[H][W];
            fireDist = new int[H][W];
            playerDist = new int[H][W];
            fireQ = new ArrayDeque<>();
            playerQ = new ArrayDeque<>();

            for (int i = 0; i < H; i++) {
                Arrays.fill(fireDist[i], -1);
                Arrays.fill(playerDist[i], -1);
            }

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        sx = i; sy = j;
                        playerDist[sx][sy] = 0; // 플레이어의 시작점 -> 거리 0으로 초기화
                        playerQ.offer(new int[]{sx, sy});
                    } else if (map[i][j] == '*') { // 불의 시작점
                        fireDist[i][j] = 0; // 불의 시작점 -> 거리 0으로 초기화
                        fireQ.offer(new int[]{i, j});
                    }
                }
            }

            fireBFS(); // 선행 BFS

            int result = playerBFS();
            sb.append(result == -1 ? "IMPOSSIBLE\n" : result + "\n");
        }
        System.out.print(sb);
    }


    static void fireBFS() {
        while (!fireQ.isEmpty()) {
            int[] cur = fireQ.poll();
            int x = cur[0], y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue; // 범위 아웃
                if (map[nx][ny] == '#' || fireDist[nx][ny] != -1) continue; // 벽 or 이미 방문

                fireDist[nx][ny] = fireDist[x][y] + 1;
                fireQ.offer(new int[]{nx, ny});
            }
        }
    }

    static int playerBFS() {
        while (!playerQ.isEmpty()) {
            int[] cur = playerQ.poll();
            int x = cur[0], y = cur[1];

            if (x == 0 || x == H - 1 || y == 0 || y == W - 1) { // 탈출 조건: 테두리 도달 (어차피 큐에 들어갔다는 건 빈 공간이었다는 뜻이므로 체크는 안함)
                return playerDist[x][y] + 1;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                if (map[nx][ny] == '#' || playerDist[nx][ny] != -1) continue;
                if (fireDist[nx][ny] != -1 && playerDist[x][y] + 1 >= fireDist[nx][ny]) continue; // 이동할 노드가 미래에 불이 전파됨 && 도착 속도가 플레이어보다 빠름

                playerDist[nx][ny] = playerDist[x][y] + 1;
                playerQ.offer(new int[]{nx, ny});
            }
        }
        return -1;
    }
}

/**
 *
 * 플레이어의 시작 위치 저장, dist 0 저장
 * 불의 시작점 저장, dist 0 저장
 * 그외 dist -1로 초기화
 *
 * fire bfs
 * 진행하며 거리 기록
 *
 * player bfs
 * -> 불에 잡히면 -1 return -> 플래그
 * -> 탈출 조건 : 테두리 && 빈 공간('.')에 도달하면 탈출
 *
 * 출력
 * playerBfs == -1 -> "IMPOSSIBLE" 출력
 * 그외 -> 탈출 시간 출력
 */