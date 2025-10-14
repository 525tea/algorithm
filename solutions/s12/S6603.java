package s12;
import java.io.*;
import java.util.*;

public class S6603 {
    static int k;
    static int[] S; // 입력 수열
    static int[] selected; // 선택 수열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;
            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            selected = new int[k];
            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs (int start, int cur) { // 선택 수열의 selected[cur]를 선택하는 함수
        // base condition
        if (cur == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            selected[cur] = S[i];
            dfs(i + 1, cur + 1);
        }
    }
}
