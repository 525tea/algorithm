import java.io.*;
import java.util.*;

public class S15656 {
    static int N, M;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        func(0);
        System.out.println(sb);
    }

    static void func(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[k] = list.get(i);
            func(k + 1);
        }
    }
}

/**
 * 주어진 N개의 수에서 M개의 수를 중복 포함하여 뽑는 수열
 * (중복 허용 O, 입력된 수의 오름차순 순서대로 출력)
 */