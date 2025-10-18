package s15;

import java.io.*;

public class B24416 {
    static int[] d;
    static int cnt_recur, cnt_dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        recur(n);
        dp(n);

        System.out.println(cnt_recur + " " +cnt_dp);
    }

    static int recur (int n) {
        if (n == 1 || n == 2) {
            cnt_recur++;
            return 1;
        }
        return recur(n - 1) + recur(n - 2);
    }

    static int dp (int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3 ; i <= n ; i++) {
            d[i] = d[i - 1] + d[i - 2];
            cnt_dp++;
        }
        return d[n];
    }
}
