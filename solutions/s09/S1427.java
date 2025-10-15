package s09;
import java.io.*;
import java.util.*;

public class S1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int length = line.length();
        Integer[] arr = new Integer[length];
        for (int i = 0; i < length; i++) {
            arr[i] = line.charAt(i) - '0';
        }
        Arrays.sort(arr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
