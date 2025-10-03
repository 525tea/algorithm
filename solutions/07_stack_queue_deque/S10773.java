import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        while (N-- > 0) {
            int in = Integer.parseInt(br.readLine());

            if (in == 0) stack.pop();
            else stack.push(in);
        }

        int sum = 0;
        while (!stack.isEmpty()) sum += stack.pop();

        System.out.println(sum);
    }
}