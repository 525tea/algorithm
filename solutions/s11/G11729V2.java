package s11;
import java.io.*;

public class G11729V2 {

    static void func(int a, int b, int n) { // 출발 기둥, 도착 기둥, 옮길 원판의 개수
        if (n == 1) {
            System.out.println(a + " " + b);
            return;
        }

        func(a, 6 - a - b, n - 1);  // ① 출발 → 보조 기둥으로 n-1개 이동
        System.out.println(a + " " + b); // ② 가장 큰 원판 이동
        func(6 - a - b, b, n - 1);  // ③ 보조 → 목표 기둥으로 n-1개 이동
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        System.out.println((1 << k) - 1); // 이동 횟수 = 2^k - 1, 1<<k : 2진수 1을 k칸 왼쪽으로 밀기
        func(1, 3, k); // 1번 기둥 → 3번 기둥으로 k개의 원판 이동
    }
}