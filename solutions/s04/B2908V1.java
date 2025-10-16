package s04;

import java.io.*;
import java.util.StringTokenizer;

public class B2908V1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder num1 = new StringBuilder(st.nextToken());
        StringBuilder num2 = new StringBuilder(st.nextToken());

        int rev1 = Integer.parseInt(num1.reverse().toString());
        int rev2 = Integer.parseInt(num2.reverse().toString());
        System.out.println(Math.max(rev1, rev2));
    }
}
