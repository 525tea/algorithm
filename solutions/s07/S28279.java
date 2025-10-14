package s07;
import java.io.*;
import java.util.*;

public class S28279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1:
                    int X = Integer.parseInt(st.nextToken());
                    deque.offerFirst(X);
                    break;
                case 2:
                    int Y = Integer.parseInt(st.nextToken());
                    deque.offerLast(Y);
                    break;
                case 3:
                    if(!deque.isEmpty()) sb.append(deque.pollFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case 4:
                    if(!deque.isEmpty()) sb.append(deque.pollLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case 5:
                    sb.append(deque.size()).append("\n");
                    break;
                case 6:
                    if(deque.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case 7:
                    if(!deque.isEmpty()) sb.append(deque.peekFirst()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case 8:
                    if(!deque.isEmpty()) sb.append(deque.peekLast()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
