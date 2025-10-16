package s03;

import java.io.*;
import java.util.StringTokenizer;

public class B10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            min = Math.min(min, val);
            max = Math.max(max, val);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(max);
        System.out.println(sb);
    }
}