import java.io.*;
import java.util.StringTokenizer;

public class S15650V2 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        func(1, 0);
        System.out.println(sb);
    }

    static void func(int start, int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) sb.append(arr[i]).append(' ');
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[k] = i;
            func(i + 1, k + 1);
        }
    }
}

/**
 * 1부터 N까지 N개의 수에서 M개의 수를 뽑는 수열 => 조합
 *
 * 즉, start로 이전의 선택보다 큰 수를 보장하기 때문에 isUsed로 선택 여부 체크 불필요
 */