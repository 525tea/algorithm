package s03;

import java.io.*;
import java.util.StringTokenizer;

public class B1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (double) arr[i] / max * 100;
        }

        System.out.println(sum / N);
    }
}