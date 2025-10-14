package s12;
import java.io.*;
import java.util.*;

public class S15649 {
    static int N, M;
    static int[] arr; // 현재 단계에서 선택한 숫자의 배열
    static boolean[] isUsed; // 특정 수가 쓰였는지의 여부
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M]; // arr[0], ... , arr[M-1]
        isUsed = new boolean[N + 1]; // i가 이미 선택되었는지의 여부. 1-based(0은 안쓰고 버림)

        func(0); // arr[]은 0-indexed
        System.out.print(sb);
    }

    // k번째 위치를 채우는 함수
    static void func(int k) {
        // base condition: M개를 모두 골랐을 때 출력
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false; // 재귀 종료 후 백트래킹 (상태 복원)
            }
        }
    }
}

/**
 * 순열
 */