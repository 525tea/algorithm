package s12;
import java.io.*;
import java.util.*;

public class S15664 {
    static int N, M;
    static int[] arr; // 입력 수열
    static int[] selected;
    static boolean[] isUsed;
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

        int prev = -1;
        for (int i = start; i < N; i++) {
            if (!isUsed[i] && arr[i] != prev) {
                selected[k] = arr[i];
                isUsed[i] = true;
                prev = arr[i];
                func(i + 1, k + 1);
                isUsed[i] = false;
            }
        }
    }
}

/**
 * 주어진 N개의 수 중에서(중복 있을 수도 O) M개를 비내림차순으로 뽑는 수열
 * - 입력된 수 중 중복 원소가 존재할 수 있음
 * - 같은 수라도 인덱스가 다르면 다른 원소로 취급
 * - 결과 수열에서 중복된 수열은 한 번만 출력
 *
 * 재귀호출된 순서에서의 탐색은 start + 1에서 시작하므로 엄밀하게는 isUsed 필요 없음, 생략 가능
 */