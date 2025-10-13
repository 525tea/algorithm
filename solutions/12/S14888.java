import java.io.*;
import java.util.*;

public class S14888V3 {
    static int N;
    static int[] arr; // 입력 수열
    static int[] calc; // 연산자의 개수 + _ * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        calc = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            calc[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs (int tot, int cur) {
        // base condition
        if (cur == N) {
            max = Math.max(max, tot);
            min = Math.min(min, tot);
            return;
        }

        // 재귀
        if (calc[0] > 0) { // +
            calc[0]--;
            dfs(tot + arr[cur], cur + 1);
            calc[0]++; // 원복
        }
        if (calc[1] > 0) { // -
            calc[1]--;
            dfs(tot - arr[cur], cur + 1);
            calc[1]++;
        }
        if (calc[2] > 0) { // *
            calc[2]--;
            dfs(tot * arr[cur], cur + 1);
            calc[2]++;
        }
        if (calc[3] > 0) { // /
            calc[3]--;
            dfs(tot / arr[cur], cur + 1);
            calc[3]++;
        }
    }
}
/**
 * n의 depth에서 연산자 a를 쓰고 재귀호출로 최대 depth까지 내려간 후에
 * 다시 n의 depth로 돌아와서 연산자 a를 안 쓰고, 다른 연산자를 시도 -> 원복이 필요
 *
 * 백트래킹은 DFS(깊이 우선 탐색) 구조 위에서,
 * 각 depth(즉, 현재 상태)에서 하나의 선택을 했다가,
 * 밑으로 내려가서 모든 경우를 다 탐색한 다음
 * 되돌아와서 그 선택을 취소(원복)하고 다른 선택지를 시도하는 알고리즘
 */