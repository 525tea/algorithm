package s15;

import java.io.*;
import java.util.StringTokenizer;

public class G2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동전의 종류
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] d = new int[K + 1];
        d[0] = 1; // 0원을 만드는 경우의 수는 1 (아무것도 안 씀)

        for(int i = 1; i <= N; i++) {
            for (int j = coin[i]; j <= K; j++)
                d[j] += d[j - coin[i]];
        }

        System.out.println(d[K]);
    }
}
/**
 * 1. dp
 * d[j] = 금액 j원을 만드는 경우의 수
 * j = 0(동전 안 씀), coin[1] ~ K
 *
 * 2. 점화식
 * j = coin[1] ~ K (만들 수 있는 금액은 0, coin 조합으로 만들 수 있는 최솟값 ~ 최댓값)
 *
 * d[j] += d[j - coin[i]]
 * j원을 만드는 경우의 수는 d[j - coin[i]](i번째 코인을 한번 덜 쓴) 경우의 수를 누적한 합과 같음
 *
 * 3. 초기값
 * d[0] = 1 : 0원을 만드는 경우의 수 = 아무 동전도 사용하지 않음
 */