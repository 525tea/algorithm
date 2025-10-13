import java.io.*;
import java.util.*;

public class G1759V2 {
    static int L, C;
    static char[] can; // 입력 알파벳 배열
    static char[] selected; // 선택 알파벳 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        can = new char[C];
        selected = new char[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            can[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(can);

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs (int start, int cur) {
        // base condition
        if (cur == L) {
            int vowelcnt = 0;
            for (int i = 0; i < L; i++) {
                char c = selected[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowelcnt++;
            }
            int conscnt = L - vowelcnt;
            if (vowelcnt >= 1 && conscnt >= 2) {
                for (int i = 0;  i < L; i++) {
                    sb.append(selected[i]);
                }
                sb.append('\n');
            }
            return;
        }

        // 재귀
        for (int i = start; i < C; i++) {
            selected[cur] = can[i];
            dfs(i + 1, cur + 1);
        }
    }
}
/**
 * 4개를 뽑아서 만드는 수열
 * 모음 최소 1개
 * 자음 최소 2개
 *
 * 일단 알파벳 후보 배열 돌며 L개를 픽
 * depth = L이 되면
 * 검증 - 모음 개수 세서, 모음이 1개 이상인지, 자음(L-모음)이 2개 이상인지
 * 통과하면 출력
 */