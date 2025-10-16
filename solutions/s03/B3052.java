package s03;

import java.io.*;

public class B3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[42]; // 나머지
        for (int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            int rem = input % 42;
            arr[rem] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < 42; i++) {
            if (arr[i] == 1) cnt++;
        }
        System.out.println(cnt);
    }
}