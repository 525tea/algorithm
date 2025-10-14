package s12;
import java.io.*;
import java.util.*;

public class S15654 {
    static int N, M;
    static int[] arr;
    static boolean[] isUsed; // 특정 수가 쓰였는지의 여부
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list); // 오름차순 정렬

        arr = new int[M];
        isUsed = new boolean[N]; // 방문 여부 체크

        func(0);
        System.out.println(sb);
    }

    static void func(int k) {
        // base condition
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) { // 중복 방지
                arr[k] = list.get(i);
                isUsed[i] = true;
                func(k + 1);
                isUsed[i] = false; // 백트래킹 (상태 복원)
            }
        }
    }
}

/**
 * 주어진 N개의 수에서 M개의 수를 뽑는 수열 (중복 포함x, 오름차순) => 순열
 */