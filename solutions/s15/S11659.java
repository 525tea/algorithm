package s15;

import java.io.*;
import java.util.StringTokenizer;

public class S11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] val = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        int[] d = new int[N + 1]; // prefix sum
        d[0] = 0;
        for (int i = 1; i <= N; i++) {
            d[i] = d[i - 1] + val[i];
        }

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(d[j] - d[i - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
