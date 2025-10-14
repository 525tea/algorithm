package s12;
import java.io.*;
import java.util.*;

public class S14889 {
    static int N;
    static int[][] arr; // 조합 테이블
    static int[] can; // 선수 목록 0~N-1(N명)
    static boolean[] draftS; // S팀의 선 지명 체크
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        can = new int[N];
        for (int i = 0; i < N; i++) can[i] = i + 1;
        draftS = new boolean[N];

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    static void dfs (int start, int cur) { // S팀의 cur번째 선수를 뽑는 함수
        // base condition
        if (cur == N/2) {
            int teamS = 0;
            int teamL = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // S팀의 능력치
                    if (draftS[i] && draftS[j]) {
                        teamS += arr[i][j];
                    }
                    // L팀의 능력치
                    else if(!draftS[i] && !draftS[j]) {
                        teamL += arr[i][j];
                    }
                }
            }
            min = Math.min(min, Math.abs(teamS - teamL));
        }

        for (int i = start; i < N; i++) {
            if (!draftS[i]) {
                draftS[i] = true; // teamS 선지명
                dfs(i + 1, cur + 1);
                draftS[i] = false;
            }
        }

    }
}

/**
 * N/2명씩 각 팀의 선수로 뽑는다
 * 이걸 배열에 저장
 *
 * N/2 깊이까지 선택이 끝나면 각 팀의 조합 합을 구한다
 * 두 팀의 능력치 차이를 구한다
 * 이 차이를 min에 계속 업데이트한다
 * 모든 깊이와 루트에 대한 탐색이 끝나면
 * min값을 출력한다
 */