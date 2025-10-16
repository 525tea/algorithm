package s03;

import java.io.*;

public class B2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int idx = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(idx + 1);
        System.out.println(sb);
    }
}