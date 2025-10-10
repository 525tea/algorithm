import java.io.*;
import java.util.*;

public class S15666 {
    static int N, M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        func(0, 0);
        System.out.println(sb);
    }

    static void func(int start, int k) {
        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 같은 depth 내 중복 방지용
        for (int i = start; i < N; i++) {
            if (arr[i] == prev) continue; // 같은 수면 건너뛰기
            selected[k] = arr[i];
            prev = arr[i];
            func(i, k + 1);
        }
    }
}