package s04;

import java.io.*;

public class S11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(str.charAt(i)+"");
        }
        System.out.println(sum);
    }
}
