package s03;

import java.io.*;
import java.util.StringTokenizer;

public class S2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[100][100];

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x + 10; i++) {
                for (int j = y; j < y + 10; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int cnt = 0;
        for (int[] ints : arr) {
            for (int i : ints) {
                if (i == 1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}