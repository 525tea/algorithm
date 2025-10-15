package s09;
import java.io.*;
import java.util.*;

public class S11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int length = str.length();

        String[] arr = new String[length];
        for (int i = 0; i < length; i++) {
            arr[i] = str.substring(i); // str.substring(begin) - begin 인덱스부터 끝까지 자름, substring(int begin, int end) - begin 이상 end 미만 자름
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
