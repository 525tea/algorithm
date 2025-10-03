import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String menu = st.nextToken();

            switch (menu) {
                case "push": queue.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.pollFirst()).append("\n"); // poll() 가능
                    break;
                case "size": sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "front" :
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peekFirst()).append("\n");
                    break;
                case "back" :
                    if (queue.isEmpty()) sb.append("-1\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}