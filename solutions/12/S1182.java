import java.io.*;
import java.util.*;

public class S1182V2 {
    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func(0, 0);
        if (S == 0) count--; // 공집합 제외
        System.out.println(count);
    }

    static void func(int cur, int tot) {
        // base condition
        if (cur == N) {
            if (tot == S) count++;
            return;
        }

        // 현재 원소를 선택하지 않는 경우
        func(cur + 1, tot);

        // 현재 원소를 선택하는 경우
        func(cur + 1, tot + arr[cur]);
    }
}