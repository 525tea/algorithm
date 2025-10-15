package s09;
import java.io.*;
import java.util.*;

public class G2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        int avg = sum / 5;
        System.out.println(avg);
        System.out.println(arr[2]);
    }
}
