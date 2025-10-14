package s12;
import java.io.*;
import java.util.*;

public class G16987 {
    static int N;
    static int[] s; // 내구도
    static int[] w; // 무게
    static int mx = 0; // 최대 깨진 계란 수
    static int cnt = 0; // 현재 깨진 계란 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        s = new int[N];
        w = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(mx);
    }

    static void dfs(int a) { // a번째 계란으로 다른 계란을 칠 차례
        if (a == N) {
            mx = Math.max(mx, cnt);
            return;
        }

        // 현재 계란이 깨져있거나, 이미 나머지 전부 깨졌으면 다음으로
        if (s[a] <= 0 || cnt == N - 1) {
            dfs(a + 1);
            return;
        }

        for (int t = 0; t < N; t++) { // a번째 계란과 t번째 계란을 친다
            if (t == a || s[t] <= 0) continue; // 자기 자신이거나 이미 깨진 계란 skip

            // 상태 변화
            s[a] -= w[t];
            s[t] -= w[a];

            if (s[a] <= 0) cnt++;
            if (s[t] <= 0) cnt++;

            dfs(a + 1); // 다음 계란으로

            // 원복 (backtrack)
            if (s[a] <= 0) cnt--;
            if (s[t] <= 0) cnt--;
            s[a] += w[t];
            s[t] += w[a];
        }
    }
}

/**
 * 계란이 N개 있으면
 * 0번째 계란과 다른 계란들
 * 1번째 계란과 다른 계란들
 * ...
 * N-1번째 계란과 다른 계란들
 *
 * 이걸 다 탐색
 * k번째 계란의 k -> depth
 */