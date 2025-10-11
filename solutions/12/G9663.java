import java.io.*;
import java.util.*;

public class G9663V3 {
    static int N;
    static boolean[] isUsed1 = new boolean[40]; // 같은 열 체크
    static boolean[] isUsed2 = new boolean[40]; // 오른쪽 위 대각선 (r+c)
    static boolean[] isUsed3 = new boolean[40]; // 왼쪽 위 대각선 (r-c+n-1)
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        func(0);
        System.out.println(count);
    }

    static void func(int cur) {
        // base condition: 모든 행에 퀸을 배치한 경우
        if (cur == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // 같은 열, 대각선에 이미 퀸이 있으면 건너뛰기
            if (isUsed1[i] || isUsed2[i + cur] || isUsed3[cur - i + N - 1]) continue;

            // 현재 위치에 퀸 배치
            isUsed1[i] = true;
            isUsed2[i + cur] = true;
            isUsed3[cur - i + N - 1] = true;

            func(cur + 1); // 다음 행으로 이동

            // 백트래킹 (원상복구)
            isUsed1[i] = false;
            isUsed2[i + cur] = false;
            isUsed3[cur - i + N - 1] = false;
        }
    }
}