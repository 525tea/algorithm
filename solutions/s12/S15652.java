package s12;
import java.io.*;
import java.util.StringTokenizer;

public class S15652 {
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

    static void func (int start, int k) {
        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[k] = i;
            func(i, k + 1); // 현재 선택한 수를 포함해서 다음 수를 선택할 수 있음
        }
    }
}

/**
 * 1부터 N까지 N개의 수에서 M개의 수를 중복을 포함해서, 비내림차순으로(A_i <= A_i+1) 뽑는 수열
 */