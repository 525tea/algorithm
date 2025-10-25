package s15;

import java.io.*;
import java.util.*;

public class G14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 1];
        int[] d = new int[N + 1];
        int[] prev = new int[N + 1]; // 이전 원소의 인덱스

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(d, 1); // 디폴트 - 자기 자신 싱글턴

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxIdx = 1;
        int maxD = d[1];
        for (int i = 2; i <= N; i++) {
            if (maxD < d[i]) {
                maxD = d[i];
                maxIdx = i;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int curIdx = maxIdx;
        while (curIdx != 0) {
            stack.push(a[curIdx]);
            curIdx = prev[curIdx];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxD).append("\n"); // maxD == stack.size() 치환 가능
        while (!stack.isEmpty()) {
             sb.append(stack.pop()).append(" ");
         }
        System.out.println(sb);
    }
}

/**
 * LIS + 경로 복원
 *
 * 1. dp
 *  D[i] = a[i]를 마지막 원소로 하는 LIS
 *  prev[i] = LIS에서 i번째 원소 이전의 원소의 인덱스
 *
 * 2. 점화식
 * i번째 원소를 앞의 LIS에 붙일 수 있고, 더 긴 LIS를 만들 수 있을 때
 *
 *  a[j] < a[i] 이고, d[i] < d[j] + 1 일 때(더 큰 값으로 갱신 가능)
 *  -> d[i] = d[j] + 1
 *  -> prev[i] = j
 *
 * 3. 초기값
 *  d[i] = 1
 *  prev[i] = 0
 *
 * 4.복원
 *  - dp[]의 최댓값의 인덱스 i 찾기
 *  - prev[]를 역추적해서 인덱스 역순 찾기, 스택에 값 a[] LI
 *  - 스택에서 FO 정순 뽑기
 *
 *  시간복잡도: O(N^2)
 *  공간복잡도: O(N)
 */