package s12;
import java.io.*;
import java.util.*;

public class S15657 {
    static int N, M;
    static int[] arr;
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
        Collections.sort(list);

        arr = new int[M];
        func(0, 0);
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

        for (int i = start; i < N; i++) {
            arr[k] = list.get(i);
            func(i, k + 1); // 현재 선택한 수를 포함해서 다음 수를 선택할 수 있음
        }
    }
}

/**
 * 주어진 N개의 수에서 M개의 수를 뽑는 수열 (중복 포함 o, 비내림차순) => 중복 순열
 */