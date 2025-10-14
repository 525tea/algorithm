package s07;
import java.io.*;
import java.util.*;

public class S24511 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ds = new int[N]; // 자료구조의 타입/ 0: 큐, 1: 스택
        int[] init = new int[N]; // 초기화

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) ds[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) init[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> dq = new ArrayDeque<>();

        // 큐(0)인 자료구조만 사용 -> 초기 원소 삽입
        for (int i = N - 1; i >= 0; i--) {
            if (ds[i] == 0) dq.offerLast(init[i]); // addLast() 동일
        }

        // 삽입할 수열
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) dq.addLast(Integer.parseInt(st.nextToken()));

        // 앞에서 M개 뽑기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) sb.append(dq.pollFirst()).append(" ");
        System.out.println(sb);
    }
}