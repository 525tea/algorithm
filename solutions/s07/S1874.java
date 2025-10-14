package s07;
import java.io.*;
import java.util.*;

public class S1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 1;
        boolean isValid = true;

        for (int num : arr) {
            while (cur <= num) {
                stack.push(cur++);
                sb.append("+").append("\n");
            }

            if (stack.peek() == num) {
                stack.pop();
                sb.append("-").append("\n");
            } else {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}