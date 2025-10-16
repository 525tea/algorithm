package s03;

import java.io.*;
import java.util.StringTokenizer;

public class B2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[9][9];
        int max = Integer.MIN_VALUE;
        int idx_x = -1;
        int idx_y = -1;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    idx_x = i + 1;
                    idx_y = j + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n').append(idx_x).append(' ').append(idx_y);
        System.out.println(sb);
    }
}