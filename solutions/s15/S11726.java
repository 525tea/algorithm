package s15;

import java.io.*;

public class S11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int mod = 10007;

        int[] d = new int[N + 1];
        d[1] = 1;
        d[2] = 2;

        for (int i = 3; i <= N; i++) {
            d[i] = (d[i - 1] + d[i - 2]) % mod;
        }

        System.out.println(d[N]);
    }
}