package s04;

import java.io.*;

public class B1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (str.trim().isEmpty()) {
            System.out.println(0);
        } else {
            String[] tokens = str.trim().split(" "); // 엄밀하게는 "\\s+"을 사용. 하나 이상의 공백
            System.out.println(tokens.length);
        }
    }
}
