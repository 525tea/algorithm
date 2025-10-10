import java.io.*;
import java.util.StringTokenizer;

public class S15650V1 {
    static int N, M;
    static int[] arr; // 수열 저장(temporary)
    static boolean[] isUsed; // 선택 여부 저장
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isUsed = new boolean[N + 1];

        func(1, 0);
        System.out.println(sb);
    }

    static void func (int start, int k) { // start부터 시작해서 뽑아 arr[k]를 채우는 함수
        // base condition
        if (k == M) { // 완성된 수열 출력
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                func(i + 1, k + 1); // i(현재) 다음 수부터 선택 가능
                isUsed[i] = false;
            }
        }
    }

}

/**
 * 1부터 N까지 N개의 수에서 M개의 수를 뽑는 수열
 */