package s11;
import java.util.*;
import java.io.*;

public class S1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(long a, long b, long m) {
        if (b == 1) return a % m;   // base case
        long val = pow(a, b/2, m);
        val = (val * val) % m;          // 제곱 후 mod
        if (b % 2 == 0) return val;     // b가 짝수면 그대로 반환
        return val * a % m;           // 홀수면 a 한 번 더 곱함
    }
}