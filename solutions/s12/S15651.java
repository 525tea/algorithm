package s12;
import java.io.*;
import java.util.*;

public class S15651 {
    static int N, M;
    static int[] arr; // 선택할 수를 저장하는 수열(temporary)
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        func(0);
        System.out.println(sb);
    }

    static void func (int k) { // arr[k]를 선택하는 함수
        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[k] = i; // arr[k] = i -> arr[k+1] = x, ... 이렇게 최대 깊이 M까지 채우고 돌아와서 arr[k] = i+1, i+2, ...로 시도
            func(k + 1);
        }
    }
}

/**
 * 1부터 N까지 N개의 수 중에서 중복을 포함해 M개를 고르는 수열
 */