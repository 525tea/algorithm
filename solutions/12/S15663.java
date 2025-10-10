import java.io.*;
import java.util.*;

public class S15663 {
    static int N, M;
    static int[] arr;         // 입력된 수열 -> 중복이 있을 수 있으므로 선택을 저장하는 배열과 분리함
    static int[] selected;    // 선택한 수열
    static boolean[] isUsed;  // 방문 여부
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];
        isUsed = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 사전순 정렬
        func(0);
        System.out.println(sb);
    }

    static void func(int k) {
        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1; // 이전에 선택한 수 (중복 방지용)
        for (int i = 0; i < N; i++) {
            if (!isUsed[i] && arr[i] != prev) {
                selected[k] = arr[i];
                isUsed[i] = true;
                prev = arr[i]; // 현재 수를 같은 depth의 중복 방지용으로 기억
                func(k + 1);
                isUsed[i] = false; // 원복 (백트래킹)
            }
        }
    }
}

/**
 * 주어진 N개의 수 중에서(중복 있을 수도 O) M개를 뽑는 수열 => 중복 순열
 */