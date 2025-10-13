import java.io.*;
import java.util.*;

public class G9663V4 {
    static int N; // 퀸의 개수
    static boolean[] isUsed1; // 같은 열 체크
    static boolean[] isUsed2; // '/' 대각선 체크, r+c
    static boolean[] isUsed3; // '\' 대각선 체크, r-c+(n-1)
    static int cnt; // 방법의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isUsed1 = new boolean[N]; // 열
        isUsed2 = new boolean[2 * N - 1]; // '/' 대각선. 엄밀하게는 0 ~ (N-1) + (N-1) = [0, 2N - 2]
        isUsed3 = new boolean[2 * N - 1]; // '\' 대각선. 엄밀하게는 0 ~ (N-1) + (N-1) = [0, 2N - 2]

        dfs(0);
        System.out.println(cnt);
    }

    static void dfs (int cur) { // cur 행에 퀸을 배치하는 함수
        // base condition
        if (cur == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) { // i열
            if (isUsed1[i] || isUsed2[cur + i] || isUsed3[cur - i + N - 1]) continue; // cur(r) - i(c) = -(N-1) ~ +(N-1) 이므로 음수 보정

            isUsed1[i] = true;
            isUsed2[cur + i] = true;
            isUsed3[cur - i + N - 1] = true;

            dfs(cur + 1);

            // 백트래킹
            isUsed1[i] = false;
            isUsed2[cur + i] = false;
            isUsed3[cur - i + N - 1] = false;
        }
    }
}

/**
 * 우선, 문제를 푸는 단계를 정하자
 * 한 행씩을 단계로 설정해 해당 단계에 배치할 수 있는 경우를 구하는 것이다
 * -> 행을 depth로 설정, 백트래킹
 *
 * 백트래킹?
 * depth 별로 내려 들어가며 배치 -> 재귀
 * , 모두 배치되면 이때의 경우의 수를 카운트
 *
 * 그럼 재귀는 어떻게?
 * 그냥 행별로 레벨 증가시키면서
 * 조건문은 어떻게?
 * 같은 열 || / 대각선 || \대각선
 *
 */