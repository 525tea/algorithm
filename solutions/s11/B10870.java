package s11;
import java.io.*;

public class B10870 {
    static long[] dp = new long[100]; // 메모이제이션, 문제조건보다 더 큰 수가 들어오는 문제일 경우 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fibo(N));
    }

    static long fibo (int n) {
        // base condition
        if (n <= 0) return 0;
        if (n == 1) return 1;

        if (dp[n] != 0) return dp[n]; // 이미 계산된 값이면 리턴

        return dp[n] = fibo(n - 1) + fibo(n - 2);
    }
}

/**
 * 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
 * 이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
 * n=17 일때 까지 피보나치 수를 써보면 다음과 같다.
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
 *
 * n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
 */