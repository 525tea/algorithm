import java.io.*;
import java.util.*;

public class G7576V3 {
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 열
        int N = Integer.parseInt(st.nextToken()); // 행

        map = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) q.offer(new int[]{i, j});
            }
        }
        int days = -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d], ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (map[nx][ny] != 0) continue; // visited 체크 필요X

                    map[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                }
            }
            days++; // 한 레벨(하루) 끝날 때마다 날짜++, 인접 정점이 없어도 날짜++
            // => 시작점이 0개여도 days = 0이 나옴
        }

        // 익지 않은 토마토 있는지 검사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(days);
    }
}
/**
 * 시작점 여러개인 멀티소스 BFS
 *
 * 일단, 초기상태 입력받으며 레벨1 시작점 큐에 모두 넣기
 *
 * 깊이(날짜) = -1 초기화
 * 큐 돌리기 {
 *  q.size = 시작점 개수
 *  for (시작점 개수만큼) {
 *      큐에서 시작점 뽑고
 *      for (시작점의 인접에 대해) {
 *
 *      }
 *  }
 *  한 레벨의 (시작점들에 대한) 탐색 끝 -> 깊이(날짜)++ => 1레벨 종료된 후 날짜 0 됨, 시작점 0개여도 날짜 0됨
 * }
 *
 * 출력
 * for문 돌며 0 남아있는지 찾기
 * if (남은 0 있음) -> -1
 * else -> 깊이
 *
 */