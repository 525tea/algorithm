import java.io.*;
import java.util.*;

public class G1941 {
    static String[] board = new String[5];
    static boolean[] mask = new boolean[25]; // false면 선택된 칸
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine();
        }

        // 처음 7개는 false (선택), 나머지 18개는 true (비선택)
        Arrays.fill(mask, 7, 25, true);

        do {
            // BFS를 위한 자료구조 준비
            Queue<int[]> q = new LinkedList<>();
            boolean[][] isp7 = new boolean[5][5]; // 선택된 칸 표시
            boolean[][] vis = new boolean[5][5]; // 방문 체크

            int dasom = 0; // 'S'의 수
            int adj = 0;   // 연결된 칸 수

            // mask에서 false인 7칸을 선택
            for (int i = 0; i < 25; i++) {
                if (!mask[i]) {
                    int x = i / 5, y = i % 5;
                    isp7[x][y] = true;
                    if (q.isEmpty()) {
                        q.add(new int[]{x, y});
                        vis[x][y] = true;
                    }
                }
            }

            // BFS로 연결된 영역 탐색
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                adj++;
                if (board[x].charAt(y) == 'S') dasom++;

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                    if (vis[nx][ny]) continue;
                    if (!isp7[nx][ny]) continue;
                    q.add(new int[]{nx, ny});
                    vis[nx][ny] = true;
                }
            }

            if (adj >= 7 && dasom >= 4) ans++;

        } while (nextPermutation(mask));

        System.out.println(ans);
    }

    // Java에서 C++의 next_permutation 구현
    static boolean nextPermutation(boolean[] arr) {
        int i = arr.length - 1;
        while (i > 0 && !arr[i - 1] && arr[i]) i--;
        if (i == 0) return false;

        int j = arr.length - 1;
        while (!arr[i - 1] && arr[j]) j--;
        boolean temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        int k = arr.length - 1;
        while (i < k) {
            boolean t = arr[i];
            arr[i] = arr[k];
            arr[k] = t;
            i++;
            k--;
        }
        return true;
    }
}